package com.binarytree;

/**
 * AuThor：StAY_
 * Create:2020/2/22
 */
//对称二叉树
public class IsSymmetric {
        public boolean isSymmetric(TreeNode root) {
            if(root==null){
                return true;
            }
            return isSym(root.left,root.right);
        }
        boolean isSym(TreeNode t1,TreeNode t2){
            if(t1==null&&t2==null) return true;
            if(t1==null||t2==null) return false;
            return t1.val==t2.val&&isSym(t1.left,t2.right)&&isSym(t1.right,t2.left);
        }
    }
//判断二叉树对称的条件是其 左子树等于其右子树
//如何判断呢？情况1：左子树的根与右子树的根皆为空 返回true
//情况2：左右子树只有一个根节点为空 返回false
//情况3：左子树根的值等于右子树根的值并且 左子树的左子树等于右子树的右子树 并且 左子树的右子树等于右子树的左子树
//注意看情况3里出现了一些和第一句相似的语句，这里就是递归的点

