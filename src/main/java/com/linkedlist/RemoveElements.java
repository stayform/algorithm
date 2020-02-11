package com.linkedlist;

/**
 * AuThor：StAY_
 * Create:2020/2/11
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode cur = header;
        while(cur.next!=null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            } else{
                cur=cur.next;
            }
        }
        return header.next;
    }
}
