package in.kaixin.leetcode_byhand.tree;

import in.kaixin.leetcode_byhand.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class TreeLevelOrder {
    //    https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
    //层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelList = new LinkedList<>();
        if (root == null) {
            return levelList;
        }
        level(levelList, root, 0);
        return levelList;

    }

    public void level(List<List<Integer>> levelList, TreeNode treeNode, Integer level) {
        if (levelList.size() < level + 1) {
            levelList.add(new LinkedList<>());
        }
        if (treeNode.left != null) {
            level(levelList, treeNode.left, level + 1);
        }
        List<Integer> list = levelList.get(level);
        list.add(treeNode.val);
        if (treeNode.right != null) {
            level(levelList, treeNode.right, level + 1);
        }
    }
}
