package com.array;

import java.util.Arrays;

/**
 * AuThor：StAY_
 * Create:2020/2/16
 */
//数组拆分I
public class ArrayPairSum {
    public int arrayPairSum(int[] nums) {
        int sum=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;){
            sum+=nums[i];
            i+=2;
        }
        return sum;
    }
}
