package Blind75.Array;

import java.util.HashSet;

//hashset, array fundamental
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };

        System.out.println(isContainsDuplicate(arr));
    }

    // TC-O(n), sc- O(n)
    private static boolean isContainsDuplicate(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int key : arr) {
            if (set.contains(key)) {
                return true;
            }
            set.add(key);
        }
        return false;
    }
}
