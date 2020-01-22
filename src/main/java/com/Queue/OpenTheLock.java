package com.Queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * AuThor：StAY_
 * Create:2020/1/22
 */
public class OpenTheLock {
    public int openLock(String[] deadends, String target){
        Set<String> ends = new HashSet();
        for(String d : deadends) {
            ends.add(d);
        }
        Set<String> searched = new HashSet();//存储遍历过的字符串
        searched.add("0000");

        Queue<String> queue = new LinkedList<>();//创建队列
        queue.offer("0000");
        queue.offer(null);

        int depth = 0;
        while(!queue.isEmpty()) {
            String first = queue.poll();
            if(first==null){//如果栈顶元素为null,则表明遍历深度增加一层
                depth++;
                if(queue.peek()!=null){//每遍历一层加一个null
                    queue.add(null);
                }
            }else if(first.equals(target)){
                return depth;
            }else if (!ends.contains(first)){
                for (int i = 0; i < 4; i++) {
                    for (int j = -1; j < 2; j += 2) {
                        int z = ((first.charAt(i)-'0') + j + 10) % 10;
                        String neib = first.substring(0, i) + (z + "") + first.substring(i + 1);
                        if (!searched.contains(neib)) {
                            searched.add(neib);
                            queue.offer(neib);
                        }
                    }
                }
            }
        }
        return -1;

    }
}
