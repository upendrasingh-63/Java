package Leetcode150.BinarySearchTree;

public class KthSmallestElementInBST {
    int ans = 0;
    int counter = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return 0;
        // List<Integer> list=new ArrayList<>();
        inorder(root, k);
        return ans;
    }

    private void inorder(TreeNode root, int k) {
        if (root == null)
            return;

        inorder(root.left, k);
        counter++;
        if (counter == k) {
            ans = root.val;
            return;
        }
        // list.add(root.val);
        inorder(root.right, k);
    }
}
