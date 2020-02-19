package com.binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * AuThor：StAY_
 * Create:2020/2/19
 */
public class PostorderTraversal {
    LinkedList<Integer> list = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null){
            return list;
        }
        stack.add(root);
        while(!stack.isEmpty()){
            root=stack.pop();
            list.addFirst(root.val);

            if(root.left!=null){
                stack.add(root.left);
            }
            if(root.right!=null){
                stack.add(root.right);
            }
        }
        return list;
    }

    /**
     List<Integer> list = new ArrayList<>();
     public List<Integer> postorderTraversal(TreeNode root) {
     if(root==null){
     return list;
     }
     if(root.left!=null)postorderTraversal(root.left);
     if(root.right!=null)postorderTraversal(root.right);
     list.add(root.val);
     return list;
     }*/
}
