package com.warren.fleet.thread.controller;

import com.warren.fleet.thread.thread.AsyncRunnable;
import com.warren.fleet.thread.thread.AsyncThread;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThreadController {

    @GetMapping("/runnable/async")
    public void asyncRunnable(){
        new AsyncRunnable("thread1").run();
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        new AsyncRunnable("thread2").run();
    }

    @GetMapping("/thread/async")
    public void asyncThread(){
        new AsyncThread("thread1").start();
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        new AsyncThread("thread2").start();
    }
}
