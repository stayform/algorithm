package com.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * AuThor：StAY_
 * Create:2020/6/19
 */
//给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树
public class GenerateTrees {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> pre = new ArrayList<>();
        if(n==0) return pre;
        //每次增加一个结点，明确一个思路：每次增加的结点都是比历史结点大的结点，所以要么放在根结点，要么放在右孩子/右孩子的右孩子......
        pre.add(null);
        for(int i=1;i<=n;i++){
            List<TreeNode> cur = new ArrayList<>();
            TreeNode insert;
            //1.首先往上次集合各树的根结点加值：规则是新结点插入根结点，根节点原来的树变为新结点的左子树
            for(TreeNode root:pre){
                insert = new TreeNode(i);
                insert.left=root;
                cur.add(insert);

                //2.找上次集合各树的右孩子，看哪个地方能插入当前结点
                //一颗树最多可以找i次右孩子
                for(int j=0;j<i;j++){
                    TreeNode copy_tree=copyTree(root);
                    TreeNode right=copy_tree;//right先等于复制过来的根结点，下面再往下找适合插入的点
                    //遍历 j 次找右孩子
                    //j限定了当前循环允许寻找的深度
                    for (int k=0; k < j; k++) {//决定这次插入哪个右孩子的位置，是右孩子还是右孩子的右孩子还是...
                        if (right == null)
                            break;
                        right = right.right;
                    }
                    //到达 null 提前结束
                    if (right == null)
                        break;
                    TreeNode curRight=right.right;//保存当前右子树，作为后期插入的左子树
                    insert=new TreeNode(i);
                    right.right=insert;
                    insert.left=curRight;
                    cur.add(copy_tree);
                }
                pre=cur;
            }
        }
        return pre;
    }
    public TreeNode copyTree(TreeNode root){
        if(root==null) return null;
        TreeNode newNode = new TreeNode(root.val);
        newNode.left=copyTree(root.left);
        newNode.right=copyTree(root.right);
        return newNode;
    }
}
