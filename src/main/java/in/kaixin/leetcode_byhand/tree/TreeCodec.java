package in.kaixin.leetcode_byhand.tree;

public class TreeCodec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if (root == null) {
            return null;
        }
        String str = sb.toString();
        if (str.endsWith(",")) {
            str = sb.substring(0, sb.length() - 1);
        }
        return str;
    }

    public void dealPreOrder(TreeNode node, StringBuffer sb) {
        sb.append(node.val).append(",");

        if (node.left != null) {
            dealPreOrder(node.left, sb);
        }
        if (node.right != null) {
            dealPreOrder(node.right, sb);
        }
        if (node.left == null && node.right == null) {
            sb.append("None").append(",");
            sb.append("None").append(",");
        }

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        return null;


    }
}
