package in.kaixin.leetcode_byhand.tree;

import in.kaixin.leetcode_byhand.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class FindTarget {
//    https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/submissions/
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new LinkedList<>();
        transfer(root, list);
        int left = 0;
        int right = list.size() - 1;
        if (k > 2 * list.get(right)) {
            return false;
        }
        int cnt = 0;
        while (left < right) {
            cnt = list.get(left) + list.get(right);
            if (cnt == k) {
                return true;
            } else if (cnt > k) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }

    public void transfer(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }
        transfer(treeNode.left, list);
        list.add(treeNode.val);
        transfer(treeNode.right, list);
    }
}
