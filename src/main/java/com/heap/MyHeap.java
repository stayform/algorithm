package com.heap;

import thread.IdGenerator;

/**
 * AuThor：StAY_
 * Create:2020/5/4
 */
//用堆实现优先级队列
public class MyHeap<Key extends Comparable<Key>>{
    private  Key[] pq;//存储元素的数组
    private int N=0;//当前队列中元素的个数

    public MyHeap(int cap){
        pq=(Key[])new Comparable[cap+1];
    }

    //返回当前队列中最大的元素
    public Key max(){
        return pq[1];
    }

    //插入元素
    //先插到尾部，再上浮
    public void insert(Key e){
        N++;
       pq[N]=e;
       swim(N);
    }

    //删除并返回当前队列中最大元素
    public Key delMax(){
        Key max = pq[1];
        exch(1,N);//把元素换到最后，删除
        sink(1);//把刚换上去的元素下沉到它该到的位置
        return max;
    }

    //上浮第k个元素
    private void swim(int k){
       while(k>1&&less(parent(k),k)){
           exch(parent(k),k);
           k=parent(k);
       }
    }

    //下沉第k个元素
    private void sink(int k){
        while(left(k)<=N){//确保k有左子节点
            int older=left(k);//假设左子节点大
            if(right(k)<=N&&less(older,right(k)))//如果有右子节点且右子节点更大
                older=right(k);//大节点就是右子节点
            if(less(older,k)) break;//k比两个结点都大，就不用下沉了
            exch(k,older);//交换存储的内容
            k=older;//k指向刚刚下沉的结点，继续往下判断需不需要下沉
        }

    }

    //交换数组的两个元素
    private void exch(int i,int j){
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    //pq[i]是否小于pq[j]
    private boolean less(int i,int j){
        return pq[i].compareTo(pq[j])<0;//<0说明pq[i]小 >0说明pq[i]大
    }

    int parent(int root){
        return root/2;
    }

    int left(int root){
        return root*2;
    }

    int right(int root){
        return root*2+1;
    }


    public static void main(String[] args) {
        int []arr = {7,3,6,4,9,8,2,1};
        MyHeap<Integer> mh = new MyHeap<>(arr.length);
        for(int i=0;i<arr.length;i++){
             mh.insert(arr[i]);
        }
        for(int i=0;i<arr.length;i++){
            System.out.println();
        }

    }
}
