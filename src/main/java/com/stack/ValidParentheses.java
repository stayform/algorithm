package com.stack;

import java.util.Stack;

/**
 * AuThor：StAY_
 * Create:2020/1/30
 */
public class ValidParentheses {
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char character = s.charAt(i);
            switch(character){
                case'(':
                case'[':
                case'{':
                    stack.push(character);
                    break;
                case')':
                case']':
                case'}':
                {
                    if(stack.isEmpty()){
                        return false;
                    }
                    char left = stack.pop();
                    if(!((left=='('&&character==')')||(left=='['&&character==']')||(left=='{'&&character=='}'))){
                        return false;
                    }
                    break;
                }
                default:
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValid("([)]"));//false
        System.out.println(vp.isValid("(){}[]"));//true
        System.out.println(vp.isValid("([{}])"))     ;//true
    }
}
