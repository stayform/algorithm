package com.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * AuThor：StAY_
 * Create:2020/5/2
 */
//格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
//给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
//格雷编码序列必须以 0 开头。

public class GrayCode {
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(0);
        for(int i=0;i<n;i++){
            int add=1<<i;//需要给res里已有元素加的值
            for(int j=res.size()-1;j>=0;j--){
                res.add(res.get(j)+add);
            }
        }
        return res;
    }
}
