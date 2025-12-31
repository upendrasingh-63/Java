package Leetcode150.Stack;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        String s = "/home/user/Documents/../Pictures";

        Stack<String> st = new Stack<>();

        String[] arr = s.split("/");

        for (String key : arr) {
            if (key.equals("") || key.equals("."))
                continue;

            else if (key.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else
                st.push(key);
        }

        StringBuilder ans = new StringBuilder();

        for (String dir : st) {
            ans.append("/").append(dir);
        }

        String fin = ans.length() == 0 ? "/" : ans.toString();
        System.out.println(fin);

    }
}
