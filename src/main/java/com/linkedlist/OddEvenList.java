package com.linkedlist;

/**
 * AuThor：StAY_
 * Create:2020/2/11
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        ListNode evenHead = new ListNode(-1);
        ListNode odd = head;
        ListNode even = head.next;
        evenHead.next = odd.next;
        while(even!=null&&even.next!=null){

            odd.next = even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenHead.next;
        return head;

    }
}
