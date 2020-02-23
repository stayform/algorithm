package com.hash;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * AuThor：StAY_
 * Create:2020/2/23
 */
//哈希集合
//哈希表的实现原理就是数组+链表，所以用动态数组和动态链表实现最为简单
public class MyHashSet {
    private List<LinkedList<Integer>> bucket;
    private static final int initSize=10;
    private int addSize=8;
    private int curSize;
    /** Initialize your data structure here. */
    public MyHashSet() {

        bucket = new ArrayList<LinkedList<Integer>>();
        for(int i=0;i<initSize;i++){
            bucket.add(new LinkedList<Integer>());
        }
        curSize=initSize;
    }

    public void add(int key) {


        if(!contains(key)){
            //动态扩容
            if(bucket.size()<curSize&&bucket.size()>=curSize*0.8){
                for(int i=0;i<addSize;i++){
                    bucket.add(new LinkedList<Integer>());
                }
                curSize +=addSize;
            }
            bucket.get(key%curSize).add(key);
        }

    }

    public void remove(int key) {

        if(contains(key)){
            bucket.get(key%curSize).removeFirstOccurrence(key);
        }
    }

    /** Returns true if this set contains the specified element */
    private boolean contains(int key) {

        LinkedList<Integer> list = bucket.get(key%curSize);
        for(Integer i:list){
            if(i==key){
                return true;
            }
        }
        return false;
    }
}


