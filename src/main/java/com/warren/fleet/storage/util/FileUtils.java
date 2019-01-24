package com.warren.fleet.storage.util;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileUtils {

    public List<String> splitFile(String originFilePath){
        File originFile = null;
        FileInputStream input = null;
        try{
            originFile = new File(originFilePath);
            if(!originFile.exists() && !originFile.isFile()){
                System.out.println("不是合法文件类型，请重新输入");
                return null;
            }
            String parentFile = originFile.getParent();
            //没有判断当文件 本身小于 bufsize 的情况
            int bufsize = 1024*1024*20;
            byte[] buf = new byte[bufsize];
            int readCount;
            int index = 1;
            List<String> partFiles = new ArrayList<>();
            String preName = originFile.getName().substring(0, originFile.getName().lastIndexOf(".") );
            input = new FileInputStream( originFile );
            while( (readCount = input.read(buf) )>=1 ){
                String partFile = parentFile+"/"+preName+"-"+index+".tmp";
                FileOutputStream output = new FileOutputStream( new File( partFile ) );
                output.write(buf,0,readCount);
                output.close();
                partFiles.add(partFile);
                index++;
            }
            return partFiles;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            if(input!=null){
                try{
                    input.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
