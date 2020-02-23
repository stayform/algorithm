package com.hash;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * AuThor：StAY_
 * Create:2020/2/23
 */
//哈希映射
public class MyHashMap {
    private List<LinkedList<Integer>> keys;
    private List<LinkedList<Integer>> values;
    private static final int initSize=10;
    private int addSize=8;
    private int curSize;
    /** Initialize your data structure here. */
    public MyHashMap() {

        keys = new ArrayList<LinkedList<Integer>>();
        values = new ArrayList<LinkedList<Integer>>();
        for(int i=0;i<initSize;i++){
            keys.add(new LinkedList<Integer>());
            values.add(new LinkedList<Integer>());
        }
        curSize=initSize;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {

        if(!contains(key)){
            if(keys.size()<curSize&&keys.size()>=curSize*0.8){
                for(int i=0;i<addSize;i++){
                    keys.add(new LinkedList<Integer>());
                    values.add(new LinkedList<Integer>());
                }
            }
            keys.get(key%curSize).add(key);
            values.get(key%curSize).add(value);
        }else{
            remove(key);
            keys.get(key%curSize).add(key);
            values.get(key%curSize).add(value);

        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {

        if(contains(key)){
            int index=keys.get(key%curSize).indexOf(key);
            return values.get(key%curSize).get(index);
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {

        if(contains(key)){
            int index=keys.get(key%curSize).indexOf(key);
            values.get(key%curSize).remove(index);
            keys.get(key%curSize).remove(index);
        }


    }

    public boolean contains(int key){
        LinkedList<Integer> list= keys.get(key%curSize);
        for(Integer i:list){
            if(i==key){
                return true;
            }
        }
        return false;
    }
}
