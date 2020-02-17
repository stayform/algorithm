package com.array;

/**
 * AuThor：StAY_
 * Create:2020/2/17
 */
//旋转数组
public class Rotate {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);

    }
    public void reverse(int[] nums,int front,int back){
        while(front<back){
            int temp=nums[front];
            nums[front++]=nums[back];
            nums[back--]=temp;
        }

    }
    /**
     *时间复杂度太高的算法
     public void rotate(int[] nums, int k) {
     k =k%nums.length;
     for(int i=0;i<k;i++){
     int temp=nums[nums.length-1];
     for(int j=nums.length-1;j>0;j--){
     nums[j]=nums[j-1];
     }
     nums[0]=temp;
     }

     }*/
}
