package com.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * AuThor：StAY_
 * Create:2020/5/1
 */
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
public class GenerateParenthesis {
    //与之前的回溯不同的是每一次递归进去之后的选择列表是不同的，是依照当前s里的左右括号数量来定的，所以不能再固定一个选择列表，而是每次递归都要进行判断
    ArrayList<String> res = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        if(n==0) return new ArrayList<String>();
        backstrack(n,n,new StringBuilder().append(""));
        return res;
    }

    public void backstrack(int left,int right,StringBuilder s){
        if(left==0&&right==0){
            res.add(s.toString());
            return ;
        }


        if(left>0){
            s.append('(');
            backstrack(left-1,right,s);
            s.deleteCharAt(s.length()-1);
        }
        if(left<right){
            s.append(')');
            backstrack(left,right-1,s);
            s.deleteCharAt(s.length()-1);
        }

    }
}
