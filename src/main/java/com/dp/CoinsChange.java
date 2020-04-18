package com.dp;

/**
 * AuThor：StAY_
 * Create:2020/4/18
 */
public class CoinsChange {
    public int coinChange(int[] coins, int amount) {
        if(coins.length<=0)
            return -1;
        int[] amo =new int[amount+1];//消除重复子问题用的备忘录 amo[i]表示凑够i元需要几个硬币
        amo[0]=0;
        for(int i=1;i<=amount;i++){
            int res=Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++){//求每个amo[i]时，用i减去各种面值的硬币构成子问题，看子问题中哪个是最优解
                if(i-coins[j]>=0&&amo[i-coins[j]]<res)//比如要求3元的最有解，而面值里有5元——>pass  第二子问题的解比第一个还大——>pass 比第一个小——>重置res
                    res=amo[i-coins[j]]+1;
            }
            amo[i]=res;
        }

        return amo[amount]==Integer.MAX_VALUE ? -1 : amo[amount];
    }

}
