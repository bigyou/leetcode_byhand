package in.kaixin.leetcode_byhand.tree;

import in.kaixin.leetcode_byhand.common.TreeNode;

public class MaxPathSum {
    //    https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxPath(root);
        return max;
    }

    public int maxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxPath(root.left);
        int r = maxPath(root.right);
        max = Math.max(max, l + r + root.val);
        max = Math.max(max, l + root.val);
        max = Math.max(max, r + root.val);
        max = Math.max(max, root.val);
        return Math.max(Math.max(l, r) + root.val, root.val);
    }

    public static void main(String[] args) {
        MaxPathSum maxPathSum = new MaxPathSum();
//        TreeNode root = new TreeNode(-10);
//        TreeNode node9 = new TreeNode(9);
//        TreeNode node20 = new TreeNode(20);
//        TreeNode node15 = new TreeNode(15);
//        TreeNode node7 = new TreeNode(7);
//        root.left = node9;
//        root.right = node20;
//        node20.left = node15;
//        node20.right = node7;
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(-1);
        TreeNode right = new TreeNode(-1);
        root.left = left;
        root.right = right;
        int res = maxPathSum.maxPathSum(root);
        System.out.println(res);
    }
}
