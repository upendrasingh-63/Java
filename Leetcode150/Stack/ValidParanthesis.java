package Leetcode150.Stack;

import java.util.Stack;

public class ValidParanthesis {
    public static void main(String[] args) {
        String s = "([)]";

        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else {
                if (st.isEmpty()) {
                    System.out.println("Not valid");
                }
                char top = st.peek();
                if ((ch == ')' && top == '(') || (ch == ']' && top == '[') || (ch == '}' && top == '{')) {
                    st.pop();
                } else {
                    System.out.println("Not valid");
                }
            }
        }
        if (st.isEmpty()) {
            System.out.println("Yes valid");
        }
    }
}
