package in.kaixin.leetcode_byhand.tree;

import in.kaixin.leetcode_byhand.common.TreeNode;

public class LowestCommonAncestor {//

    //https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root, p, q);
        return res;
    }

    TreeNode res = null;

    public boolean find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean left = find(root.left, p, q);
        boolean right = find(root.right, p, q);

        if (((root == p || root == q) && (left || right))
                        || (left && right)) {
            res = root;
        }
        return root == p || root == q || left || right;

    }

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        node2.left = node7;
        node2.right = node4;
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5);
        node5.left = node6;
        node5.right = node2;
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node1 = new TreeNode(1);
        node1.left = node0;
        node1.right = node8;
        TreeNode root = new TreeNode(3);
        root.left = node5;
        root.right = node1;
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        TreeNode s = lowestCommonAncestor.lowestCommonAncestor(root, node5, node4);
        System.out.println(s.val);
    }

}
