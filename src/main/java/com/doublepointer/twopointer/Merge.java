package com.doublepointer.twopointer;

/**
 * AuThor：StAY_
 * Create:2020/5/9
 */
//合并两个有序数组
//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m==0){
            for(int i=0;i<n;i++){
                nums1[i]=nums2[i];
            }
        }
        while(m!=0){
            if(n>0&&nums1[m-1]<nums2[n-1]){//比较两个数组最大的值
                nums1[m+n-1]=nums2[n-1];
                n--;//n往前走一步
            }else{
                nums1[m+n-1]=nums1[m-1];
                m--;//m往前走一步
            }
        }
        while(n!=0){
            nums1[m+n-1]=nums2[n-1];
            n--;
        }
    }
}
