package com.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * AuThor：StAY_
 * Create:2020/2/25
 */
//两数之和
    //哈希映射的应用
public class TwoSum {
    public int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);//把值当作key,下标当作value
        }

        for(int i=0;i<map.size();i++){
            int temp=target-nums[i];
            if(map.containsKey(temp)&&map.get(temp)!=i){
                return new int[]{i,map.get(temp)};
            }
        }
        throw new IllegalArgumentException("No two sum Solution");
    }

}
