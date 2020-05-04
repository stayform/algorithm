package com.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * AuThor：StAY_
 * Create:2020/5/4
 */
//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式
public class RestoreIpAddresses {
    List<String> res = new ArrayList<String>();//结果集
    int len;
    char[] cs;
    public List<String> restoreIpAddresses(String s) {
        if(s.length()<4) return res;//长度小于4直接不符合要求
        cs = s.toCharArray();
        len = cs.length;
        backtrack(new StringBuilder(),0,-1,3);//（拼接每个结果，指示字符数组的下标，每两点之间的值，点的个数）
        return res;
    }
    public void backtrack(StringBuilder sb,int index,int num,int dot){
        if(num>255) return ;
        //满足两个条件才算是一个合格IP：
        //数组索引等于字符数组长度（表明遍历完了整个字符数组）
        //点数为0
        if(index==len){
            if(dot==0){
                res.add(sb.toString());
            }
            return ;
        }
        //情况1：当前位置选用点
        //前一个位置不能是点&&剩余点个数大于0&&剩余数组长度要小于等于3*剩余点数（比如点如果只有一个那么剩余数组长度一定不能大于3）
        if(num!=-1&&dot>0&&(len-index)<=3*dot){
            sb.append(".");
            backtrack(sb,index,-1,dot-1);
            sb.deleteCharAt(sb.length()-1);
        }
        //情况2：当前位置选用数字
        //不以0开头&&剩余数组长度大于点的个数
        if(num!=0&&len-index>dot){
            if(num==-1)
                num=0;//如果前一个是点，就将num初始化为0
            sb.append(cs[index]);
            backtrack(sb,index+1,num*10+(cs[index]-'0'),dot);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
