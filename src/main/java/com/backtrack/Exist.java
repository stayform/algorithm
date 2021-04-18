package com.backtrack;

import java.util.ArrayList;

/**
 * AuThor：StAY_
 * Create:2020/5/20
 */
public class Exist {
    //12.矩阵中的路径
    //请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格
    //回溯法
    private static int[][] siteMove = {{0,1},{1,0},{0,-1},{-1,0}};//控制上下左右移动
    private int row,col;
    private boolean hasFind;
    private boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        row=board.length;
        col=board[0].length;
        if(word.length()>row*col)
            return false;

        hasFind=false;
        visited = new boolean[row][col];
        char[] words = word.toCharArray();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]==words[0]){
                    backTrack(board,words,1,i,j);
                    if(hasFind)  return true;
                }
            }
        }
        return false;
    }

    public void backTrack(char[][] board,char[] words,int wordsLength,int x,int y){//wordslength既表示当前要访问的word里的下标又表示整个长度
        if(hasFind)//为true 则返回
            return;
        if(wordsLength==words.length){//长度等于words长度时表明已经找到一条路径，讲hasFind设置为true
            hasFind=true;
            return;
        }
        visited[x][y]=true;//对当前元素设置为已访问
        //对当前元素的上下左右做分析
        for(int[] site:siteMove){
            int newX=x+site[0];
            int newY=y+site[1];
            //坐标合法&&未被访问&&字符与word里的当前字符相等
            if(newX>=0&&newX<row&&newY>=0&&newY<col&& !visited[newX][newY]&& board[newX][newY]==words[wordsLength]){
                backTrack(board,words,wordsLength+1,newX,newY);
            }
        }
        visited[x][y]=false;//当前元素上下左右都不符合就取消对当前元素的访问，转而开辟另一条路径
        ArrayList<Integer> l = new ArrayList<>();

    }
}
