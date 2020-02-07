package com.stack;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * AuThor：StAY_
 * Create:2020/2/7
 */
public class TreeMiddle {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        while(cur!=null||!stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            list.add(cur.data);
            cur=cur.right;
        }
        return list;
    }

}
class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;

}
