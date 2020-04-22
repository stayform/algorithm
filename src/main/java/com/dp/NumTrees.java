package com.dp;

/**
 * AuThor：StAY_
 * Create:2020/4/22
 */
//不同的二叉搜索树
public class NumTrees {
    //G(n)=f(1)+f(2)+....+f(n)  这里G（n）是与dp[]有关系的
    //f(i)=G(i-1)*G(n-i);//左树排列方式✖右树排列方式才等于所有排列方式
    public int numTrees(int n) {
        //DP table
        int[] dp = new int[n+1];//dp[i]——>结点个数为i时的能构成的二叉搜索树个数
        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<n+1;i++){//第一层循环：结点个数为i
            for(int j=1;j<i+1;j++){//第二层循环：第j个结点为跟结点
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
