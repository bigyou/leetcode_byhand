package in.kaixin.leetcode_byhand.tree;

import java.util.Stack;

public class LowestCommonAncestor {//

    //TODO
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> pstack = new Stack<>();
        Stack<TreeNode> qstack = new Stack<>();
        return null;
    }

    public void find(TreeNode root, Stack<TreeNode> stack, TreeNode node) {
        if (root == null) {
            return;
        }
        if (root != null) {
            stack.push(root);
        }
        if (root.equals(node)) {
            return;
        }
        find(root.left, stack, node);
        find(root.right, stack, node);

    }

}
