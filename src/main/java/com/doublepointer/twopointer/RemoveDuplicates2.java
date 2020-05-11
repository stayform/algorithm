package com.doublepointer.twopointer;

/**
 * AuThor：StAY_
 * Create:2020/5/11
 */
//80.删除重复项
public class RemoveDuplicates2 {
    public int removeDuplicates(int[] nums) {
        int i=1;
        int count=1;
        int length = nums.length;
        while(i<length){
            if(nums[i-1]==nums[i]){
                count++;
                if(count>2){
                    removeD(nums,i);//用后面的元素把当前元素覆盖
                    length--;
                    i--;//删除一个元素，所以i--
                    count--;
                }
            }else{
                count=1;
            }
            i++;
        }
        return length;
    }

    int[] removeD(int[] nums,int index){
        for(int i=index+1;i<nums.length;i++){
            nums[i-1]=nums[i];
        }
        return nums;
    }
}
