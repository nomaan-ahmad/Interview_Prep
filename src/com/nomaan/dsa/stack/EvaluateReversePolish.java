package com.nomaan.dsa.stack;

import java.util.Stack;

// https://leetcode.com/problems/evaluate-reverse-polish-notation/
public class EvaluateReversePolish {
    public static void main(String[] args) {
        String[] str = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(str));
    }

    public static int evalRPN(String[] tokens) {
        String operators = "+-*/";

        Stack<Integer> stk = new Stack<>();

        for (String str : tokens) {
            if(!operators.contains(str)) {
                stk.push(Integer.parseInt(str));
            } else {
                int idx = operators.indexOf(str);

                switch (idx) {
                    case 0 -> {
                        int b = stk.pop();
                        int a = stk.pop();

                        stk.push(a + b);
                    }
                    case 1 -> {
                        int b = stk.pop();
                        int a = stk.pop();

                        stk.push(a - b);
                    }
                    case 2 -> {
                        int b = stk.pop();
                        int a = stk.pop();

                        stk.push(a * b);
                    }
                    case 3 -> {
                        int b = stk.pop();
                        int a = stk.pop();

                        stk.push(a / b);
                    }
                }
            }
        }

        return stk.pop();
    }
}
