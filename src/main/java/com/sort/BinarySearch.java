package com.sort;

/**
 * AuThor：StAY_
 * Create:2020/3/11
 */
public class BinarySearch {
    public int search(int[] arr,int target){
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid]==target)
                return mid;
            else if(arr[mid]>target)
                right=mid-1;
            else if(arr[mid]<target)
                left=mid+1;
        }
        return -1;
    }

    public int searchLeft(int[] arr,int target){
        int left=0;
        int right=arr.length;
        while(left<right){
            int mid = (left+right)/2;
            if(arr[mid]==target)
                right=mid;
            else if(arr[mid]>target)
                right=mid;
            else if(arr[mid]<target)
                left=mid+1;
        }
        return left;
    }

    public int searchRight(int[] arr,int target){
        int left=0;
        int right=arr.length;
        while(left<right){
            int mid = (left+right)/2;
            if(arr[mid]==target)
                left=mid+1;
            else if(arr[mid]>target)
                right=mid;
            else if(arr[mid]<target)
                left=mid+1;
        }
        return left-1;//上面为了收缩后做下一步判断有left=mid+1的操作，所以真正的索引需要left-1
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {1,2,2,2,5};
        System.out.println(binarySearch.searchRight(arr,2));
    }
}
