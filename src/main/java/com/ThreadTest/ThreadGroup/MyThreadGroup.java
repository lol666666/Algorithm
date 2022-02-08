package com.ThreadTest.ThreadGroup;

import com.LoopQueue.MyLoopQueue;

public class MyThreadGroup extends ThreadGroup {

    public MyThreadGroup(String name){
        super(name);

    }

    @Override
    public void uncaughtException(Thread t,Throwable e){
        System.out.printf("the thread %s has thrown an exeption\n",t.getId());
        e.printStackTrace(System.out);

        System.out.printf("Terminate the rest of the threads\n");
        interrupt();
    }

}
