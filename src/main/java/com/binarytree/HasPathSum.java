package com.binarytree;

/**
 * AuThor：StAY_
 * Create:2020/2/22
 */
//路径总和
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        if(root.left==null&&root.right==null){
            return sum-root.val==0;
        }
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);

    }
}
//判断有没有路径和为sum的 就要判断 每一个路径到底是否为0
//情况1：根节点为Null return false
//情况2：根节点的左右结点为null 判断sum-root.val是否为0 是：true 否：false
//情况3：根节点左右结点有不为null的情况 判断 以根节点的左右结点为根到底的路径是否为0

