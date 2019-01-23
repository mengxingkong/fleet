package com.warren.fleet.thread.thread;

public class AsyncRunnable implements Runnable {

    private String name;

    public AsyncRunnable(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println( "this is "+this.name+" thread: "+i );
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
