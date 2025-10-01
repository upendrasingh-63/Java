package Blind75.Array;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] arr = { 0, 10, 10, 10, 10, 10, 10, 10, 10, 10, -10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0 };
        // System.out.println(brute(arr));
        System.out.println(maxProduct(arr));
    }

    // O(n)-- take prefix and suffix product if it is negative set pf1 pf2 to 1;
    private static int maxProduct(int[] nums) {
        int n = nums.length;

        int pf1 = 1;
        int max1 = Integer.MIN_VALUE;

        int pf2 = 1;
        int max2 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (pf1 == 0) {
                pf1 = nums[i];
            } else {
                pf1 = pf1 * nums[i];
            }
            max1 = Math.max(pf1, max1);
        }

        for (int i = n - 1; i >= 0; i--) {
            if (pf2 == 0) {
                pf2 = nums[i];
            } else {
                pf2 = pf2 * nums[i];
            }
            max2 = Math.max(pf2, max2);
        }

        return Math.max(max1, max2);

    }

    // private static int presuf(int[] arr) {
    // int n = arr.length;
    // int max = Integer.MIN_VALUE;

    // int[] pre = new int[n];
    // int[] suf = new int[n];

    // pre[0] = arr[0];
    // suf[n - 1] = arr[n - 1];

    // for (int i = 1; i < n; i++) {
    // pre[i] = pre[i - 1] * arr[i];
    // max = Math.max(max, pre[i]);
    // }

    // for (int j = n - 2; j >= 0; j--) {
    // suf[j] = suf[j + 1] * arr[j];
    // max = Math.max(max, suf[j]);
    // }

    // return max;
    // }

    // TC=O(n^3)
    private static int brute(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int currPro = 1;
                for (int k = i; k <= j; k++) {
                    currPro *= arr[k];
                }
                max = Math.max(max, currPro);
            }
        }

        return max;
    }
}
