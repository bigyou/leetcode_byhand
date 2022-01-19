package in.kaixin.leetcode_byhand.tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructFromPreAndInOrder {
    //    https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder == null) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = build(preorder, 0, preorder.length - 1, inorder, 0, preorder.length - 1, map);
        return root;
    }


    public TreeNode build(int[] preOrder, int prestart, int preEnd, int[] inorder, int instart, int inend, Map<Integer, Integer> map) {

        if (prestart < 0 || prestart > preOrder.length - 1 || preEnd < 0 || prestart > preOrder.length - 1
                || prestart > preEnd || instart > inend
                || instart < 0 || instart > inorder.length - 1 || inend < 0 || inend > inorder.length - 1) {
            return null;
        }

        int nodev = preOrder[prestart];
        TreeNode newNode = new TreeNode(nodev);
        if (prestart == preEnd) {
            return newNode;
        }
        int index = map.get(nodev);
        newNode.left = build(preOrder, prestart + 1, prestart + index - instart, inorder, instart, index - 1, map);
        newNode.right = build(preOrder, prestart + index + 1 - instart, preEnd, inorder, index + 1, inend, map);
        return newNode;
    }

    public static void main(String[] args) {
        int[] preOrder = new int[]{1, 2};
        int[] inorder = new int[]{1, 2};

        ConstructFromPreAndInOrder constructFromPreAndInOrder = new ConstructFromPreAndInOrder();
        TreeNode node = constructFromPreAndInOrder.buildTree(preOrder, inorder);
        System.out.println(node);
    }
}
