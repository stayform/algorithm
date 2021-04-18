package com.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * AuThor：StAY_
 * Create:2020/4/29
 */
//全排列

public class Permute {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        //oneRow相当于一个运输设备，每次满载之后就复制里面的一份东西到新容器里，然后运输设备返回去继续进行删删改改之类的操作
        LinkedList<Integer> oneRow=new LinkedList<>();
        backtrack(nums,oneRow);
        return res;
    }
    //画决策树理解这个方法
    void backtrack(int[] nums,LinkedList<Integer> oneRow){
        //结束条件
        if(oneRow.size()==nums.length){
            res.add(new LinkedList<Integer>(oneRow));
            return ;
        }
        for(int i=0;i<nums.length;i++){
            if(oneRow.contains(nums[i]))
                continue;
            oneRow.add(nums[i]);
            backtrack(nums,oneRow);
            oneRow.removeLast();
        }
    }
}
