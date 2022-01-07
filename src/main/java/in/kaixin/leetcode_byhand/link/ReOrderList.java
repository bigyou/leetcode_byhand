package in.kaixin.leetcode_byhand.link;

import in.kaixin.leetcode_byhand.ListNode;

import java.util.Stack;

public class ReOrderList {
    //    https://leetcode-cn.com/problems/reorder-list/
    Stack<ListNode> stack = new Stack<>();

    public void reorderList(ListNode head) {
        ListNode cursor = head;
        int size = 0;
        while (cursor != null) {
            stack.push(cursor);
            cursor = cursor.next;
            size++;
        }
        cursor = head;
        int times = size / 2;
        for (int i = 0; i <= times; i++) {
            ListNode temp = cursor;
            cursor = cursor.next;
            ListNode pop = stack.pop();
            temp.next = pop;
            pop.next = cursor;
            if (i == times) {
                if (size % 2 == 0) {
                    cursor.next = null;
                } else {
                    pop.next = null;
                }
            }
        }


    }

    public static void main(String... args) {
        System.out.println(-1 / 2);
    }
}
