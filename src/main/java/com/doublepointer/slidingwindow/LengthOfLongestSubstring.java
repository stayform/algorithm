package com.doublepointer.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * AuThor：StAY_
 * Create:2020/5/6
 */
//无重复字符的最长子串
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int left,right;
        int maxLen=Integer.MIN_VALUE;
        Map<Character,Integer> map = new HashMap<>();
        left=right=0;
        while(right<s.length()){
            char c = s.charAt(right);
            map.put(c,map.getOrDefault(c,0)+1);
            right++;
            while(map.get(c)>1){
                char c2 = s.charAt(left);
                int a=map.get(c2)-1;//问题：在这里对value进行改变并不能传达到while循环里，陷入无限循环
                left++;
            }
            maxLen=Math.max(maxLen,right-left);
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring2(String s) {
        if(s.length()==0||s==null) return 0;
        int left,right;
        int maxLen=Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        left=right=0;
        while(left<s.length()){
            if(right<s.length()&&!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
            }else{
                maxLen=Math.max(maxLen,right-left);
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLen;
    }


    public static void main(String[] args) {
        String s ="abcabcbb";
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        System.out.println(l.lengthOfLongestSubstring2(s));
    }
}
