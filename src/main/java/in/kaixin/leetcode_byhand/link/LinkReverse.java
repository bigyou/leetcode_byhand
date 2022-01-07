package in.kaixin.leetcode_byhand.link;


import in.kaixin.leetcode_byhand.ListNode;

import javax.swing.*;
import java.util.Stack;

public class LinkReverse {
    //    https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode first = null;
        ListNode cursor = head;
        ListNode preCursor = null;
        while (cursor != null) {
            stack.push(cursor);
            cursor = cursor.next;
            if (stack.size() == k) {
                if (first == null) {
                    first = stack.peek();
                }
                while (!stack.isEmpty()) {
                    ListNode pop = stack.pop();
                    pop.next = null;
                    if (preCursor == null) {
                        preCursor = pop;
                    } else {
                        preCursor.next = pop;
                        preCursor = pop;
                    }
                }
            }
        }
        if (!stack.isEmpty())
            preCursor.next = stack.firstElement();
        return first;
    }

    public static void main(String... args) {
        ListNode root = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        root.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        LinkReverse re = new LinkReverse();
        re.reverseKGroup(root, 3);
    }

}


