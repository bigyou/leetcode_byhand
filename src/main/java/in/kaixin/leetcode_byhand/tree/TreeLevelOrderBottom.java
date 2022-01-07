package in.kaixin.leetcode_byhand.tree;

import java.util.LinkedList;
import java.util.List;

public class TreeLevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelList = new LinkedList<>();
        if (root == null) {
            return levelList;
        }
        levelbottom(levelList, root, 0);
        return levelList;
    }

    public void levelbottom(List<List<Integer>> levelList, TreeNode treeNode, Integer level) {
        if (levelList.size() < level + 1) {
            levelList.add(0, new LinkedList<>());
        }
        if (treeNode.left != null) {
            levelbottom(levelList, treeNode.left, level + 1);
        }
        List<Integer> list = levelList.get(levelList.size() - 1 - level);
        list.add(treeNode.val);
        if (treeNode.right != null) {
            levelbottom(levelList, treeNode.right, level + 1);
        }
    }

}
