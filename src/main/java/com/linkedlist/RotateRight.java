package com.linkedlist;

/**
 * AuThor：StAY_
 * Create:2020/2/14
 */
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }

        ListNode cur = head;
        int length = 1;
        while(cur.next!=null){
            length++;
            cur=cur.next;
        }
        cur.next=head;
        cur = head;
        for(int i=1;i<length-k%length;i++){
            cur=cur.next;
        }
        ListNode newHead = cur.next;
        cur.next=null;

        return newHead;

    }
}
