package com.doublepointer.twopointer;

/**
 * AuThor：StAY_
 * Create:2020/5/7
 */
//颜色分类
public class SortColors {
    //left right 代表的是还没有赋予过正确值的位置
    public void sortColors(int[] nums) {
        if(nums.length==0||nums==null){
            return ;
        }

        int left=0;
        int right=nums.length-1;
        for(int i=0;i<=right;){
            if(nums[i]==0){
                int temp=nums[i];
                nums[i]=nums[left];
                nums[left]=temp;
                left++;
                i++;
            }else if(nums[i]==2){
                int temp=nums[i];
                nums[i]=nums[right];
                nums[right]=temp;
                right--;
            }else{
                i++;
            }
        }
    }
}
