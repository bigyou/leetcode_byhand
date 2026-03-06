package in.kaixin.leetcode_byhand.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public static TreeNode generate(Integer[] arr) {
        Map<Integer, TreeNode> map = new HashMap<>();
        TreeNode root = new TreeNode(arr[0]);
        map.put(0, root);
        for (int i = 1; i < arr.length; i++) {
            Integer v = arr[i];
            if (v == null) {
                continue;
            }
            TreeNode node = new TreeNode(v);
            map.put(i, node);
            if (i % 2 == 0) {
                map.get(i / 2).left = node;
            } else {
                map.get(i / 2).right = node;
            }
        }
        return root;
    }
}