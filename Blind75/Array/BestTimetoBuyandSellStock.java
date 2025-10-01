package Blind75.Array;

//greedy,space optimised, tc-O(n)

public class BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        int[] arr = { 7, 6, 4, 3, 1 };

        int max = 0;
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            int pro = arr[i] - min;
            max = Math.max(max, pro);
        }
        System.out.println(max);
    }
}
