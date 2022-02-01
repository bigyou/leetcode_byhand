package in.kaixin.leetcode_byhand.tree;

import in.kaixin.leetcode_byhand.common.TreeNode;

public class MaxDepth {
    //    https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
    int maxDep = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return maxDep;
        }
        travel(root, maxDep);

        return maxDep;
    }

    public void travel(TreeNode node, int dep) {
        if (node == null) {
            maxDep = Math.max(maxDep, dep);
            return;
        }
        travel(node.left, dep + 1);
        travel(node.right, dep + 1);


    }
}
