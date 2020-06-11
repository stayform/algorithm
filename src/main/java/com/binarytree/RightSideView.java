package com.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * AuThor：StAY_
 * Create:2020/6/11
 */
//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
public class RightSideView {
    //BFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            for(int i=queue.size()-1;i>=0;i--){
                TreeNode node = queue.poll();
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                if(i==0) res.add(node.val);
            }

        }
        return res;
    }
    //递归/DFS
    /**
     List<Integer> res = new ArrayList<>();
     int deep=0;
     public List<Integer> rightSideView(TreeNode root) {
     if(root==null) return new ArrayList<Integer>();

     rightView(root,0);
     return res;
     }
     public void rightView(TreeNode root,int nowDeep){//nowDeep代表在这次递归中处于哪一层
     if(root==null) return ;
     if(deep==nowDeep){//这样判断的目的是：每一次走右子节点能取得元素时。deep和nowDeep往往是相等的，这时候按照规则加入就好；当右子节点为空时会返回上一层，这时候走左子节点，deep又一次和nowDeep相等，加入左子节点的值；所以说加这个限制，是为了避免右子节点已经加过，还要加左子节点的情况
     res.add(root.val);
     deep++;//每走过一层 deep++
     }

     rightView(root.right,nowDeep+1);
     rightView(root.left,nowDeep+1);
     }*/
}
