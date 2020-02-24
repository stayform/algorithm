package com.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * AuThor：StAY_
 * Create:2020/2/24
 */
//只出现一次的数字
//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

public class SingleNumber {

    //方法1：异或（异或满足结合律，相同的两个数都异或为0，再将0与只出现一次的数异或，就可以得到那个数）
    public int singleNumber(int[] nums) {

        int result=0;

        for(Integer i:nums){
            result =result^i;
        }

        return result;
    }

    //方法2：哈希集合
    public int singleNumber2(int[] nums) {

        int result=0;
        Set<Integer> set = new HashSet<Integer>();
        for(Integer i:nums){
            if(!(set.contains(i))){
                set.add(i);
            }else{
                set.remove(i);
            }
        }
        for(Integer i:set){
            result=i;
        }
        return result;
    }
}
