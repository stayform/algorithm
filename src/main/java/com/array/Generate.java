package com.array;
//杨辉三角

import java.util.ArrayList;
import java.util.List;

/**
 * AuThor：StAY_
 * Create:2020/2/15
 */
public class Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if(numRows==0){
            return list;
        }
        if(numRows==1){
            list.add(new ArrayList<>());
            list.get(0).add(1);
            return list;
        }
        list = generate(numRows-1);
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for(int i=1;i<numRows-1;i++){
            row.add(list.get(numRows-2).get(i-1)+list.get(numRows-2).get(i));
        }
        row.add(1);
        list.add(row);
        return list;
    }
}
