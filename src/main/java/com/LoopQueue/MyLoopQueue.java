package com.LoopQueue;

/**
 * 在循环队列中，当队列为空时，有front=rear，而当所有队列空间全占满时，也有front=rear。为了区别这两种情况，
 * 规定循环队列最多只能有MaxSize-1个队列元素，当循环队列中只剩下一个空存储单元时，队列就已经满了。
 * 因此，队列判空的条件是front=rear，而队列判满的条件是front=（rear+1)%MaxSize。 [2]
 */

//为什么用mod，主要为循环序列，圆形，避免头尾重复

public class MyLoopQueue {
    private int data[];
    private int head;
    private int tail;
    private int length;

    public MyLoopQueue(int k){
        head=0;
        tail=0;
        length = k+1;
        data = new int[length];
    }

    public boolean isEmpty(){

        return head==tail;
    }
    public int Front(){
        if(isEmpty()){
            return -1;
        }
        return data[head];
    }
    public int Rear(){
        if(isEmpty()){
            return -1;
        }
       return data[(tail-1+length)% length];
    }

    public boolean isFull(){
        return (tail+1)%length ==head;
    }

    //判断是否可以添加，首先不满，另外需要尾部赋予新值，同时tail+1
    public boolean enQueue(int value){
        if(isFull()){
            return false;
        }
        data[tail]=value;
        tail=(tail+1)%length;
        return true;
    }
    //判断是否可以删除，首先不为空，另外需要头部+1
    public boolean deQueue(){
        if(isEmpty()){
            return false;
        }
        head =(head+1)%length;
        return true;
    }

    public static void main(String[] args) {
        MyLoopQueue myLoopQueue = new MyLoopQueue(3);
        myLoopQueue.enQueue(12);
        myLoopQueue.enQueue(13);
        myLoopQueue.enQueue(14);
        boolean test = myLoopQueue.enQueue(15);
        System.out.println(test);
        System.out.println(myLoopQueue.tail);
        System.out.println("****************");
        System.out.println((myLoopQueue.tail-1+myLoopQueue.length)% myLoopQueue.length);
        System.out.println("****************");
//        System.out.println((myLoopQueue.tail+1)%myLoopQueue.length);
        System.out.println(myLoopQueue.head);
        System.out.println(myLoopQueue.data.length);
        System.out.println("****************");
        System.out.println(myLoopQueue.isFull());
        System.out.println(myLoopQueue.Front());
        System.out.println(myLoopQueue.Rear());
        myLoopQueue.deQueue();
        System.out.println(myLoopQueue.Front());
        System.out.println(myLoopQueue.Rear());


    }
}


