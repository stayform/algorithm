package com.doublepointer.twopointer;

/**
 * AuThor：StAY_
 * Create:2020/5/7
 */
//盛最多水的容器
public class MaxArea {
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int maxA=Integer.MIN_VALUE;
        int temp;
        while(i<j){
            temp=Math.min(height[i],height[j]);
            maxA=Math.max(maxA,temp*(j-i));
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }
        return maxA;
    }
}
