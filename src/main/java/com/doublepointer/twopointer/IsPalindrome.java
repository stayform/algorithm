package com.doublepointer.twopointer;

/**
 * AuThor：StAY_
 * Create:2020/5/7
 */
//验证回文串
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        if(s.length()==0||s==null) return true;
        String low = s.toLowerCase();
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(!Character.isLetterOrDigit(low.charAt(i))){
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(low.charAt(j))){
                j--;
                continue;
            }
            if(low.charAt(i)!=low.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
