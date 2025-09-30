package Blind75.String;

import java.util.Scanner;

//sliding window, charachter frequency

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();

        System.out.println(window(s, k));

        sc.close();
    }

    // TC-O(n)
    private static int window(String s, int k) {
        int[] freq = new int[26];
        int left = 0, n = s.length(), maxLen = 0, maxCount = 0;

        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'A']++;
            maxCount = Math.max(maxCount, freq[s.charAt(i) - 'A']);// popular element

            if (i - left + 1 - maxCount > k) {// check if element other that popular element is greater than k
                freq[s.charAt(left) - 'A']--;
                left++;// shrink window
            }

            maxLen = Math.max(maxCount, i - left + 1);
        }

        return maxLen;
    }
}

// Look at the string with a window that can grow and shrink.
// Count how many times each letter appears in that window.
// Find the letter that appears most (maxCount).
// If all other letters together are more than k, shrink the window from the
// left.
// Keep track of the biggest window you can make — that’s your answer.