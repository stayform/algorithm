package com.doublepointer.twopointer;

/**
 * AuThor：StAY_
 * Create:2020/5/9
 */
//分隔链表
//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
public class Partition {
    public ListNode partition(ListNode head, int x) {
        ListNode minList = new ListNode(0);
        ListNode minCur = minList;
        ListNode maxList = new ListNode(0);
        ListNode maxCur = maxList;


        while(head!=null){
            if(head.val<x){
                minCur.next=head;
                minCur=minCur.next;
            }else{
                maxCur.next=head;
                maxCur=maxCur.next;
            }
            head=head.next;
        }
        minCur.next=maxList.next;
        maxCur.next=null;
        return minList.next;
    }
}
