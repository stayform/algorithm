package com.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * AuThor：StAY_
 * Create:2020/5/2
 */
//子集
//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
public class Subsets {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length==0||nums==null) return new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        backtrack(nums,0,arr);
        return res;
    }
    public void backtrack(int[] nums,int start,List<Integer> arr){
        if(arr.size()>0){
            res.add(new ArrayList<Integer>(arr));
        }
        if(arr.size()==nums.length) return;
        for(int i=start;i<nums.length;i++){
            arr.add(nums[i]);
            backtrack(nums,i+1,arr);
            arr.remove(arr.size()-1);
        }
    }
}
