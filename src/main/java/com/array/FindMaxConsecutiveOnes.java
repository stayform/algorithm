package com.array;

/**
 * AuThor：StAY_
 * Create:2020/2/17
 */
//最大连续1的个数
public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {

        int k=0;
        int maxK=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                k++;
            }else{
                maxK=Math.max(maxK,k);
                k=0;
            }
            maxK=Math.max(maxK,k);
        }
        return maxK;
    }
}
