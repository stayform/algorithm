package com.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * AuThor：StAY_
 * Create:2020/4/29
 */
//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
public class Combine {
    //和全排列一个模板
    //不同点是掌握好每次的start,也就是每一层可供选择的系列的起点
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) {
            return res;
        }
        LinkedList<Integer> oneRow = new LinkedList<>();
        backtrack(n,k,1,oneRow);
        return res;
    }
    public void backtrack(int n,int k,int start,LinkedList<Integer> oneRow){
        if(oneRow.size()==k){
            res.add(new LinkedList<Integer>(oneRow));
            return;
        }
        //i<=n改进成i<=n-(k-oneRow.size())+1 能避免很多不符合条件的情况（可选择区间小于需要的数）
        for(int i=start;i<=n-(k-oneRow.size())+1;i++){
            if(oneRow.contains(i))
                continue;
            oneRow.add(i);
            backtrack(n,k,i+1,oneRow);
            oneRow.removeLast();
        }
    }
}
