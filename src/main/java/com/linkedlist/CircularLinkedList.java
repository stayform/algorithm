package com.linkedlist;

/**
 * AuThor：StAY_
 * Create:2020/2/9
 */
class  ListNode{
    int val;
    ListNode next;
    ListNode(){

    }
    ListNode(int x){
        this.val = x;
        next = null;
    }
}
public class CircularLinkedList {
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow!=fast){
            if(fast==null||fast.next==null){
                return false;
            }
            slow = slow.next;
            fast=fast.next.next;
        }
        return true;
    }
}
