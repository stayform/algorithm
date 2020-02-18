package com.array;

import java.util.ArrayList;
import java.util.List;

/**
 * AuThor：StAY_
 * Create:2020/2/18
 */
//杨辉三角II
public class GetRow {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        for(int i=0;i<=rowIndex;i++){
            cur=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i){//第一个和最后一个元素为1
                    cur.add(1);
                }else{
                    cur.add(pre.get(j-1)+pre.get(j));//中间元素为上层元素之和
                }
            }
            pre=cur;
        }
        return cur;
    }
}
