package com.linkedlist;

/**
 * AuThor：StAY_
 * Create:2020/2/9
 */
public class CircularLinkedList2 {
    public ListNode detectCycle(ListNode head){
        if(head==null||head.next==null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast=fast.next.next;
            if(fast==slow){
                break;
            }

        }
        if(fast==null||fast.next==null){
            return null;
        }

        ListNode ptr1 = head;
        ListNode ptr2 = slow;

        while(ptr1!=ptr2){
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
        return ptr1;
    }
}
