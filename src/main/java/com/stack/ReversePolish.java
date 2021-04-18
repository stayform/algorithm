package com.stack;

import java.util.Stack;

/**
 * AuThor：StAY_
 * Create:2020/2/3
 */
public class ReversePolish {

    private Stack<Integer> stack = new Stack<>();
    public int evalRPN(String[] tokens) {
        Integer x,y;
        for(String s :tokens){
            switch(s){
                case "+":
                    stack.push(stack.pop()+stack.pop());
                    break;
                case "-":
                    x=stack.pop();
                    y=stack.pop();
                    stack.push(y-x);
                    break;
                case "*":
                    x=stack.pop();
                    y=stack.pop();
                    stack.push(x*y);
                    break;
                case "/":
                    x=stack.pop();
                    y=stack.pop();
                    stack.push((y/x));
                    break;
                default:
                    stack.push(Integer.valueOf(s));
                    break;
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens ={"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        ReversePolish reversePolish = new ReversePolish();
        System.out.println(reversePolish.evalRPN(tokens));
    }
}
