package in.kaixin.leetcode_byhand.tree;

import java.util.LinkedList;
import java.util.List;

public class PathSum2 {
    //    https://leetcode-cn.com/problems/path-sum-ii/
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new LinkedList<>();
        if(root==null){
            return res;
        }

        find(root, targetSum, 0, new LinkedList<Integer>(), res);
        //TODO 去掉重复的
        return res;
    }

    public void find(TreeNode root, int targetSum, int v, List<Integer> path, List<List<Integer>> list) {
        if (root.left == null && root.right == null) {
            if (v + root.val == targetSum) {
                path.add(root.val);
                List<Integer> copy = copy(path);
                if (copy != null) {
                    list.add(copy);
                }
                path.remove(path.size() - 1);
            }
            return;
        }
        path.add(root.val);
        if (root.left != null) {
            find(root.left, targetSum, v + root.val, path, list);
        }
        if (root.right != null) {
            find(root.right, targetSum, v + root.val, path, list);
        }
        path.remove(path.size() - 1);
    }

    public List<Integer> copy(List<Integer> from) {
        if (from == null) {
            return null;
        }
        List<Integer> to = new LinkedList<>();
        for (Integer i : from) {
            to.add(i);
        }
        return to;
    }
}
