package Leetcode150.BinarySearchTree;

public class MinimumAbsoluteDifferenceInBST {
    int min = Integer.MAX_VALUE;
    Integer prev = null;

    public int getMinimumDifference(TreeNode root) {
        print(root);
        return min;
    }

    private void print(TreeNode root) {
        if (root == null) {
            return;
        }

        print(root.left);

        if (prev != null) {
            int abs = Math.abs(root.val - prev);
            min = Math.min(min, abs);
        }

        prev = root.val;

        print(root.right);
    }
}
