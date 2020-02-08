package com.queue;

import java.util.Stack;

/**
 * AuThor：StAY_
 * Create:2020/2/8
 */
public class StackToQueue {
    private int front;
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(stack1.isEmpty()){//表明还没有元素
            front=x;//第一个元素，即为队首元素
        }
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack2.push(x);
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int i= stack1.pop();
        if(!stack1.isEmpty()){
            front=stack1.peek();
        }
        return i;
    }

    /** Get the front element. */
    public int peek() {
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
    }
}
