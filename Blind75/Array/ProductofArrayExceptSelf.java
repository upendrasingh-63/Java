package Blind75.Array;

//suffix and prefix product array, tc-O(n)

public class ProductofArrayExceptSelf {
    public static void main(String[] args) {
        int[] arr = { -1, 1, 0, -3, 3 };

        int n = arr.length;

        int[] preProduct = new int[n];
        int[] sufProduct = new int[n];

        int[] ans = new int[n];

        preProduct[0] = arr[0];
        sufProduct[n - 1] = arr[n - 1];

        for (int i = 1; i < n; i++) {
            preProduct[i] = preProduct[i - 1] * arr[i];
        }

        for (int j = n - 2; j >= 0; j--) {
            sufProduct[j] = sufProduct[j + 1] * arr[j];
        }

        ans[0] = sufProduct[1];
        ans[n - 1] = preProduct[n - 2];

        for (int i = 1; i < n - 1; i++) {
            ans[i] = preProduct[i - 1] * sufProduct[i + 1];
        }

        for (int key : ans) {
            System.out.print(key + " ");
        }
    }
}
