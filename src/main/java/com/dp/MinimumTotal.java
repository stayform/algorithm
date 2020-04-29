package com.dp;

import java.util.List;

/**
 * AuThor：StAY_
 * Create:2020/4/29
 */
//三角形最小路径和
public class MinimumTotal {
    /**
     public int minimumTotal(List<List<Integer>> triangle) {
     if(triangle==null||triangle.size()==0){
     return 0;
     }

     int[][] dp = new int[triangle.size()+1][triangle.size()+1];
     for(int i=triangle.size()-1;i>=0;i--){
     List<Integer> row = triangle.get(i);
     for(int j=0;j<row.size();j++){
     dp[i][j]=row.get(j)+Math.min(dp[i+1][j],dp[i+1][j+1]);
     }
     }
     return dp[0][0];
     }*/
    //降低空间复杂度
    //理解关键词：dp[]数组是逐层覆盖的
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null||triangle.size()==0){
            return 0;
        }

        int[] dp = new int[triangle.size()+1];
        for(int i=triangle.size()-1;i>=0;i--){
            List<Integer> row = triangle.get(i);
            for(int j=0;j<row.size();j++){
                dp[j]=row.get(j)+Math.min(dp[j+1],dp[j]);//对于倒数第二层的j来说（称为它），dp[j]和dp[j+1]中存储的是倒数第一层与它相邻的两个结点的dp值
            }
        }
        return dp[0];
    }
}
