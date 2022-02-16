package in.kaixin.leetcode_byhand.tree;

import in.kaixin.leetcode_byhand.common.TreeNode;
import in.kaixin.leetcode_byhand.utils.Utils;

public class Balanced {
    //    https://leetcode-cn.com/problems/balanced-binary-tree/
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        height(root);
        return balance;
    }

    boolean balance = true;

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left) + 1;
        int right = height(root.right) + 1;
        if (Math.abs(left - right) > 1) {
            balance = false;
        }
        return Math.max(left, right);
    }


    public static void main(String[] args) {
        TreeNode root = Utils.getTreeNode(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4});
        Balanced balanced = new Balanced();
        System.out.println(balanced.isBalanced(root));
    }
}
