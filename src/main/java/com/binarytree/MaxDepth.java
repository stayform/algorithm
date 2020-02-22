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
//找二叉树的最大深度，就要 找到其根节点下各个子树的深度
//情况1：根节点为空 返回0
//情况2：以根节点的左右孩子分别为根结点，找 新的根节点的子树的深度
//比较选出左右中的最大值+1返回给上一层递归