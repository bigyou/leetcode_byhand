package in.kaixin.leetcode_byhand.tree;

import in.kaixin.leetcode_byhand.common.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author bigyou
 * @Create 2023/7/20 21:59
 */
public class WidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<TreeNode> nodes = new LinkedList<>();
        List<TreeNode> nextLevelList = new LinkedList<>();
        nodes.add(root);
        long maxWidth = 1;
        Map<TreeNode, Long> map = new HashMap<>();
        map.put(root, 1l);

        while (nodes.size() > 0) {
            long left = Long.MAX_VALUE;
            long right = Long.MIN_VALUE;
            for (TreeNode node : nodes) {
                left = Math.min(map.get(node), left);
                right = Math.max(map.get(node), right);

                if (node.left != null) {
                    map.put(node.left, map.get(node) * 2 - 1);
                    nextLevelList.add(node.left);
                }
                if (node.right != null) {
                    map.put(node.right, map.get(node) * 2);
                    nextLevelList.add(node.right);
                }
            }
            maxWidth = Math.max(right - left + 1, maxWidth);
            nodes = nextLevelList;
            nextLevelList = new LinkedList<>();

        }

        return (int) maxWidth;
    }
}
