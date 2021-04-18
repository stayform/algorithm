package com.sort;

/**
 * AuThor：StAY_
 * Create:2020/3/11
 */
public class QuickSort {
   public void sort(int[] arr){
        if(arr.length==0||arr==null){
            return;
        }
        quickSort(arr,0,arr.length-1);
    }

    /**
     * 负责划分
     * @param arr
     * @param left
     * @param right
     */

    public void quickSort(int[] arr,int left,int right){
        if(left>=right)
            return ;
        int pos = partition(arr,left,right);
        quickSort(arr,left,pos-1);
        quickSort(arr,pos+1,right);
    }

    /**
     * 负责进行位置调换
     * @param arr
     * @param left
     * @param right
     * @return
     */
    //交换，直到两个指针重合，再把索引换到中间，返回中间位置索引给上级方法，上级再次递归排序左右两边
    public int partition(int[] arr,int left,int right){
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

    /**
     * 负责交换
     * @param arr
     * @param left
     * @param right
     */
    public void swap(int[] arr,int left,int right){
        int temp=arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = {5,7,3,6,9,1,10};
        quickSort.sort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    /**
     * 单个方法版
     */
    /**
    private void quickSort(int[]  a ,int left,int right) {
        if(left < right){
            int i,j,t,temp;
            temp=a[left]; //temp中存的就是基准数
            i=left;
            j=right;
            while(i!=j)
            {
                //顺序很重要，要先从右边开始找
                while(a[j]>=temp && i<j)
                    j--;
                //再找左边的
                while(a[i]<=temp && i<j)
                    i++;
                //交换两个数在数组中的位置
                if(i<j)
                {
                    t=a[i];
                    a[i]=a[j];
                    a[j]=t;
                }
            }
            //最终将基准数归位
            a[left]=a[i];
            a[i]=temp;
            quickSort(a,left,i-1);//继续处理左边的，这里是一个递归的过程
            quickSort(a,i+1,right);//继续处理右边的 ，这里是一个递归的过程
        }
    }*/
}
