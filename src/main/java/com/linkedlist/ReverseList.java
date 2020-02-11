package com.linkedlist;

/**
 * AuThor：StAY_
 * Create:2020/2/11
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode prev = new ListNode(-1);
        ListNode tempNext;
        prev.next=head;
        while(head.next!=null){
            tempNext = head.next.next;
            head.next.next = prev.next;
            prev.next = head.next;
            head.next = tempNext;
        }
        return prev.next;
    }
}
