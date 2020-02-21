package com.binarytree;

/**
 * AuThor：StAY_
 * Create:2020/2/21
 */
//二叉树的深度
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }


        int leftDepth=maxDepth(root.left);
        int rightDepth=maxDepth(root.right);
        return Math.max(leftDepth,rightDepth)+1;
    }
}
