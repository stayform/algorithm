package com.array;

/**
 * AuThor：StAY_
 * Create:2020/2/16
 */
//字符串反转-双指针法
public class ReverseString {
    public void reverseString(char[] s) {
        int front=0;
        int back=s.length-1;
        int count=s.length/2;
        while(count>0){
            if(s[front]!=s[back]){
                char temp = s[front];
                s[front] = s[back];
                s[back] = temp;
            }
            front++;
            back--;
            count--;
        }
    }
}
