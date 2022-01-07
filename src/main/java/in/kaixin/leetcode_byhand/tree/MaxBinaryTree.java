package in.kaixin.leetcode_byhand.tree;

public class MaxBinaryTree {
    //    https://leetcode-cn.com/problems/maximum-binary-tree/
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        TreeNode root = add(nums, 0, nums.length - 1);
        return root;
    }

    public TreeNode add(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        Integer max = null;
        Integer index = -1;
        for (int i = left; i <= right; i++) {
            if (max == null) {
                max = nums[i];
                index = i;
                continue;
            }
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode no = new TreeNode(nums[index]);

        no.left = add(nums, left, index - 1);
        no.right = add(nums, index + 1, right);
        return no;

    }


}
