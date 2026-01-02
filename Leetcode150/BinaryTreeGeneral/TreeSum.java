package Leetcode150.BinaryTreeGeneral;

public class TreeSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        return build(root, targetSum);
    }

    public boolean build(TreeNode root, int sum) {
        if (root == null)
            return false;
        sum -= root.val;
        if (root.left == null && root.right == null) {
            return sum == 0;
        }
        return build(root.left, sum) || build(root.right, sum);

    }
}
