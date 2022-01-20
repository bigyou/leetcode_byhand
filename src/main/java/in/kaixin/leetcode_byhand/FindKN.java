package in.kaixin.leetcode_byhand;

import sun.awt.image.ImageWatched;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindKN {
    Integer targetLevel = null;

    /**
     * 大概的解题思路是将二叉树进行分层次定位，以二叉树root节点为0层，右侧开始每一层+1 ，左侧每一层-1
     * 最后合并 目标元素的N+K 和N-K层
     *
     * @param root
     * @param target
     * @param K
     * @return
     */
    public List<Integer> findKN(TreeNode root, Integer target, Integer K) {
        Integer level = null;
        Map<Integer, List<Integer>> map = new HashMap<>();
        travel(root, 0, map, 0, target);
        if (targetLevel == null) {
            return null;
        }
        List<Integer> res = new LinkedList<>();
        if (map.containsKey(targetLevel + K)) {
            res.addAll(map.get(targetLevel + K));
        }
        if (map.containsKey(targetLevel - K)) {
            res.addAll(map.get(targetLevel - K));

        }
        return res;
    }

    /**
     * @param root
     * @param level
     * @param levelMap
     * @param side     =0表示中间的root节点，-1表示root左边的节点，1表示root右边
     */
    public void travel(TreeNode root, Integer level, Map<Integer, List<Integer>> levelMap, Integer side, Integer target) {
        if (root == null) {
            return;
        }
        List<Integer> list = levelMap.get(level);
        if (list == null) {
            list = new LinkedList<>();
            levelMap.put(level, list);
        }
        if (root.val == target) {
            targetLevel = level;
        }
        if (side == 0) {
            travel(root.left, level - 1, levelMap, -1, target);
            travel(root.right, level + 1, levelMap, 1, target);
        } else {
            travel(root.left, level + side, levelMap, side, target);
            travel(root.right, level + side, levelMap, side, target);
        }


    }


}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

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
}
