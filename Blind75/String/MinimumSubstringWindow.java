package Blind75.String;

public class MinimumSubstringWindow {
    public static void main(String[] args) {
        String s = "a";
        String t = "a";
        System.out.println(minString(s, t));
    }

    // TC-O(n);sc- O(1)
    private static String minString(String s, String t) {
        if (s == null || t == null || s.length() < t.length())
            return "";

        // Step 1: Build frequency map for t
        int[] need = new int[128]; // supports ASCII chars
        for (char ch : t.toCharArray()) {
            need[ch]++;
        }

        int left = 0, right = 0; // window boundaries
        int count = t.length(); // how many chars still need to be satisfied
        int minLen = Integer.MAX_VALUE;
        int start = 0; // starting index of best window

        // Step 2: Expand right pointer
        while (right < s.length()) {
            char r = s.charAt(right);

            // if this char is needed, decrease count
            if (need[r] > 0) {
                count--;
            }
            // always decrease its need count (goes negative if extra)
            need[r]--;

            // Step 3: When valid window found (count==0), try to shrink
            while (count == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char l = s.charAt(left);

                // restore need[l], since we’re removing from window
                need[l]++;
                // if this char was actually required, window becomes invalid
                if (need[l] > 0) {
                    count++;
                }

                left++;
            }

            right++;
        }

        // Step 4: Return result
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
