package com.array;
//加一
/**
 * AuThor：StAY_
 * Create:2020/2/15
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            digits[i]++;
            digits[i] %=10;
            if(digits[i]!=0)//表示无进位
                return digits;
        }
        int[] digit = new int[digits.length+1];
        digit[0]=1;
        return digit;
    }


}
