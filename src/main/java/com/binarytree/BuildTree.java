package com.binarytree;

import java.util.Arrays;

/**
 * AuThor：StAY_
 * Create:2020/5/31
 */
//重建二叉树
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||inorder.length==0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        for(int i=0;i<preorder.length;i++){
            if(preorder[0]==inorder[i]){
                int[] leftPre= Arrays.copyOfRange(preorder,1,i+1);//注意！！左闭右开
                int[] rightPre=Arrays.copyOfRange(preorder,i+1,preorder.length);
                int[] leftIn=Arrays.copyOfRange(inorder,0,i);
                int[] rightIn=Arrays.copyOfRange(inorder,i+1,inorder.length);
                root.left=buildTree(leftPre,leftIn);
                root.right=buildTree(rightPre,rightIn);
                break;
            }
        }
        return root;
    }
}
