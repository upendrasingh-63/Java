package Leetcode150.Stack;

import java.util.Stack;

public class EvaluateRPN {
    public static void main(String[] args) {

        String[] arr = { "2", "1", "+", "3", "*" };

        Stack<Integer> stack = new Stack<>();

        for (String key : arr) {
            if (key.equals("+") || key.equals("-") || key.equals("/") || key.equals("*")) {
                int b = stack.pop();
                int a = stack.pop();

                int result = 0;
                if (key.equals("+"))
                    result = a + b;
                else if (key.equals("-"))
                    result = a - b;
                else if (key.equals("*"))
                    result = a * b;
                else
                    result = a / b;

                stack.push(result);
            } else {
                stack.push(Integer.parseInt(key));
            }
        }

        System.out.println(stack.pop());
    }
}
