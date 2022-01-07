package in.kaixin.leetcode_byhand.tree;

import java.util.Stack;

public class TreebstFromPreorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode rootNode = new TreeNode(preorder[0]);
        if (preorder.length == 1) {
            return rootNode;
        }
        for (int i = 1; i < preorder.length; i++) {
            add(rootNode, preorder[i]);
        }
        return rootNode;

    }

    public void add(TreeNode rootNode, int value) {
        if (value < rootNode.val) {
            if (rootNode.left == null) {
                rootNode.left = new TreeNode(value);
            } else {
                add(rootNode.left, value);
            }
        } else {
            if (rootNode.right == null) {
                rootNode.right = new TreeNode(value);
            } else {
                add(rootNode.right, value);
            }
        }
    }

    public TreeNode bstFromPreorder2usestack(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode rootNode = new TreeNode(preorder[0]);
        if (preorder.length == 1) {
            return rootNode;
        }
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode treeNode = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        for (int i = 1; i < preorder.length; i++) {

            addWithstack(stack, preorder[i]);

        }
        return root;
    }

    public void addWithstack(Stack<TreeNode> stack, Integer value) {
        TreeNode nodeInStack = stack.peek();
        if (value < nodeInStack.val) {
            nodeInStack.left = new TreeNode(value);
            stack.push(nodeInStack.left);
        } else {
            TreeNode child = stack.pop();
            while (!stack.isEmpty() && stack.peek().val < value) {
                child = stack.pop();
            }
            child.right = new TreeNode(value);
            stack.push(child.right);

        }

    }

    public static void main(String... args) {
        TreebstFromPreorder t = new TreebstFromPreorder();
        TreeNode tr = t.bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
        System.out.println(tr);
    }
}

