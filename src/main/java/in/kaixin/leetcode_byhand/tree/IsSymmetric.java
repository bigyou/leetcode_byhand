package in.kaixin.leetcode_byhand.tree;

import in.kaixin.leetcode_byhand.common.TreeNode;
import in.kaixin.leetcode_byhand.utils.Utils;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return isSym(root.left, root.right);
    }

    public boolean isSym(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        } else {
            return isSym(left.left, right.right) && isSym(left.right, right.left);
        }

    }

    public static void main(String[] args) {
        TreeNode treeNode = Utils.getTreeNode(new Integer[]{1});
        IsSymmetric isSymmetric = new IsSymmetric();
        System.out.println(isSymmetric.isSymmetric(treeNode));
    }
}
