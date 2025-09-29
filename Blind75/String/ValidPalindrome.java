package Blind75.String;

import java.util.Scanner;

//two pointer, Character filtering

public class ValidPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        s = processing(s);

        System.out.println(isPalindrome(s));

        sc.close();
    }

    // TC- O(n)
    // SX- O(n)
    private static boolean isPalindrome(String s) {
        if (s == null)
            return true;

        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    private static String processing(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(); // replacing string concatination to stringbuilder reduce n^2 to n

        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

}
