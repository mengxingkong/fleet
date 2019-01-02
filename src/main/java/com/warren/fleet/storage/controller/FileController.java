package com.warren.fleet.storage.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

@RestController
public class FileController {

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



}
