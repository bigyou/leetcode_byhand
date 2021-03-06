package in.kaixin.leetcode_byhand.tree;

import in.kaixin.leetcode_byhand.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class TreePreOrderTravel {
//    https://leetcode-cn.com/problems/binary-tree-preorder-traversal/

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> values = new LinkedList<>();
        if (root == null) {
            return values;
        }
        dealPreOrder(values, root);
        return values;
    }

    public void dealPreOrder(List<Integer> values, TreeNode root) {
        values.add(root.val);
        if (root.left != null) {
            dealPreOrder(values, root.left);
        }
        if (root.right != null) {
            dealPreOrder(values, root.right);
        }
    }

}

