package com.sort;

/**
 * AuThor：StAY_
 * Create:2020/3/11
 */
public class QuickSort {
    public void sort(int arr[]){
        if(arr.length==0||arr==null){
            return;
        }
        quickSort(arr,0,arr.length-1);
    }
    public void quickSort(int arr[],int left,int right){
        if(left>=right)
            return ;
        int pos = partition(arr,left,right);
        quickSort(arr,left,pos-1);
        quickSort(arr,pos+1,right);
    }
    //交换，直到两个指针重合，再把索引换到中间，返回中间位置索引给上级方法，上级再次递归排序左右两边
    public int partition(int arr[],int left,int right){
        int key = arr[left];
        int keyIndex = left;
        while(left<right){
            while(left<right&&arr[right]>=key)//一直移到后半部分倒数第一个小于等于索引的数
                right--;
            while(left<right&&arr[left]<=key)//一直移到前半部分第一个大于等于索引的数
                left++;
            swap(arr,left,right);
        }
        swap(arr,keyIndex,left);
        return left;
    }
    public void swap(int arr[],int left,int right){
        int temp=arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = {5,6,7,9,1,2,3};
        quickSort.sort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
