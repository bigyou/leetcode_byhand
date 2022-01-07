package in.kaixin.leetcode_byhand.tree;

public class InvertBinanaryTree {
//    https://leetcode-cn.com/problems/invert-binary-tree/

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left=root.right;
        root.right=temp;
        return root;
    }
}

