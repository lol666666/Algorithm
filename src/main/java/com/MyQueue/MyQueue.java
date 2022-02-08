package com.MyQueue;

import java.util.ArrayList;
import java.util.List;

public class MyQueue {

    //store element
    private List<Integer> data;
    // a pointer indicate the start positions
    private int p_start;
    public MyQueue(){
        data = new ArrayList<Integer>();
        p_start=0;
    }

    //Insert an element into queue return true if operation  is successful

    public boolean enqueue(int x){
        data.add(x);
        return true;
    }

    // delete  an element  from the queue  return true if operation  is successful
    public boolean dequeue(){
        if(isEmpty() == true){
            return false;
        }
        p_start ++;
        return  true;
    }

    //Get the font from the queue or not
    public int Font(){
        return data.get(p_start);
    }
    //check empty
    public boolean isEmpty(){
        return p_start >= data.size();
    }


    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        if(myQueue.isEmpty() == false){
            System.out.println(myQueue.Font());
        }
        myQueue.dequeue();
        if(myQueue.isEmpty() == false){
            System.out.println(myQueue.Font());
        }
        myQueue.dequeue();
        if(myQueue.isEmpty() == false){
            System.out.println(myQueue.Font());
        }
    }

}
