package com.dp;

/**
 * AuThor：StAY_
 * Create:2020/4/29
 */
public class Rob {
    /**
     //自顶向下
     public int rob(int[] nums) {
     if(nums.length==0){
     return 0;
     }else if(nums.length==1){
     return nums[0];
     }
     //dp[i]表示打劫到第i家时，最大的金额
     int[] dp = new int[nums.length];
     dp[0]=nums[0];
     dp[1]=Math.max(nums[0],nums[1]);
     for(int i=2;i<nums.length;i++){
     dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
     }
     return dp[dp.length-1];
     }*/
    /**
     public int rob(int[] nums) {
     //自底向上
     int n = nums.length;
     // dp[i] = x 表示：
     // 从第 i 间房子开始抢劫，最多能抢到的钱为 x
     // base case: dp[n] = 0
     int[] dp = new int[n + 2];
     for (int i = n - 1; i >= 0; i--) {//从最后一间房子开始抢
     dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
     }
     return dp[0];
     }*/
    public int rob(int[] nums) {
        int n = nums.length;
        //dp_i1表示后面一个房子 dp_i2表示后面两个房子
        int dp_i1=0,dp_i2=0,dp_i=0;
        for(int i=n-1;i>=0;i--){
            dp_i=Math.max(dp_i1,nums[i]+dp_i2);//dp_i表示如果从当前房子开始抢，最大能抢的金额
            dp_i2=dp_i1;
            dp_i1=dp_i;
        }
        return dp_i;
    }


}
