package com.binarytree;

import java.util.ArrayList;

/**
 * AuThor：StAY_
 * Create:2020/5/20
 */
//二叉树层序遍历 按照数组输出
public class LevelOrder2 {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();//保存为一层一层的形式
    ArrayList<Integer> res = new ArrayList<>();//保存为一个list的形式
    //递归
    //此题中层数是递归的关键点
    public int[] levelOrder(TreeNode root) {
        if(root==null) return new int[0];
        int level=0;
        digit(root,level);
        for(ArrayList<Integer> arr:list){
            for(Integer i:arr){
                res.add(i);
            }
        }
        int[] result = new int[res.size()];
        for(int i=0;i<res.size();i++){
            result[i]=res.get(i);
        }
        return result;
    }
    public void digit(TreeNode root,int level){
        if(level==list.size()) list.add(new ArrayList<Integer>());
        list.get(level).add(root.val);
        if(root.left!=null)
            digit(root.left,level+1);
        if(root.right!=null)
            digit(root.right,level+1);
    }
    //广度优先——队列
    /**
     public int[] levelOrder(TreeNode root) {
     if(root==null) return new int[0];
     ArrayList<Integer> res = new ArrayList<>();
     Queue<TreeNode> queue = new LinkedList<>();
     queue.add(root);
     while(!queue.isEmpty()){
     TreeNode node = queue.poll();
     res.add(node.val);
     if(node.left!=null) queue.add(node.left);
     if(node.right!=null) queue.add(node.right);
     }
     int[] result = new int[res.size()];
     for(int i=0;i<res.size();i++){
     result[i]=res.get(i);
     }
     return result;
     }*/
}
