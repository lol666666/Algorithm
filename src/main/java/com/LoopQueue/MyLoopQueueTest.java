package com.LoopQueue;

public class MyLoopQueueTest {


    private int head;
    private int tail;
    private int length;
    private int data [];

    public MyLoopQueueTest(int k){
        head = 0;
        tail = 0;
        length = k+1;
        data = new int[length];
    }

    public boolean isEmpty(){
        return head ==tail;
    }
    public boolean isFull(){
        return (tail+1)%length == head;
    }
    public int isRear(){
        if(isEmpty()){
            return -1;
        }
        return data[(tail-1+length)%length];
    }
    public int isFront(){
        if(isEmpty()){
            return -1;
        }
        return data[head];
    }
    public boolean enQueue(int value){
        if(isFull()){
            return false;
        }
        data[tail] = value;
        tail = (tail+1)%length;
        return true;
    }
    public boolean deQueue(){
        if(isEmpty()){
            return false;
        }
        head = (head +1)%length;
        return true;
    }


    public static void main(String[] args) {
        MyLoopQueue myLoopQueue = new MyLoopQueue(3);
        myLoopQueue.enQueue(11);
        myLoopQueue.enQueue(12);
        myLoopQueue.enQueue(13);
        System.out.println(myLoopQueue.isFull());
        myLoopQueue.deQueue();
        System.out.println(myLoopQueue.isFull());

    }

}
