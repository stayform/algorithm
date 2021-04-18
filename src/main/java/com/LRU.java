package com;

import java.util.HashMap;
import java.util.List;

/**
 * AuThor：StAY_
 * Create:2020/5/11
 */

//思想：使用哈希表+链表，哈希表主要是用来记录数据，链表主导页面顺序


public class LRU{

    private HashMap<Integer,ListNode> map;
    private int cap;

    private static ListNode head;
    private static ListNode tail;
    int size;
    public LRU(int cap){
        map = new HashMap<>();
        this.cap=cap;
        head = new ListNode();
        tail = new ListNode();
        head.next=tail;
        tail.prev=head;
    }
    class ListNode{
        int key,val;
        ListNode prev,next;
        public ListNode(){}
        public ListNode(int key,int val){
            this.key=key;
            this.val=val;
        }
    }



    public void addFirst(ListNode x){
        x.next=head.next;
        x.prev=head;
        head.next.prev=x;
        head.next=x;
        size++;
    }

    public ListNode removeLast(){
        ListNode node = tail.prev;
        tail.prev=tail.prev.prev;
        tail.prev.next=tail;
        size--;
        return node;
    }
    public void remove(ListNode x){
        x.next.prev=x.prev;
        x.prev.next=x.next;

        size--;
    }
    public int size(){
        return size;
    }


    public void put(int key,int val){
        ListNode node = new ListNode(key,val);
        if(map.containsKey(key)){
            remove(map.get(key));
            addFirst(node);
            map.put(key,node);
        }else{
            if(size==cap){
                ListNode rm = removeLast();
                map.remove(rm.key);
            }
            addFirst(node);
            map.put(key,node);
        }
    }

    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }

        int val = map.get(key).val;
        put(key,val);
        return val;
    }

    @Override
    public String toString() {
        return map.keySet().toString();
    }

    public static void main(String[] args) {
        LRU cache = new LRU(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);

        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache);
        LRU.ListNode cur = head.next;
        while(cur.val!=0){
            System.out.print(" "+cur.val);
            cur=cur.next;
        }
    }
}
