package Blind75.String;

import java.util.HashSet;
import java.util.Scanner;

//sliding window, variable window

public class LongestSubstringWithoutRepeatingCharachter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(maxLen(s));
        sc.close();
    }

    // TC- O(n) SC-O(n)
    private static int maxLen(String s) {
        HashSet<Character> set = new HashSet<>();

        int left = 0, maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            if (set.contains(s.charAt(right))) {
                while (s.charAt(right) != s.charAt(left)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            } else {
                set.add(s.charAt(right));
                maxLen = Math.max(maxLen, right - left + 1);
            }

            // while (set.contains(s.charAt(right))) {
            // set.remove(s.charAt(left));
            // left++;
            // }
            // set.add(s.charAt(right));
            // maxLen = Math.max(maxLen, right - left + 1);

        }
        return maxLen;
    }
}
