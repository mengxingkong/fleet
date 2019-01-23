package com.warren.fleet.common.util;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.Map;

@Service
public class HttpUtil {

    public String sendPost(String url, String filePath, Map<String,String> headParams){
        try{
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            for (Map.Entry<String,String> entry:headParams.entrySet()){
                headers.set(entry.getKey(),entry.getValue());
            }
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            FileSystemResource resource = new FileSystemResource(new File(filePath));
            MultiValueMap<String,Object> params = new LinkedMultiValueMap<>();
            params.add("partfile",resource);
            HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(params, headers);
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
            return response.getBody();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("发送http请求出错");
            return "exception";
        }
    }
}
