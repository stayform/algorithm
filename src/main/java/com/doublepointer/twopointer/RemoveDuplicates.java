package com.doublepointer.twopointer;

/**
 * AuThor：StAY_
 * Create:2020/5/6
 */
//删除排序数组中的重复项
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0||nums==null) return 0;
        int i=0;
        for(int j=1;j<nums.length;j++){

            if(nums[i]!=nums[j]){
                nums[i+1]=nums[j];
                i++;
            }
        }
        return i+1;
    }
}
