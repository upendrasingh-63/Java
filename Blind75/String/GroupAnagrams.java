package Blind75.String;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//Hashmap, String grouping

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] arr = { "eat", "tea", "tan", "ate", "nat", "bat" };

        List<List<String>> list = AnagramsOpt(arr);

        System.out.println(list);
    }

    // optimised
    // TC- n.k
    // SC- n
    private static List<List<String>> AnagramsOpt(String[] arr) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : arr) {
            int[] freq = new int[26]; // assuming only lowercase letters
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }

            // Build a unique key for this frequency count
            // StringBuilder sb = new StringBuilder();
            // for (int count : freq) {
            // sb.append('#'); // separator to avoid collisions
            // sb.append(count);
            // }
            // String key = sb.toString();

            String key = Arrays.toString(freq);
            System.out.println(key);

            // Add word to its anagram group
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(map.values());
    }

    // TC- n*klogk
    // SC- n*k
    private static List<List<String>> Anagrams(String[] arr) {
        List<List<String>> list = new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            char[] ch = arr[i].toCharArray();
            Arrays.sort(ch);

            String temp = toString(ch);

            System.out.println(temp);

            if (!map.containsKey(temp)) {
                map.put(temp, new ArrayList<>());
                map.get(temp).add(arr[i]);
            } else {
                map.get(temp).add(arr[i]);
            }
        }

        for (String key : map.keySet()) {
            list.add(map.get(key));
        }

        return list;
    }

    private static String toString(char[] arr) {
        StringBuilder sb = new StringBuilder();
        for (char key : arr) {
            sb.append(key);
        }
        return sb.toString();
    }
}
