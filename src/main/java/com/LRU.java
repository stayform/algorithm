package com;

import java.util.HashMap;

/**
 * AuThor：StAY_
 * Create:2020/5/11
 */

//思想：使用哈希表+链表，哈希表主要是用来记录数据，链表主导页面顺序
public class LRU {
    //链表结点结构
    class Node{
        public int key,val;
        public Node next,pre;
        public Node(){
        }
        public Node(int k,int v){
            this.key=k;
            this.val=v;
        }
    }

        private static Node head;//链表头结点
        private static Node tail;//链表尾结点
        int size;//链表大小
        public void addFirst(Node x){
            x.next=head.next;
            x.pre=head;
            head.next.pre=x;
            head.next=x;
            size++;
        }
        public void remove(Node x){
             x.pre.next=x.next;
             x.next.pre=x.pre;

             size--;
        }
        public Node removeLast(){
            Node n = tail.pre;
            tail.pre.pre.next=tail;
            tail.pre=tail.pre.pre;
            size--;
            return n;
        }
        public int size(){
            return size;
        }

    //定义HashMap
    private HashMap<Integer,Node> map;
    private int cap;//设定最多能有几页

    //各项数据在构造函数里初始化
    public LRU(int cap){
        this.cap=cap;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next=tail;
        tail.pre=head;
    }

    //获取链表指定结点的val
    public int get(int key){

        if(!map.containsKey(key)){
            return -1;
        }
        int val=map.get(key).val;//map.get(key)是一个Node
        put(key,val);//根据规则，用到的页要被放到链表最前面
        return val;
    }

    public void put(int key,int val){
        Node n = new Node(key,val);//kv封装到新结点中
        //如果map不包含这个结点，比如说第一次插入
        if(map.containsKey(key)){
            remove(map.get(key));//删除链表中旧结点
            addFirst(n);//新结点添加到链表首位
            map.put(key,n);//更新map中的值
        }else{
            if(size==cap){
                Node last = removeLast();
                map.remove(last.key);
            }
            addFirst(n);
            map.put(key,n);
        }
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
        Node cur = head.next;
        while(cur.val!=0){
            System.out.print(" "+cur.val);
            cur=cur.next;
        }
    }

}
