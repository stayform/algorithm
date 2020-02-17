package com.array;

/**
 * AuThor：StAY_
 * Create:2020/2/17
 */
//移除元素-数组
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[k]=nums[i];
                k++;//每确定一个存在的元素，k++
            }
        }
        return k;
    }
}
