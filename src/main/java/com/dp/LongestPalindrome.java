package com.dp;

/**
 * AuThor：StAY_
 * Create:2020/4/18
 */
public class LongestPalindrome {
    //暴力解法
    public String longestPalindrome(String s) {
        int len=s.length();
        if(len<2)
            return s;

        int maxLen=1;
        String res = s.substring(0,1);
        for(int i=0;i<len-1;i++)  {
            for(int j=i+1;j<len;j++){
                if(j-i+1>maxLen&&huiwen(s,i,j)){//长度大于当前最长字串的长度，而且是回文，才进行替换
                    maxLen=j-i+1;
                    res=s.substring(i,j+1);
                }
            }
        }
        return res;
    }

    boolean huiwen(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }

    //动态规划
    //如果前后两个字符相等，则继续判断里面的字符
    //如果不相等，则可直接判定不是回文字符
    public String longestPalindrome2(String s) {
        int len=s.length();
        if(len<2)
            return s;
        boolean[][] dp = new boolean[len][len];//DP table
        for(int i=0;i<len;i++){
            dp[i][i]=true;
        }
        int start=0;
        int maxLen=1;
        for(int j=1;j<len;j++){
            for(int i=0;i<j;i++){
                if(s.charAt(i)==s.charAt(j)){
                    if(j-1-(i+1)+1<2){//边界条件：如果在前后字符相等的情况下中间只有一个字符，则是回文字符串
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=dp[i+1][j-1];
                    }

                }else{
                    dp[i][j]=false;
                }
                if(dp[i][j]){
                    if (j-i+1 > maxLen) {
                        maxLen = j-i+1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start,start+maxLen);
    }
}
