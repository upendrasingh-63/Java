package Blind75.Array;

//two pointer, kadans algo
//if currsum become negative on adding negative value the make currsum=0
// because this negative sum always tends to dencrease the maxsum

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        // System.out.println(brute(arr));
        System.out.println(opt(arr));
    }

    private static int opt(int[] arr) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = 0; i < n; i++) {
            currSum += arr[i];
            maxSum = Math.max(maxSum, currSum);
            if (currSum < 0)
                currSum = 0;
        }

        return maxSum;
    }

    // O(n^3)
    private static int brute(int[] arr) {
        int max = Integer.MIN_VALUE;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                if (sum > max)
                    max = sum;
            }
        }
        return max;
    }
}
