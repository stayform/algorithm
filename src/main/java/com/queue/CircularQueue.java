package com.queue;

/**
 * AuThor：StAY_
 * Create:2020/1/19
 */
public class CircularQueue {
    private int[] data;
    private int head;
    private int tail;
    private int size;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public CircularQueue(int k) {
        data = new int[k];
        head = -1;
        tail = -1;
        size = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()==true){
            return false;
        }
        if(isEmpty()==true){
            head=0;
        }
        tail = (tail+1)%size;//为了保证循环所以这样计算tail(下一位的下标)
        data[tail] = value;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()==true){
            return false;
        }
        //在数组中只有一个元素的时候
        if(head==tail){
            head=-1;
            tail=-1;
            return true;
        }
        head = (head+1)%size;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()==false){
            return data[head];
        }else{
            return -1;
        }
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()==false){
            return data[tail];
        }else{
            return -1;
        }
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head==-1;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (tail+1)%size == head;
    }

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(3); // 设置长度为 3
        System.out.println(circularQueue.enQueue(1));  // 返回 true
        System.out.println(circularQueue.enQueue(2));  // 返回 true
        System.out.println(circularQueue.enQueue(3));  // 返回 true
        System.out.println(circularQueue.enQueue(4));  // 返回 false，队列已满
        System.out.println(circularQueue.Rear());  // 返回 3
        System.out.println(circularQueue.isFull());  // 返回 true
        System.out.println(circularQueue.deQueue());  // 返回 true
        System.out.println(circularQueue.enQueue(4));  // 返回 true
        System.out.println(circularQueue.Rear());
    }
}
