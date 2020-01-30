package com.queue;

import java.util.LinkedList;

/**
 * AuThor：StAY_
 * Create:2020/1/19
 */
public class NumberOfIslands {
    //用到了广度优先搜索
//判断是一个岛的条件：从一个未被遍历的'1'结点开始，岛屿数量+1并新建队列使此结点进入队列，判断其上下左右是否有'1'，如果有：进入队列，判断完一个节点的各个方向后将此节点移出队列，接着判断队列中下一个元素。当队列为空时表明一个独立岛屿遍历完成
//把已经遍历过的结点做标注（应该标注为'0'），进行下一次判断


        public int numIslands(char[][] grid) {
            if(grid==null||grid.length==0){
                return 0;
            }
            int islandsNum=0;
            int rows=grid.length;
            int cols=grid[0].length;
            for(int r=0;r<rows;r++){
                for(int c=0;c<cols;c++){
                    if(grid[r][c]=='1'){
                        islandsNum++;
                        grid[r][c]='0';
                        LinkedList<Integer> queue = new LinkedList<>();
                        queue.add(r*cols+c);
                        while(!queue.isEmpty()){
                            int cur = queue.remove();//队列首元素的坐标
                            int x = cur/cols;
                            int y = cur%cols;

                            if(x-1>=0&&grid[x-1][y]=='1'){
                                queue.add((x-1)*cols+y);
                                grid[x-1][y]='0';
                            }
                            if(x+1<rows&&grid[x+1][y]=='1'){
                                queue.add((x+1)*cols+y);
                                grid[x+1][y]='0';
                            }
                            if(y-1>=0&&grid[x][y-1]=='1'){
                                queue.add(x*cols+y-1);
                                grid[x][y-1]='0';
                            }
                            if(y+1<cols&&grid[x][y+1]=='1'){
                                queue.add(x*cols+y+1);
                                grid[x][y+1]='0';
                            }

                        }
                    }
                }
            }
            return islandsNum;
        }




}
