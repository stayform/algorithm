package com.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * AuThor：StAY_
 * Create:2020/5/1
 */
//全排列II
public class PermuteUnique {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums.length==0||nums==null) return new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Arrays.sort(nums);
        backtrack(nums,new boolean[nums.length],arr);
        return res;
    }

    public void backtrack(int[] nums,boolean[] visited,List<Integer> arr){
        if(arr.size()==nums.length){
            res.add(new ArrayList<Integer>(arr));
            return ;
        }

        for(int i=0;i<nums.length;i++){
            if(visited[i]==true) continue;//在无重复数字的全排列中，这里写的是arr.contains(nums[i])，用值就可以锁定唯一的元素  但是因为这个题是有重复数据的，所以不能那么判断了 要用索引锁定元素
            if(i>0&&nums[i]==nums[i-1]&&visited[i-1]==true) continue;//元素相同而且以前一个元素为首的排列已经找过了 就不用再找了
            arr.add(nums[i]);
            visited[i]=true;
            backtrack(nums,visited,arr);
            arr.remove(arr.size()-1);
            visited[i]=false;
        }
    }
}
