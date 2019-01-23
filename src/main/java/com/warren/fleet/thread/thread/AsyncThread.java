package com.warren.fleet.thread.thread;

public class AsyncThread extends Thread {



    public AsyncThread(String name){
        super(name);
    }

    @Override
    public void run() {
        super.run();
        for(int i=0;i<100;i++){
            System.out.println( "this is "+ this.getName() +" "+i );
            try{
                sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
