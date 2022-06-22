package in.kaixin.leetcode_byhand.tree;

import in.kaixin.leetcode_byhand.common.TreeNode;
import in.kaixin.leetcode_byhand.utils.Utils;

import java.util.LinkedList;
import java.util.List;

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree2(TreeNode root) {
        List<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);
        int res = Integer.MIN_VALUE;
        int i = 0;
        while (i < nodeList.size()) {
            TreeNode node = nodeList.get(i);
            int max = maxPath(node.left) + maxPath(node.right);
            res = Math.max(max, res);
            if (max > res / 2) {//
                if (node.left != null) {
                    nodeList.add(node.left);
                }
                if (node.right != null) {
                    nodeList.add(node.right);
                }
            }
            i++;
        }


        return res;
    }

    public int maxPath(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(maxPath(node.left) + 1, maxPath(node.right) + 1);
    }


    int res = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDeep(root);
        return res;
    }

    public int maxDeep(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int L = maxDeep(node.left);
        int R = maxDeep(node.right);
        res = Math.max(L + R, res);
        return Math.max(L, R) + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = Utils.getTreeNode(new Integer[]{4, -7, -3, null, null, -9, -3, 9, -7, -4, null, 6, null, -6, -6, null, null, 0, 6, 5, null, 9, null, null, -1, -4, null, null, null, -2});
        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
        System.out.println(diameterOfBinaryTree.diameterOfBinaryTree(treeNode));
    }
}
