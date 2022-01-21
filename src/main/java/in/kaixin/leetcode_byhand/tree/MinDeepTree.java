package in.kaixin.leetcode_byhand.tree;

import in.kaixin.leetcode_byhand.Utils;
import in.kaixin.leetcode_byhand.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinDeepTree {
    //    https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
    public int minDepth(TreeNode root) {
        int dep = 0;
        if (root == null) {
            return dep;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);//需要将根节点加进去
        dep = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {//这里需要只取出这一层数量的节点
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) {
                    return dep;
                }
                if (poll.left != null)
                    queue.add(poll.left);
                if (poll.right != null)
                    queue.add(poll.right);
            }
            dep++;
        }
        return dep;
    }

    public static void main(String[] args) {
        TreeNode treeNode = Utils.getTreeNode(new int[]{1, 2, 3, 4, 5});
        MinDeepTree minDeepTree = new MinDeepTree();
        System.out.println(minDeepTree.minDepth(treeNode));
    }


}
