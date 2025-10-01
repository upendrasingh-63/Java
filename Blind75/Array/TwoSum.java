package Blind75.Array;

import java.util.HashMap;

//hashmap
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = { 3, 3 };
        int target = 6;
        int[] ans = findIndex(arr, target);
        System.out.println(ans[0] + " " + ans[1]);
    }

    // TC- O(n) ,sc- O(n)
    private static int[] findIndex(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        map.put(arr[0], 0);

        for (int i = 1; i < arr.length; i++) {
            int diff = Math.abs(target - arr[i]);
            if (map.containsKey(diff)) {
                ans[1] = i;
                ans[0] = map.get(diff);
                break;
            }
            map.put(arr[i], i);
        }
        return ans;
    }
}
