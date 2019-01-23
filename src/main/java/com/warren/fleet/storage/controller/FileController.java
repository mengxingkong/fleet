package com.warren.fleet.storage.controller;

import com.warren.fleet.common.util.HttpUtil;
import com.warren.fleet.storage.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class FileController {


    @Autowired
    FileUtils fileUtils;

    @Autowired
    HttpUtil httpUtil;

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

    @GetMapping("/file/split")
    public String fileSplit(@RequestHeader("filePath") String filePath){

        List<String> partFiles = fileUtils.splitFile( filePath );

        HashMap<String,String> params = new HashMap<>();
        params.put("filekey","tempFileTest");
        params.put("Authorization","eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ3YXJyZW56aGFuZyIsImF1ZCI6W3siYXV0aG9yaXR5IjoiUk9MRV9BRE1JTiJ9LHsiYXV0aG9yaXR5IjoiUk9MRV9VU0VSIn1dLCJjcmVhdGVkIjoxNTQ4MTI0OTMzOTI4LCJleHAiOjE1NDgxNjA5MzN9.LSPX_Hd63_BCxT0b-SNJJJu9_eY1NT_jeIP1uTDmeQDPi-LQtS1Z7Yrltp1TeOngM32tlI6gTRo2L93-CaLOxQ");
        params.put("total",partFiles.size()+"");

        for(int i=0;i<partFiles.size();i++){
            params.put("no",(i+1)+"");
            String result = httpUtil.sendPost("http://127.0.0.1:8080/file/merge",partFiles.get(i),params);
            System.out.println(result);
            params.remove("no");
        }

        System.out.println("测试结束");
        return "finish";

    }


}
