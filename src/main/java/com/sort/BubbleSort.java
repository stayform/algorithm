package com.sort;

/**
 * AuThor：StAY_
 * Create:2020/3/16
 */

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void sort(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            for(int j=0;j<nums.length-1-i;j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,3,2,1,6};
        sort(nums);
        for(int i:nums){
            System.out.println(i);
        }
    }
}
