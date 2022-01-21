package in.kaixin.leetcode_byhand.tree;

import in.kaixin.leetcode_byhand.common.TreeNode;

public class SumRoot2LeavesNumber {
    //    https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
    public int sumNumbers(TreeNode root) {

        int v = caculate(root, "", 0);
        return v;
    }

    public int caculate(TreeNode node, String str, int v) {

        if (node.left == null && node.right == null) {
            return new Integer(str + node.val) + v;
        }
        if (node.left != null)
            v = caculate(node.left, str + node.val, v);
        if (node.right != null)
            v = caculate(node.right, str + node.val, v);
        return v;

    }

    public static void main(String[] args) {

        TreeNode treeNodeL = new TreeNode(2);
        TreeNode treeNodeR = new TreeNode(3);
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = treeNodeL;
        treeNode.right = treeNodeR;
        SumRoot2LeavesNumber sumRoot2LeavesNumber = new SumRoot2LeavesNumber();
        System.out.println(sumRoot2LeavesNumber.sumNumbers(treeNode));
    }
}
