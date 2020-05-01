package com.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * AuThor：StAY_
 * Create:2020/5/1
 */
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
public class LetterCombinations {
    ArrayList<String> result = new ArrayList<String>();
    HashMap<Character,char[]> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if(digits.length()==0||digits==null){
            return new ArrayList<String>();
        }
        map.put('2',new char[]{'a','b','c'});
        map.put('3',new char[]{'d','e','f'});
        map.put('4',new char[]{'g','h','i'});
        map.put('5',new char[]{'j','k','l'});
        map.put('6',new char[]{'m','n','o'});
        map.put('7',new char[]{'p','q','r','s'});
        map.put('8',new char[]{'t','u','v'});
        map.put('9',new char[]{'w','x','y','z'});
        backstrack(digits,0,new StringBuilder().append(""),map);
        return result;
    }

    public void backstrack(String digits,int depth,StringBuilder s,HashMap<Character,char[]> map){
        if(s.length()==digits.length()){
            result.add(s.toString());
            return;
        }

        char c = digits.charAt(depth);
        char[] cs = map.get(c);
        for(int i=0;i<cs.length;i++){
            //做选择
            s.append(cs[i]);
            //递归
            backstrack(digits,depth+1,s,map);
            //撤销选择
            s.deleteCharAt(s.length()-1);
        }
    }
}
