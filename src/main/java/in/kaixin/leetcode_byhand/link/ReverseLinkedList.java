package in.kaixin.leetcode_byhand.link;

import in.kaixin.leetcode_byhand.ListNode;

import java.util.Stack;

public class ReverseLinkedList {
    //    https://leetcode-cn.com/problems/reverse-linked-list-ii/
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        if (left == right) {
            return head;
        }
        ListNode root = new ListNode();
        root.next = head;
        int i = 0;
        ListNode preStart = null;//第一个元素前一个
        ListNode endNext = null; //最后一个元素后
        ListNode cursor = root;
        Stack<ListNode> stack = new Stack<>();
        while (cursor != null) {
            if (i + 1 == left) {//前面一个
                preStart = cursor;
                i++;
                cursor = cursor.next;
                continue;
            }
            if (i < left) {
                i++;
                cursor = cursor.next;
                continue;
            }
            stack.push(cursor);
            cursor = cursor.next;
            if (i == right) {
                endNext = cursor;
                break;
            }
            i++;
        }
        if (preStart == null) {
            return null;
        }
        cursor = preStart;
        while (!stack.isEmpty()) {
            ListNode pop = stack.pop();
            pop.next = null;
            cursor.next = pop;
            cursor = cursor.next;
        }
        cursor.next = endNext;
        return root.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        head.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        reverseLinkedList.reverseBetween(head, 2, 4);

    }
}
