package in.kaixin.leetcode_byhand.tree;

import in.kaixin.leetcode_byhand.common.TreeNode;

public class Flatten {
    //    https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
    public void flatten(TreeNode root) {
        doFlatten(root);
    }

    public void doFlatten(TreeNode node) { //
        if (node == null) {
            return;
        }
        if (node.left != null) {
            doFlatten(node.left);

            TreeNode temp = node.right;
            node.right = node.left;
            node.left = null;

            TreeNode lastCursor = node.right;
            if (lastCursor != null) {
                while (lastCursor.right != null) {
                    lastCursor = lastCursor.right;
                }
                lastCursor.right = temp;
                doFlatten(lastCursor.right);
            }
        }else {
            doFlatten(node.right);
        }

    }
}
