package com.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * AuThor：StAY_
 * Create:2020/4/29
 */
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
     }
public class Rob3 {
    //DP table
    Map<TreeNode, Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
        if(root==null) return 0;
        if(memo.containsKey(root)){
            return memo.get(root);
        }
        int do_it,not_do;
        do_it=root.val+(root.left==null?0:rob(root.left.left)+rob(root.left.right))
                +(root.right==null?0:rob(root.right.left)+rob(root.right.right));
        not_do=rob(root.left)+rob(root.right);
        int res = Math.max(do_it,not_do);
        memo.put(root,res);
        return res;
    }
}
