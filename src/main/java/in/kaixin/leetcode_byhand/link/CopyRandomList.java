package in.kaixin.leetcode_byhand.link;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
    //    https://leetcode-cn.com/problems/copy-list-with-random-pointer/
    public Node copyRandomList(Node head) {
        Node root = null;
        Node cur = head;
        Node pre = null;
        Map<Node, Node> relationNodeMap = new HashMap<>();
        while (cur != null) {
            Node copy = new Node(cur.val);
            if (root == null) {
                root = copy;
                pre = copy;
            } else {
                pre.next = copy;
                pre = copy;
            }
            relationNodeMap.put(cur, copy);
            cur = cur.next;
        }
        cur = head;
        Node newCur = root;
        while (cur != null) {
            if (cur.random != null) {
                newCur.random = relationNodeMap.get(cur.random);
            }
            cur = cur.next;
            newCur = newCur.next;

        }
        return root;
    }

    public static void main(String[] args) {
        CopyRandomList copyRandomList = new CopyRandomList();
        System.out.println(copyRandomList.copyRandomList(null));
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}