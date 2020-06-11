package com.dp;

/**
 * AuThor：StAY_
 * Create:2020/6/11
 */
//把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
public class TwoSum {
    //dp数组第一行是一个骰子各种情况出现的次数  第二行是两个骰子各种情况出现的次数 每行长度是不一样的
    public double[] twoSum(int n) {
        if(n==0) return new double[0];
        //dp table
        int[][] dp = new int[n+1][6*n+1];//忽略0行0列 n个骰子（1~n） n个骰子可能出现6*n种情况(每一个骰子都是6种情况)
        for(int i=1;i<=6;i++){
            dp[1][i]=1;//如果只有一个骰子，每种情况出现的次数都是1
        }
        for(int i=2;i<=n;i++){//如果有i个骰子
            for(int s=i;s<=6*i;s++){//所有的情况是i~6*i
                for(int k=1;k<=6;k++){//当前这个骰子可能掷出的点数
                    if(s<k+(i-1)) break;
                    dp[i][s]+=dp[i-1][s-k];//俺看不懂为啥状态转移方程式这样的 为什么两个骰子出现3的次数是一个骰子出现1的次数+出现2的次数+出现3的次数
                }
            }
        }
        double total=Math.pow((double)6,(double)n);
        double[] ans = new double[5*n+1];
        for(int i=n;i<=6*n;i++){
            ans[i-n]=(double)(dp[n][i]/total);
        }
        return ans;
    }
}
