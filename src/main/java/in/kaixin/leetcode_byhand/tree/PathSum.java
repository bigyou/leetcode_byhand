package in.kaixin.leetcode_byhand.tree;

import in.kaixin.leetcode_byhand.common.TreeNode;

public class PathSum {
//    https://leetcode-cn.com/problems/path-sum/


    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        boolean find = sum(root, targetSum, 0);
        return find;
    }

    public boolean sum(TreeNode root, int targetSum, int v) {
        if (root.left == null && root.right == null) {//叶子节点
            return v + root.val == targetSum;
        }
        boolean find = false;
        if (root.left != null) {
            find = sum(root.left, targetSum, v + root.val);
        }
        if (!find && root.right != null) {
            find = sum(root.right, targetSum, v + root.val);
        }
        return find;
    }
}
