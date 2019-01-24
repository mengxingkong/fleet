package com.warren.fleet.storage.controller;

import com.google.gson.Gson;
import com.warren.fleet.common.domain.MsgResult;
import com.warren.fleet.common.util.HttpUtil;
import com.warren.fleet.storage.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FileController {


    @Autowired
    MsgResult msg;

    @Autowired
    FileUtils fileUtils;

    @Autowired
    HttpUtil httpUtil;

    @Autowired
    Gson g;

    /**
     *
     * 使用body中的 binary 传输数据，主要是记录一下 文件流的使用
     */
    @Transactional
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/cpfile/add")
    public String fileCustomAdd(@RequestBody MultipartFile file, @RequestHeader("uid") String fileid,
                                @RequestHeader("filename") String filename, @RequestHeader("filetype") String filetype,
                                @RequestHeader("owner") String owner, @RequestHeader("cpid") String cpid, HttpServletRequest request) {


        int len = request.getContentLength();
        byte buffer[] = new byte[len];
        try {
            InputStream in = request.getInputStream();
            int total = 0;
            int once = 0;
            while ((total < len) && (once >= 0)) {
                once = in.read(buffer, total, len);
                total += once;
            }
            //3
            OutputStream out = new BufferedOutputStream(
                    new FileOutputStream(filename, true));
            //byte[] breaker="\r\nNewLog: -------------------->\r\n".getBytes();
            System.out.println(request.getContentType());
            //out.write(breaker,0,breaker.length);
            out.write(buffer);
            out.close();

        } catch (Exception e) {
            e.printStackTrace();

        }

        return "ok";
    }

    @GetMapping("/file/fileTest1")
    public String fileTest1(@RequestHeader("filePath") String filePath){

        List<String> partFiles = fileUtils.splitFile( filePath );

        HashMap<String,String> headParams = new HashMap<>();
        headParams.put("uid","warrenzhangtest123");
        headParams.put("filename","china.mp4");
        headParams.put("filetype","other");
        headParams.put("owner","warrenzhang");
        headParams.put("cpid","warren-test-123");
        headParams.put("Authorization","eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ3YXJyZW56aGFuZyIsImF1ZCI6W3siYXV0aG9yaXR5IjoiUk9MRV9BRE1JTiJ9LHsiYXV0aG9yaXR5IjoiUk9MRV9VU0VSIn1dLCJjcmVhdGVkIjoxNTQ4MjgzMzU0MjE2LCJleHAiOjE1NDgzMTkzNTR9.WfKbDOn4yhuIOelLx4Y_UUGhb489MAPELm4iUEU1WDh7B91Y6dqUtexiXFurrONmi-bnoi6dZvP2w6xFtW_Bhg");
        headParams.put("total",partFiles.size()+"");

        for(int i=0;i<partFiles.size();i++){
            headParams.put("no",(i+1)+"");

            System.out.println( "filePath:"+partFiles.get(i) );

            //multiPart request
            FileSystemResource resource = new FileSystemResource(new File(partFiles.get(i)));
            try {
                System.out.println( resource.contentLength() );
            }
            catch (Exception e){
                e.printStackTrace();
            }


            //multiPart request
            //FileSystemResource resource = new FileSystemResource(new File(partFiles.get(i)));
            MultiValueMap<String,Object> requestParams = new LinkedMultiValueMap<>();
            requestParams.add("putFile",resource);

            try {
                String result = httpUtil.sendPost("http://127.0.0.1:8080/cpfile/add", requestParams, headParams);
                System.out.println(result);
            }catch (Exception e){
                break;
            }

        }

        System.out.println("测试结束");
        return "finish";

    }

    @GetMapping("/file/fileTest2")
    public String fileTest2(@RequestHeader("filePath") String filePath){
        List<String> partFiles = fileUtils.splitFile( filePath );

        HashMap<String,String> headParams = new HashMap<>();
        headParams.put("uid","warrenzhangtest123");
        headParams.put("filename","china.mp4");
        headParams.put("owner","warrenzhang");
        headParams.put("Authorization","eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ3YXJyZW56aGFuZyIsImF1ZCI6W3siYXV0aG9yaXR5IjoiUk9MRV9BRE1JTiJ9LHsiYXV0aG9yaXR5IjoiUk9MRV9VU0VSIn1dLCJjcmVhdGVkIjoxNTQ4MjgzMzU0MjE2LCJleHAiOjE1NDgzMTkzNTR9.WfKbDOn4yhuIOelLx4Y_UUGhb489MAPELm4iUEU1WDh7B91Y6dqUtexiXFurrONmi-bnoi6dZvP2w6xFtW_Bhg");
        headParams.put("total",partFiles.size()+"");


        for(int i=0;i<partFiles.size();i++){
            headParams.put("no",(i+1)+"");


            System.out.println( "filePath:"+partFiles.get(i) );

            //multiPart request
            FileSystemResource resource = new FileSystemResource(new File(partFiles.get(i)));
            try {
                System.out.println( resource.contentLength() );
            }
            catch (Exception e){
                e.printStackTrace();
            }


            //multiPart request
            //FileSystemResource resource = new FileSystemResource(new File(partFiles.get(i)));
            MultiValueMap<String,Object> requestParams = new LinkedMultiValueMap<>();
            requestParams.add("putFile",resource);

            try {
                String result = httpUtil.sendPost("http://127.0.0.1:8080/cpfile/updatef", requestParams, headParams);
                System.out.println(result);
            }catch (Exception e){
                break;
            }

        }

        return "finish";
    }


    @GetMapping("/file/fileTest3")
    public String fileTest3(@RequestHeader("filePath") String filePath){
        List<String> partFiles = fileUtils.splitFile( filePath );
        HashMap<String,String> headParams = new HashMap<>();
        headParams.put("Authorization","eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ3YXJyZW56aGFuZyIsImF1ZCI6W3siYXV0aG9yaXR5IjoiUk9MRV9BRE1JTiJ9LHsiYXV0aG9yaXR5IjoiUk9MRV9VU0VSIn1dLCJjcmVhdGVkIjoxNTQ4MjgzMzU0MjE2LCJleHAiOjE1NDgzMTkzNTR9.WfKbDOn4yhuIOelLx4Y_UUGhb489MAPELm4iUEU1WDh7B91Y6dqUtexiXFurrONmi-bnoi6dZvP2w6xFtW_Bhg");
        headParams.put("videoname","chinaPart.mp4");
        headParams.put("videotype","partTest");
//        headParams.put("description","part file upload test");
        headParams.put("total",partFiles.size()+"");

        for(int i=0;i<partFiles.size();i++){
            headParams.put("no",(i+1)+"");


            System.out.println( "filePath:"+partFiles.get(i) );

            //multiPart request
            FileSystemResource resource = new FileSystemResource(new File(partFiles.get(i)));
            try {
                System.out.println( resource.contentLength() );
            }
            catch (Exception e){
                e.printStackTrace();
            }
            MultiValueMap<String,Object> requestParams = new LinkedMultiValueMap<>();
            requestParams.add("video",resource);
            requestParams.add("description","part file upload test");
            try {
                String result = httpUtil.sendPost("http://127.0.0.1:8080/video/add", requestParams, headParams);
                System.out.println(result);
            }catch (Exception e){
                break;
            }
        }
        return "finish";
    }

    @GetMapping("/file/fileTest4")
    public String fileTest4(@RequestHeader("filePath") String filePath){
        List<String> partFiles = fileUtils.splitFile( filePath );
        HashMap<String,String> headParams = new HashMap<>();
        headParams.put("Authorization","eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ3YXJyZW56aGFuZyIsImF1ZCI6W3siYXV0aG9yaXR5IjoiUk9MRV9BRE1JTiJ9LHsiYXV0aG9yaXR5IjoiUk9MRV9VU0VSIn1dLCJjcmVhdGVkIjoxNTQ4MjgzMzU0MjE2LCJleHAiOjE1NDgzMTkzNTR9.WfKbDOn4yhuIOelLx4Y_UUGhb489MAPELm4iUEU1WDh7B91Y6dqUtexiXFurrONmi-bnoi6dZvP2w6xFtW_Bhg");
        headParams.put("videoname","chinaPart.mp4");
        headParams.put("videoversion","v0-1548316212519-30");
//        headParams.put("description","part file upload test");
        headParams.put("total",partFiles.size()+"");

        for(int i=0;i<partFiles.size();i++){
            headParams.put("no",(i+1)+"");


            System.out.println( "filePath:"+partFiles.get(i) );

            //multiPart request
            FileSystemResource resource = new FileSystemResource(new File(partFiles.get(i)));
            try {
                System.out.println( resource.contentLength() );
            }
            catch (Exception e){
                e.printStackTrace();
            }
            MultiValueMap<String,Object> requestParams = new LinkedMultiValueMap<>();
            requestParams.add("video",resource);
            requestParams.add("description","part file update test");
            try {
                String result = httpUtil.sendPost("http://127.0.0.1:8080/video/update", requestParams, headParams);
                System.out.println(result);
            }catch (Exception e){
                break;
            }
        }
        return "finish";
    }
}
