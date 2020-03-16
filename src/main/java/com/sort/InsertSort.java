package com.sort;

/**
 * AuThor：StAY_
 * Create:2020/3/16
 */

/**
 * 插入排序
 * 分为有序（前半部分）和无序（后半部分）两部分
 * 每次取无序的第一个元素，倒着跟前半部分做比较，找到合适位置插入（设标志符以判断有没有插入）
 * 若没有插入的操作，则该元素应该是最小的，插入到nums[0]
 */
public class InsertSort {
    public static void sort(int[] nums){
        if(nums.length<=1)
            return;
        for(int i=1;i<nums.length;i++){
            int now = nums[i];//now中储存即将进行操作的数据
            boolean hasInsert = false;
            for(int j=i;j>0;j--){
                if(nums[j-1]>now){
                    nums[j]=nums[j-1];
                }else{
                    nums[j]=now;
                    hasInsert=true;
                    break;
                }
            }
            if(!hasInsert)
                nums[0]=now;
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
