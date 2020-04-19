package com.dp;

/**
 * AuThor：StAY_
 * Create:2020/4/19
 */
public class MinPathSum {
    //优化：可以不开辟新数组，直接将结果保存在原数组
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        //DP table
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&&j==0) {
                    dp[i][j]=grid[i][j];
                    continue;
                }else if(i==0){
                    dp[i][j]=dp[i][j-1]+grid[i][j];
                }
                else if(j==0){
                    dp[i][j]=dp[i-1][j]+grid[i][j];
                }else{
                    dp[i][j]=Math.min(dp[i-1][j]+grid[i][j],dp[i][j-1]+grid[i][j]);
                }
            }
        }
        return dp[m-1][n-1];
    }
}
