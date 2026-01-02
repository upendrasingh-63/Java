package Leetcode150.BinaryTreeBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Queue<TreeNode> q = new LinkedList<>();
        int k = 1;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();

            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (k % 2 == 0) {
                    list.add(0, node.val);
                } else {
                    list.add(node.val);
                }
                if (i == size - 1) {
                    ans.add(list);
                }

                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            k++;
        }
        return ans;
    }
}
