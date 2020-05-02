package com.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * AuThor：StAY_
 * Create:2020/5/2
 */
//子集II
public class SubsetsWithDup {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length==0||nums==null) return new ArrayList<>();
        Arrays.sort(nums);
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
            if(i>start&&nums[i]==nums[i-1]) continue;
            arr.add(nums[i]);
            backtrack(nums,i+1,arr);
            arr.remove(arr.size()-1);
        }
    }
}
