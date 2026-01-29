package Leetcode150.ArrayString;

import java.util.HashMap;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) > n / 2) {
                return key;
            }
        }
        return 0;
    }
}
