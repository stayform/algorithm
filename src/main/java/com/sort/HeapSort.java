package com.sort;

import java.util.Arrays;

/**
 * AuThor：StAY_
 * Create:2020/4/1
 */

/**
 * 思路：升序构建大顶堆，降序构建小顶堆。构建过程为；找倒数第一个非叶子结点，查找它下面有没有比他大的值，找到了的话交换位置。依次循环完成大顶堆的构建。
 * 大顶堆构建结束后交换顶元素和尾元素的位置，每一次交换完成都要重新构建大顶堆
 */
public class HeapSort {
    public static void sort(int[] arr){
        //1.构建大顶堆
        for(int i=arr.length/2-1;i>=0;i--){//从第一个非叶子结点开始
            adjustHeap(arr,i,arr.length);
        }

        //2.调整
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);
            adjustHeap(arr,0,j);
        }
    }

    public static void adjustHeap(int[] arr,int i,int length){
        int temp=arr[i];
        //注意：temp不是只需要一次交换就能到位的值，找到第一个比他大的结点时，让此结点覆盖堆里的值，而temp的归宿并不一定是这个结点，要继续向下进行比较，看是否还有比temp大的值，直到找到的值比temp小了，再将temp与最后一个比它大的值交换
        for(int k=i*2+1;k<length;k=k*2+1){
            if(k+1<length&&arr[k+1]>arr[k]){//如果右结点的值大于左结点
                k++;//k变为更大的右子结点的索引
            }
            if(temp<arr[k]){
                arr[i]=arr[k];
                i=k;//记录交换的结点的索引，以便赋值
            }else{
                break;
            }
        }
        arr[i]=temp;
    }
    public static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public static void main(String []args){
        int []arr = {7,3,6,4,9,8,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
