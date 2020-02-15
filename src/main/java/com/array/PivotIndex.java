package com.array;
//寻找数组中心索引
/**
 * AuThor：StAY_
 * Create:2020/2/15
 */
public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int total = 0;
        int leftsum = 0;
        for(int x:nums) total +=x;
        for(int i=0;i<nums.length;i++){
            if(leftsum==total-leftsum-nums[i])return i;
            leftsum +=nums[i];
        }
        return -1;
    }
}
