package com.binarytree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * AuThor：StAY_
 * Create:2020/2/18
 */
//二叉树先序遍历
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
    TreeNode(int x) { val = x; }
 }
public class PreTraversal {
    private List<Integer> list = new ArrayList<>();
    //LinkedList<TreeNode> stack = new LinkedList<>();
    private Stack<TreeNode> stack = new Stack<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null){
            return list;
        }
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            list.add(node.val);

            if(node.right!=null){
                stack.add(node.right);
            }
            if(node.left!=null){
                stack.add(node.left);
            }
        }
        return list;
    }

    /**
     *递归
     List<Integer> list = new ArrayList<>();
     public List<Integer> preorderTraversal(TreeNode root) {

     if(root==null){
     return list;                                                                                                                                                                                      }
     list.add(root.val);
     if(root.left!=null)preorderTraversal(root.left);
     if(root.right!=null)preorderTraversal(root.right);
     return list;
     }*/
}
