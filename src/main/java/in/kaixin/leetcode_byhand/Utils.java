package in.kaixin.leetcode_byhand;

import in.kaixin.leetcode_byhand.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Utils {
    public static ListNode getListNode(int[] nums) {
        if (nums == null) {
            return null;
        }
        ListNode root = new ListNode(nums[0]);
        ListNode cursor = root;
        for (int i = 1; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            cursor.next = node;
            cursor = cursor.next;
        }
        return root;
    }

    public static TreeNode getTreeNode(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode();
        root.setVal(nums[0]);
        List<TreeNode> list = new LinkedList<>();
        list.add(root);
        for (int i = 1; i < nums.length; i++) {
            TreeNode node = new TreeNode();
            node.setVal(nums[i]);
            if ((i - 1) % 2 == 0) {//左节点
                list.get((i - 1) / 2).left = node;
            } else {//右节点
                list.get((i - 1) / 2).right = node;
            }
            list.add(node);
        }
        return root;
    }
}
