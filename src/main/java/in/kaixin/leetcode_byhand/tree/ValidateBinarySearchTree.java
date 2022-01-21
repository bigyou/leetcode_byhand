package in.kaixin.leetcode_byhand.tree;

import in.kaixin.leetcode_byhand.common.TreeNode;

public class ValidateBinarySearchTree {
    //    https://leetcode-cn.com/problems/validate-binary-search-tree/
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        boolean validate = validate(root, null, null);
        return validate;

    }

    /**
     * 每个节点都有一个区间
     * @param node
     * @param min
     * @param max
     * @return
     */
    public boolean validate(TreeNode node, Integer min, Integer max) {

        if (node == null) {
            return true;
        }
        if (min != null) {
            if (node.val <= min) {
                return false;
            }
        }
        if (max != null) {
            if (node.val >= max) {
                return false;
            }
        }
        boolean validate = true;
        if (node.left != null) {
            validate = validate(node.left, min, node.val);
        }
        if (!validate) {
            return false;
        }

        if (node.right != null) {
            validate = validate(node.right, node.val, max);
        }
        return validate;
    }

}
