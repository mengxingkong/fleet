package com.warren.fleet.io.controller;

import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedReader;
import java.io.StringReader;

public class IOSearchController {

    //将字符串作为io的输入，并按行读取
    @GetMapping("/io/buffer")
    public void bufferTest(){

        String test = "def customImage =docker.build(dockertag).inside(\"--volume=/var/run/docker.sock:/var/run/docker.sock\") {  \n" +
                "\t\t\t}\n" +
                "docker.node {\n" +
                "\tdocker.script.sh \"docker push ${dockertag}\"\n" +
                "\tdocker.script.sh \"docker rmi ${dockertag}\"\n" +
                "}";

        try {
            StringReader stringReader = new StringReader(test);
            BufferedReader bufferedReader = new BufferedReader(stringReader);
            String str = null;
            while((str = bufferedReader.readLine()) != null)
            {
                System.out.println(str);
            }
            System.out.println(">>>>>>>");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
