package com.linkedlist;

/**
 * AuThor：StAY_
 * Create:2020/2/12
 */
public class PalindromeLink {
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next; //循环结束后slow就指向中间节点的前一个
        }
        slow = reverse(slow.next);
        while(slow!=null){
            if(head.val!=slow.val){
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head){
        if(head.next==null){
            return head;
        }
        ListNode newHead = reverse(head.next);//newHead是最后一个结点，是由最底层递归返回的，在次底层head是倒数第二个结点，依次往上推
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
