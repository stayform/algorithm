package com.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * AuThor：StAY_
 * Create:2020/5/1
 */
//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//candidates 中的每个数字在每个组合中只能使用一次。
public class CombinationSum2 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates==null||candidates.length==0)
            return new ArrayList<>();
        ArrayList<Integer> arr= new ArrayList<Integer>();
        Arrays.sort(candidates);//数组排序
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
            if(i>start&&candidates[i]==candidates[i-1]) continue;//如果下一个数字和上一个数字相同，就跳过这个字符不用找了
            arr.add(candidates[i]);
            backtrack(i+1,candidates,target-candidates[i],arr);
            arr.remove(arr.size()-1);
        }
    }
}
