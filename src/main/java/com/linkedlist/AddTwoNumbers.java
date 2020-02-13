package com.linkedlist;

/**
 * AuThor：StAY_
 * Create:2020/2/13
 */
//注释里的解法是自己想的办法，可以看到有大量重复代码来进行分情况处理
//参照的方法核心的点是将两个长度不齐的链表，缺的位置用0来补齐 这样就不用像注释里的方法分 cur1短 cur2短 来处理了
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);
        ListNode cur1 = l1,cur2 = l2,cur3 = newHead;
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        int goOn = 0;//表示进位的数
        /*
       while(cur1!=null&&cur2!=null){
           int temp = cur1.val+cur2.val+goOn;
           ListNode node = new ListNode(temp%10);
           if(temp>=10){
               goOn=1;
           }else{
               goOn=0;
           }
           cur3.next=node;
           cur1 = cur1.next;
           cur2 = cur2.next;
           cur3 = cur3.next;
       }
       while(cur1!=null){
           int temp =(cur1.val+goOn);
           ListNode node = new ListNode(temp%10);
           if(temp>=10){
               goOn=1;
           }else{
               goOn=0;
           }
           cur3.next = node;
           cur3=cur3.next;
           cur1 = cur1.next;
       }
         while(cur2!=null){
           int temp =(cur2.val+goOn);
           ListNode node = new ListNode(temp%10);
           if(temp>=10){
               goOn=1;
           }else{
               goOn=0;
           }
           cur3.next = node;
           cur3=cur3.next;
             cur2=cur2.next;
       }*/
        while(cur1!=null||cur2!=null){
            int x = (cur1!=null)?cur1.val:0;
            int y = (cur2!=null)?cur2.val:0;
            int temp = x+y+goOn;
            ListNode node = new ListNode(temp%10);
            goOn=temp/10;
            cur3.next = node;
            if(cur1!=null)cur1=cur1.next;//为避免空指针，如果cur已经为空，指针就不必再往后走了
            if(cur2!=null)cur2=cur2.next;
            cur3 = cur3.next;
        }
        if(goOn>0){//如果有加到最后一位还要进位的情况，new一个结点链上去
            ListNode node = new ListNode(goOn);
            cur3.next=node;
        }
        return newHead.next;
    }
}
