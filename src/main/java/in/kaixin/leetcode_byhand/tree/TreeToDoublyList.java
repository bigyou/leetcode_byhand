package in.kaixin.leetcode_byhand.tree;

import in.kaixin.leetcode_byhand.common.Node;

public class TreeToDoublyList {
    //    https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
    Node head = null;
    Node pre = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node travel = travel(root);
        return travel;
    }

    public Node travel(Node node) {
        if (node.left != null) {
            travel(node.left);
        }
        if (head == null) {
            head = node;
            pre = node;
        } else {
            pre.right = node;
            node.left = pre;
            pre = node;
        }

        if (node.right != null) {
            travel(node.right);
        }

        pre.right = head;
        head.left = pre;
        return head;
    }
}

