package Leetcode150.SegmentTree;

public class RangeMax {
    static int[] arr = new int[100005];
    static int[] seg = new int[4 * 100005]; // segment tree need 4*N space

    private static void build(int i, int low, int high) {
        if (low == high) {
            seg[i] = arr[low];
            return;
        }

        int mid = (low + high) / 2;
        build(2 * i + 1, low, mid);
        build(2 * i + 2, mid + 1, high);

        // seg[i] = Math.max(seg[2 * i + 1], seg[2 * i + 2]); //if we want max val in
        // perticular range
        seg[i] = seg[2 * i + 1] + seg[2 * i + 2]; // if we want sum of val in perticular range
    }

    private static int query(int i, int low, int high, int l, int r) {
        if (low > r || high < l) {
            // return Integer.MIN_VALUE;
            return 0;
        }

        if (low >= l && high <= r) {
            return seg[i];
        }

        int mid = (low + high) / 2;
        int left = query(2 * i + 1, low, mid, l, r);
        int right = query(2 * i + 2, mid + 1, high, l, r);
        // return Math.max(left, right);
        return left + right;
    }

    public static void main(String[] args) {
        int[] temp = { 8, 2, 5, 1, 4, 5, 3, 9, 6, 10 };

        for (int i = 0; i < temp.length; i++) {
            arr[i] = temp[i];
        }

        build(0, 0, temp.length - 1);
        System.out.println(query(0, 0, temp.length - 1, 0, 9));

    }
}
