package in.kaixin.leetcode_byhand.tree;

import in.kaixin.leetcode_byhand.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class TreePostOrderTravel {
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> values = new LinkedList<>();
        if (root == null) {
            return values;
        }
        dealPreOrder(values, root);
        return values;
    }

    public void dealPreOrder(List<Integer> values, TreeNode root) {

        if (root.left != null) {
            dealPreOrder(values, root.left);
        }

        if (root.right != null) {
            dealPreOrder(values, root.right);
        }
        values.add(root.val);
    }
}
