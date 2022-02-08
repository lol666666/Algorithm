package com.ThreadTest.ThreadGroup;

import java.util.Random;

public class Task implements Runnable {


    public void run() {
        int result;
        Random random = new Random(Thread.currentThread().getId());
        while(true){
            result = 1000/((int)(random.nextDouble()* 100000000));
            if(Thread.currentThread().isInterrupted()){
                System.out.printf("%d interrrupted",Thread.currentThread().getId());
                return;
            }

        }

    }

    public static void main(String[] args) {
        int numberOfthreads = 2*Runtime.getRuntime().availableProcessors();
        MyThreadGroup myThreadGroup = new MyThreadGroup("MyThreadGroup");
        Task task =  new Task();
        for(int i =0;i<numberOfthreads;i++){
            Thread t = new Thread(myThreadGroup,task);
            t.start();

        }
        System.out.printf("Infomation about the Thread Group");
        myThreadGroup.list();
        Thread [] threads = new Thread[myThreadGroup.activeCount()];
        myThreadGroup.enumerate(threads);
        for(int i=0;i<threads.length;i++){
            System.out.printf("Thread %s:%s\n",threads[i].getName(),threads[i].getState());
        }

    }

}
