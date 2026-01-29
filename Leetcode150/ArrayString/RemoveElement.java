package Leetcode150.ArrayString;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        // we should use pointer to get it in linear
        int n = nums.length;
        int pointer = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                nums[pointer] = nums[i];
                pointer++;
            }
        }
        return pointer;
    }
}
