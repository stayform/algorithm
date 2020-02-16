//实现strStr()
//暴力破解
package com.array;

/**
 * AuThor：StAY_
 * Create:2020/2/16
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        if(haystack.length()==0&&needle.length()==0){
            return 0;
        }
        for(int i=0;i<haystack.length()-needle.length()+1;i++){//在haystack的倒数第needle.length()位往后就不用循环了
            int j;
            for(j=0;j<needle.length();j++){
                if(haystack.charAt(i+j)!=needle.charAt(j)){
                    break;
                }
            }
            if(j==needle.length()){
                return i;
            }
        }
        return -1;
    }
}
