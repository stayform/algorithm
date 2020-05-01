package com.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * AuThor：StAY_
 * Create:2020/5/1
 */
//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//candidates 中的数字可以无限制重复被选取。
public class CombinationSum {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null||candidates.length==0)
            return new ArrayList<>();
        ArrayList<Integer> arr= new ArrayList<Integer>();
        backtrack(0,candidates,target,arr);
        return res;

    }
    public void backtrack(int start,int[] candidates, int target,ArrayList<Integer> arr){
        if(target<0) return;
        if(target==0){
            res.add(new ArrayList<Integer>(arr));
            return;
        }

        for(int i=start;i<candidates.length;i++){
            arr.add(candidates[i]);
            backtrack(i,candidates,target-candidates[i],arr);
            arr.remove(arr.size()-1);
        }
    }
}
