package Blind75.String;

import java.util.Arrays;
import java.util.Scanner;

//hashmap, character counting

public class ValidAnagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();

        System.out.println(isValidBrute(s, t));
        System.out.println(isValidOpt(s, t));

        sc.close();
    }

    // Optimised - O(n) , can use hashmap storing freq of s and reducing freq for t
    // if it become 0 the remove key return map.isEmpty()
    private static boolean isValidOpt(String s, String t) {
        // check edge cases
        if (s == null || t == null)
            return false;
        if (s.length() != t.length())
            return false;

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            freq[ch - 'a']--;
        }

        for (int key : freq) {
            if (key != 0)
                return false;
        }

        return true;
    }

    // Brute Force - O(nlogn)
    private static boolean isValidBrute(String s, String t) {
        // check edge cases
        if (s == null || t == null)
            return false;
        if (s.length() != t.length())
            return false;

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        Arrays.sort(arr1); // O(nlogn)
        Arrays.sort(arr2);

        System.out.println(arr1);
        System.out.println(arr2);

        return Arrays.equals(arr1, arr2);
    }
}
