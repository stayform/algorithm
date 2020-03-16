package com.sort;

/**
 * AuThor：StAY_
 * Create:2020/3/16
 */

/**
 * 选择排序
 * 向数组第一位匹配最小的数，向数组第二位匹配第二小的数...以此类推
 */
public class SelectSort {
    public static void sort(int[] nums){
        int min;
        int minIndex;
        for(int i=0;i<nums.length;i++){
            min=nums[i];
            minIndex=i;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]<min){
                    min=nums[j];
                    minIndex=j;
                }
            }
            if(i!=minIndex)
            swap(nums,i,minIndex);
        }
    }

    public static void swap(int[] nums,int i,int minIndex){
        int temp = nums[i];
        nums[i] = nums[minIndex];
        nums[minIndex] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5,3,2,1,6};
        sort(nums);
        for(int i:nums){
            System.out.println(i);
        }
    }
}
