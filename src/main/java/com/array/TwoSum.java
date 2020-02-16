package com.array;

/**
 * AuThor：StAY_
 * Create:2020/2/16
 */
//两数之和II-输入有序数组
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int front=0;
        int back=numbers.length-1;
        while(front<back){
            if(numbers[front]+numbers[back]>target){
                back--;
            }
            if(numbers[front]+numbers[back]<target){
                front++;
            }
            if(numbers[front]+numbers[back]==target){
                result[0]=front+1;
                result[1]=back+1;
                return result;
            }
        }
        return result;
    }
}
