package com.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * AuThor：StAY_
 * Create:2020/2/21
 */
//二叉树层序遍历  一层一层输出
public class LevelOrder {
    List<List<Integer>> list = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return list;
        }
        queue.offer(root);


        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();//size不能写在for循环中因为循环里执行的语句会让size产生变化
            for(int i=0;i<size;i++){
                TreeNode node =queue.poll();
                level.add(node.val);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            list.add(level);
        }
        return list;
    }
}
