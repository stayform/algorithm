package com.linkedlist;

/**
 * AuThor：StAY_
 * Create:2020/2/12
 */
class DoublyListNode{
    int val;
    DoublyListNode prev = null;
    DoublyListNode next=null;
    public DoublyListNode(int val){
        this.val = val;
    }
}
public class MyDoublyListNode {


    public DoublyListNode head;
    public DoublyListNode tail;
    int size;
    /** Initialize your data structure here. */
    public MyDoublyListNode() {
        head = new DoublyListNode(-1);
        tail = new DoublyListNode(-1);
        size = 0;
        head.next=tail;
        tail.prev=head;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {//get下标为index的结点
        if (index < 0 || index >= size) return -1;
        DoublyListNode cur = head;
        for(int i=0;i<=index;i++){
            cur=cur.next;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        DoublyListNode node = new DoublyListNode(val);
        DoublyListNode cur = head;
        node.prev = cur;
        node.next = cur.next;
        cur.next.prev = node;
        cur.next = node;
        size++;

    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        DoublyListNode node = new DoublyListNode(val);
        DoublyListNode cur = tail;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index>size)return ;
        DoublyListNode node = new DoublyListNode(val);
        DoublyListNode cur = head;

        for(int i=0;i<index;i++){
            cur = cur.next;
        }
        node.prev = cur;
        node.next=cur.next;
        cur.next.prev = node;
        cur.next=node;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        DoublyListNode cur = head;
        for(int i=0;i<index;i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        cur.next.prev = cur;
        size--;
    }
    public void print(DoublyListNode head){
        DoublyListNode cur = head.next;
        while(cur.next!=null){
            System.out.print(cur.val+"  ");
            cur=cur.next;
        }
    }


    public static void main(String[] args) {
        MyDoublyListNode myDoublyListNode = new MyDoublyListNode();
        myDoublyListNode.addAtHead(1);
        myDoublyListNode.addAtTail(3);
        myDoublyListNode.addAtIndex(1,2);
        System.out.println("查找索引"+myDoublyListNode.get(1));
        myDoublyListNode.deleteAtIndex(1);
        myDoublyListNode.print(myDoublyListNode.head);
        System.out.println("查找索引："+myDoublyListNode.get(1));


    }
}
