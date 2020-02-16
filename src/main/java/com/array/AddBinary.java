//二进制求和
package com.array;

/**
 * AuThor：StAY_
 * Create:2020/2/16
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder answer = new StringBuilder();
        int carry = 0;
        for(int i=a.length()-1,j=b.length()-1;i>=0||j>=0;i--,j--){
            int sum = carry;
            sum += i>=0 ? a.charAt(i)-'0':0;//进位加上a
            sum += j>=0 ? b.charAt(j)-'0':0;//再加上b
            answer.append(sum%2);
            carry = sum/2;
        }
        answer.append(carry==1?carry:"");
        return answer.reverse().toString();
    }
}
