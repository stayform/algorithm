package com.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * AuThor：StAY_
 * Create:2020/2/19
 */
public class InorderTraversal2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.add(root);
                root=root.left;
            }
            root=stack.pop();
            list.add(root.val);
            root=root.right;

        }
        return list;
    }

    /**
     List<Integer> list = new ArrayList<>();
     public List<Integer> inorderTraversal(TreeNode root) {
     if(root==null){
     return list;
     }
     if(root.left!=null)inorderTraversal(root.left);
     list.add(root.val);
     if(root.right!=null)inorderTraversal(root.right);
     return list;
     }
     */
}
