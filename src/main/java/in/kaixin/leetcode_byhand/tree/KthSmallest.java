package in.kaixin.leetcode_byhand.tree;

import in.kaixin.leetcode_byhand.common.TreeNode;
import in.kaixin.leetcode_byhand.utils.Utils;

public class KthSmallest {
//    https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
    int left = 0;
    Integer v = null;

    public int kthSmallest(TreeNode root, int k) {
        this.left = k;
        this.v = null;
        midTrans(root);
        return v;
    }

    public void midTrans(TreeNode node) {
        if (node == null) {
            return;
        }
        midTrans(node.left);
        left--;
        if (left == 0) {
            if (v == null) {
                v = node.val;
            }
            return;
        }
        midTrans(node.right);
    }

    public static void main(String[] args) {
        KthSmallest kthSmallest = new KthSmallest();
        System.out.println(kthSmallest.kthSmallest(Utils.getTreeNode(new Integer[]{3, 1, 4, null, 2}), 1));
        System.out.println(kthSmallest.kthSmallest(Utils.getTreeNode(new Integer[]{3, 1, 4, null, 2}), 2));
        System.out.println(kthSmallest.kthSmallest(Utils.getTreeNode(new Integer[]{3, 1, 4, null, 2}), 3));
        System.out.println(kthSmallest.kthSmallest(Utils.getTreeNode(new Integer[]{3, 1, 4, null, 2}), 4));
        System.out.println(kthSmallest.kthSmallest(Utils.getTreeNode(new Integer[]{5, 3, 6, 2, 4, null, null, 1}), 1));
        System.out.println(kthSmallest.kthSmallest(Utils.getTreeNode(new Integer[]{5, 3, 6, 2, 4, null, null, 1}), 2));
        System.out.println(kthSmallest.kthSmallest(Utils.getTreeNode(new Integer[]{5, 3, 6, 2, 4, null, null, 1}), 3));
        System.out.println(kthSmallest.kthSmallest(Utils.getTreeNode(new Integer[]{5, 3, 6, 2, 4, null, null, 1}), 4));
        System.out.println(kthSmallest.kthSmallest(Utils.getTreeNode(new Integer[]{5, 3, 6, 2, 4, null, null, 1}), 5));
        System.out.println(kthSmallest.kthSmallest(Utils.getTreeNode(new Integer[]{5, 3, 6, 2, 4, null, null, 1}), 6));
    }

}
