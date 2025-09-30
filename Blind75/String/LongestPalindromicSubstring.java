package Blind75.String;

import java.util.Scanner;

// Expand Centers, Multiple approaches

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(LPS(s));
        System.out.println(DP(s));

        sc.close();
    }

    // DP solution also in n^2,n^2
    // dp[i][j]=s[i]==s[j]&&((j-i)<3||dp[i+1][j-1])
    private static String DP(String s) {
        int n = s.length();
        if (n < 2)
            return s;

        boolean[][] dp = new boolean[n][n];
        int start = 0, maxLen = 0;

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int len = 2; len <= n; len++) { // for len >=2
            for (int i = 0; i <= n - len; i++) { // start indx
                int j = i + len - 1;// end indx

                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2 || len == 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && len > maxLen) {
                    maxLen = len;
                    start = i;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

    // n^2, 1
    private static String LPS(String s) {
        String ans = "";

        int n = s.length();
        for (int i = 0; i < n; i++) {
            String a = numberOfPalindromeTool(s, i, i);
            String b = numberOfPalindromeTool(s, i, i + 1);
            ans = a.length() > ans.length() ? a : ans;
            ans = b.length() > ans.length() ? b : ans;
        }
        return ans;
    }

    private static String numberOfPalindromeTool(String s, int l, int r) {
        String ans = "";
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            String curr = s.substring(l, r + 1);
            if (curr.length() > ans.length()) {
                ans = curr;
            }
            l--;
            r++;
        }
        return ans;
    }
}
