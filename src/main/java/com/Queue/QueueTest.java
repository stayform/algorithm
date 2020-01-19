package com.Queue;

import java.util.ArrayList;
import java.util.List;

/**
 * AuThor：StAY_
 * Create:2020/1/18
 */

class MyQueue{
    private List<Integer> data;

    public int getStart() {
        return start;
    }

    private int start;//首个元素的索引

    public MyQueue() {
        data = new ArrayList<Integer>();
        start = 0;
    }

    public boolean entryQueue(int x){
        data.add(x);
        return true;
    }

    public boolean deleteQueue(){
        if(isEmpty()==true){
            return false;
        }
        start++;
        return true;
    }

    public int firstData(){
       return data.get(start);
    }

    public boolean isEmpty(){
        return start>=data.size();
    }
}

public class QueueTest {
    public static void main(String[] args) {
        MyQueue mq = new MyQueue();
        mq.entryQueue(1);
        mq.entryQueue(2);
        mq.entryQueue(3);
        mq.entryQueue(4);
        mq.entryQueue(5);
        if(mq.isEmpty()==false){
            System.out.println(mq.firstData());
        }
        mq.deleteQueue();
        mq.deleteQueue();
        if(mq.isEmpty()==false){
            System.out.println(mq.firstData());
            System.out.println(mq.getStart());
        }
    }
}