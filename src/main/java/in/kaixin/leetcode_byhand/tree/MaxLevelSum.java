package in.kaixin.leetcode_byhand.tree;

import in.kaixin.leetcode_byhand.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class MaxLevelSum {
    //   广度搜索
    //    public  static int maxLevelSum(TreeNode root) {
//        int level = 0;
//        int levelSum = 0;
//        int maxLevel = 0;//
//        int maxLevelSum = Integer.MIN_VALUE;
//        List<TreeNode> current = new LinkedList<>();
//        List<TreeNode> next = new LinkedList<>();
//        current.add(root);
//        Iterator<TreeNode> iterator = current.iterator();
//        while (iterator.hasNext()) {
//            TreeNode node = iterator.next();
//            if (node.left != null) {
//                next.add(node.left);
//            }
//            if (node.right != null) {
//                next.add(node.right);
//            }
//            levelSum += node.val;
//            if (!iterator.hasNext()) {
//
//                current.clear();
//                current.addAll(next);
//                iterator=current.iterator();
//                next.clear();
//                if (levelSum > maxLevelSum) {
//                    maxLevel = level;
//                    maxLevelSum = levelSum;
//                }
//                level++;
//                levelSum = 0;
//            }
//
//        }
//        return maxLevel+1;
//    }
//    深度搜索
    public int maxLevelSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        deepVisit(root, map, 0);
        int maxLevel = 0;
        int maxv = Integer.MIN_VALUE;
        for (Integer i : map.keySet()) {
            if (maxv < map.get(i)) {
                maxLevel = i;
                maxv = map.get(i);
            }
        }

        return maxLevel + 1;
    }

    public void deepVisit(TreeNode node, Map<Integer, Integer> map, int level) {
        if (node == null) {
            return;
        }
        deepVisit(node.left, map, level + 1);
        Integer v = map.getOrDefault(level, 0);
        v += node.val;
        map.put(level, v);
        deepVisit(node.right, map, level + 1);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = -100;
        root.left = new TreeNode(-200);
        root.right = new TreeNode(-300);
        root.left.left = new TreeNode(-20);
        root.left.right = new TreeNode(-20);
        root.right.left = new TreeNode(-10);
        MaxLevelSum maxLevelSum = new MaxLevelSum();
        maxLevelSum.maxLevelSum(root);

    }


}
