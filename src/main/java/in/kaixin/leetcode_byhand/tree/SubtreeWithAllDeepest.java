package in.kaixin.leetcode_byhand.tree;

import in.kaixin.leetcode_byhand.common.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SubtreeWithAllDeepest {
    //    https://leetcode.cn/problems/smallest-subtree-with-all-the-deepest-nodes/?envType=daily-question&envId=2026-01-09
//    mid
    int maxDeep = 0;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        maxDeep = 0;
        List<Integer> treeNodeLists = new LinkedList<>();
        Map<Integer, TreeNode> map = new HashMap<>();
        dfs(root, 1, 0, map, treeNodeLists);
        Integer minIndex = treeNodeLists.get(0);
        Integer maxIndex = treeNodeLists.get(treeNodeLists.size() - 1);
        while (minIndex - maxIndex!=0) {
            minIndex = minIndex / 2;
            maxIndex = maxIndex / 2;
        }
        return map.get(minIndex);
    }

    public void dfs(TreeNode node, int n, int deep, Map<Integer, TreeNode> map, List<Integer> maxDeepNodeIndex) {
        if (node == null) {
            return;
        }
        dfs(node.left, 2 * n, deep + 1, map, maxDeepNodeIndex);
        dfs(node.right, 2 * n + 1, deep + 1, map, maxDeepNodeIndex);
        if (deep > maxDeep) {
            maxDeepNodeIndex.clear();
            maxDeep = deep;
        }
        if (deep == maxDeep) {
            maxDeepNodeIndex.add(n);
        }
        map.put(n, node);
    }

//    public static void main(String[] args) {
////        TreeNode root = new TreeNode(3);
////        root.left = new TreeNode(5);
////        root.right = new TreeNode(1);
////        root.left.left = new TreeNode(6);
////        root.left.right = new TreeNode(2);
////        root.right.left = new TreeNode(0);
////        root.right.right = new TreeNode(8);
////        root.left.right.left = new TreeNode(7);
////        root.left.right.right = new TreeNode(4);
//
//        SubtreeWithAllDeepest deepest = new SubtreeWithAllDeepest();
//
//        Integer[] arr = new Integer[]{0, 8, 1, 17, null, 2, 15, 18, 20, 6, 3, 27, 38, null, 19, 60, null, 21, 7, 5, 4, 31, null, 71, null, 34, null, 64, 67, 65, 39, 9, 58, 12, 10, 22, 54, 40, 72, 75, null, null, 37, null, null, 96, null, 76, 70, 80, 88, 32, 16, 81, 74, 23, 13, 28, 11, 26, 79, null, null, null, 43, null, null, null, null, null, 66, null, null, 78, null, 95, null, 93, null, 92, null, null, 57, 24, 82, 98, null, null, null, 29, 30, 14, null, 35, 33, null, 69, 59, 45, 89, null, 53, 87, 83, null, null, null, null, null, null, null, null, null, 97, null, 25, null, null, null, null, null, 46, 48, 44, null, null, null, null, 47, 49, 55, null, 84, 63, null, null, 51, null, null, 56, 90, null, null, null, null, null, null, 41, 36, 50, null, null, null, null, null, null, null, null, null, 77, null, null, null, null, null, null, null, null, 61, null, null, null, null, 42, null, null, 73, 86, null, 62, 91, 52, null, null, null, null, 94, null, 68, null, null, 99, 85};
//        TreeNode root = TreeNode.generate(arr);
//        TreeNode res = deepest.subtreeWithAllDeepest(root);
//        System.out.println(res.val);
//
////        TreeNode treeNode= TreeNode.generate(new LinkedList<>([0,8,1,17,null,2,15,18,20,6,3,27,38,null,19,60,null,21,7,5,4,31,null,71,null,34,null,64,67,65,39,9,58,12,10,22,54,40,72,75,null,null,37,null,null,96,null,76,70,80,88,32,16,81,74,23,13,28,11,26,79,null,null,null,43,null,null,null,null,null,66,null,null,78,null,95,null,93,null,92,null,null,57,24,82,98,null,null,null,29,30,14,null,35,33,null,69,59,45,89,null,53,87,83,null,null,null,null,null,null,null,null,null,97,null,25,null,null,null,null,null,46,48,44,null,null,null,null,47,49,55,null,84,63,null,null,51,null,null,56,90,null,null,null,null,null,null,41,36,50,null,null,null,null,null,null,null,null,null,77,null,null,null,null,null,null,null,null,61,null,null,null,null,42,null,null,73,86,null,62,91,52,null,null,null,null,94,null,68,null,null,99,85]))
//
//
//    }

}
