package com.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * AuThor：StAY_
 * Create:2020/1/30
 */
class MyStack{
    List<Integer> data = new ArrayList<Integer>();
    /** initialize your data structure here. */
    public MyStack() {

    }
    public void push(int x) {
        data.add(x);
    }

    public boolean pop() {
        if(data.isEmpty()){
            return false;
        }
        data.remove(data.size()-1);
        return true;
    }

    public int top() {
        if(data.isEmpty()){
            return -1;
        }
        return data.get(data.size()-1);
    }

    public int getMin() {
        int min=data.get(data.size()-1);
        for(int i=data.size()-2;i>=0;i--){
            if(data.get(i)<min){
                min=data.get(i);
            }
        }
        return min;
    }
}

public class MinStack{
    public static void main(String[] args) {

        MyStack stack = new MyStack();

        stack.push(7);
        stack.push(5);
        stack.push(3);
        stack.push(6);
        stack.push(2);
        stack.pop();

        System.out.println("最小为"+stack.getMin()+"栈顶为"+stack.top());
    }
}