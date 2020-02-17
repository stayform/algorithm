package com.array;

/**
 * AuThor：StAY_
 * Create:2020/2/17
 */
//长度最小的子数组
public class MinSubArrayLen {
    //滑动窗口法：找到和大于s的起点和终点 算出长度，left-- 若还大于 计算新的长度，与原长度进行比较 若不大于，则right++
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int min =Integer.MAX_VALUE;
        int left=0;
        int right=0;
        int sum=0;
        int begin=0;
        while(right<nums.length){
            sum +=nums[right];
            right++;
            while(sum>=s){
                min=Math.min(min,right-left);
                sum -=nums[left];
                left++;
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}
