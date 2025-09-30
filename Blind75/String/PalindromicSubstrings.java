package Blind75.String;

import java.util.HashMap;
import java.util.Scanner;

//two pointer, expanding center

public class PalindromicSubstrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        // System.out.println(countPalindrome(s));
        System.out.println(numberOfPalindrome(s));

        sc.close();
    }

    // should learn Manacher’s algorithm for O(n)

    // Optimised TC-O(n^2)
    private static int numberOfPalindrome(String s) {
        int count = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            count += numberOfPalindromeTool(s, i, i) + numberOfPalindromeTool(s, i, i + 1);// for odd index and even idx
        }
        return count;
    }

    private static int numberOfPalindromeTool(String s, int l, int r) {
        int count = 0;

        while (l >= 0 && r < s.length() && (s.charAt(l) == s.charAt(r))) {
            count++;
            l--;
            r++;
        }
        return count;

    }

    // TC- n^3
    private static int countPalindrome(String s) {
        int count = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (isPalindrome(s, i, j - 1))
                    count++;
            }
        }
        return count;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
