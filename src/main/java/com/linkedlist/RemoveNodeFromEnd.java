package com.linkedlist;

/**
 * AuThor：StAY_
 * Create:2020/2/10
 */
public class RemoveNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(-1);
        newHead.next=head;
        ListNode first = head;
        int length=0;
        while(first!=null){
            length++;
            first = first.next;
        }
        first=newHead;
        length-=n;

        while(length>0){
            first = first.next;
            length--;
        }
        first.next=first.next.next;
        return newHead.next;//不return head是考虑到删除第一个结点的情况
    }
}
