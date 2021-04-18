package com.doublepointer.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * AuThor：StAY_
 * Create:2020/5/6
 */
//最小覆盖子串
//给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
//输入: S = "ADOBECODEBANC", T = "ABC"
//输出: "BANC"
public class MinWindow {
    public String minWindow(String s, String t) {
        //left:窗口左 right:窗口右 count：已经有count个字符匹配成功 minLen:最小的匹配字符串长度
        int left,right,count,minLen= Integer.MAX_VALUE;
        int start=0,end=0;
        //window记录窗口里字符情况 needs记录t字符串的情况（是个固定的表）
        Map<Character,Integer> window = new HashMap<>();
        Map<Character,Integer> needs = new HashMap<>();
        
        //初始化needs
        for(int i=0;i<t.length();i++){
            //getOrDefault(t.charAt(i),0)+1 needs如果包含t.charAt(i)这个字符，取出value再+1，如果不包含，取0+1
            needs.put(t.charAt(i),needs.getOrDefault(t.charAt(i),0)+1);
        }

        left=right=count=0;
        //从最左边开始取
        while(right<s.length()){
            //取到当前值
            char temp=s.charAt(right);
            //如果needs里包含这个值，就把这个值添加到window里（或者说是刷新window里这个key的value） 检查needs和window里这个key的value是否相等？相等的话就count+1
            if(needs.containsKey(temp)){
                window.put(temp,window.getOrDefault(temp,0)+1);
                if(window.get(temp).compareTo(needs.get(temp))==0){
                    count++;
                }
            }
            //对这个字符操纵完毕，移步下一位
            right++;
            //窗口中的字符完全满足要求了，求此时的字符串长度，因为接下来要对字符串进行优化，所以将此时字符串的起止点另作保存
            while(count==needs.size()){
                if(right-left<minLen){//找到的新结果长度要小于之前找到的结果的长度才行
                    start=left;
                    end=right;
                    minLen=end-left;
                }
                //取当前符合要求的字符串的第一个值，如果needs里含有该值，试着将window里这个key所对应的value-1，如果减了1之后window里这个key的val小于needs里这个key的value了，就将匹配度count-1
                char c=s.charAt(left);
                if(needs.containsKey(c)){
                    window.put(c,window.getOrDefault(c,1)-1);
                    if(window.get(c)<needs.get(c)){
                        count--;
                    }
                }
                //然后看下一个字符
                left++;
            }
        }
        return minLen==Integer.MAX_VALUE? "" : s.substring(start,end);
    }
}
