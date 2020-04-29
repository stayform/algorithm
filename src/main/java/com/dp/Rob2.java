package com.dp;

import java.util.Arrays;

/**
 * AuThor：StAY_
 * Create:2020/4/29
 */
public class Rob2 {
    //两种情况：抢第一家 抢最后一家
    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }else if(nums.length==1){
            return nums[0];
        }
        return Math.max(myRob(Arrays.copyOfRange(nums,0,nums.length-1)),myRob(Arrays.copyOfRange(nums,1,nums.length)));
    }

    public int myRob(int[] nums){
        int n=nums.length;
        int dp_i=0,dp_i1=0,dp_i2=0;
        for(int i=n-1;i>=0;i--){
            dp_i=Math.max(nums[i]+dp_i2,dp_i1);
            dp_i2=dp_i1;
            dp_i1=dp_i;
        }
        return dp_i;
    }
}
