package com.dp;

/**
 * AuThor：StAY_
 * Create:2020/4/18
 */
public class UniquePaths {
    //除了第一行和第一列以外，每个点的路径都等于到此点上面的点的路径加上到此点左边的点的路径
    public int uniquePaths(int m, int n) {
        //DP table
        int[][] dp= new int[m][n];
        for(int i=0;i<m;i++)dp[i][0]=1;
        for(int j=0;j<n;j++)dp[0][j]=1;
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i][j-1]+dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
}
