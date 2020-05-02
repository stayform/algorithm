package com.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * AuThor：StAY_
 * Create:2020/5/2
 */
//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
//返回 s 所有可能的分割方案。
public class Partition {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s.length()==0||s==null) {
            return new ArrayList<>();
        }
        ArrayList<String> arr = new ArrayList<>();
        backtrack(s,0,arr);
        return res;
    }
    public void backtrack(String s,int start,ArrayList<String> arr){

        if(start==s.length()){
            res.add(new ArrayList<String>(arr));
            return ;
        }

        for(int i=start;i<=s.length()-1;i++){
            if(isHui(s.substring(start,i+1))){//依靠这个语句在每个""里填上不同个数的字符
                arr.add(s.substring(start,i+1));
                backtrack(s,i+1,arr);
                arr.remove(arr.size()-1);
            }

        }
    }




    public boolean isHui(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
