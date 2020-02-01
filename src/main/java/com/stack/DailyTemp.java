package com.stack;

import java.util.Stack;

/**
 * AuThor：StAY_
 * Create:2020/2/1
 */
public class DailyTemp {
    private Stack<Integer> stack = new Stack<>();

    public int[] dailyTemperatures(int[] T) {
        int[] newArray = new int[T.length];

        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int n = stack.peek();
                newArray[stack.pop()] = i - n;
            }
            stack.push(i);

        }
        return newArray;
    }

    public static void main(String[] args) {
        DailyTemp dailyTemp = new DailyTemp();
        int[] init = {73,74,75,71,69,72,76,73};
        int[] result = dailyTemp.dailyTemperatures(init);
        for(int i=0;i<init.length;i++){
            System.out.print(result[i]);
        }
    }
}
