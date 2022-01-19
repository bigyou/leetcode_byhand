package in.kaixin.leetcode_byhand.other;

import in.kaixin.leetcode_byhand.ListNode;

import java.util.List;

public class AddTwoNumbers {
    //    https://leetcode-cn.com/problems/add-two-numbers/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode firstCursor = l1;
        ListNode secCursor = l2;
        ListNode dummy = new ListNode(-1);
        ListNode cursor = dummy;
        int addOne = 0;
        while (firstCursor != null && secCursor != null) {
            int v = firstCursor.val + secCursor.val + addOne;
            addOne = addNode(cursor, v);
            firstCursor = firstCursor.next;
            secCursor = secCursor.next;
            cursor = cursor.next;
        }
        while (firstCursor != null) {
            int v = firstCursor.val + addOne;
            addOne = addNode(cursor, v);
            firstCursor = firstCursor.next;
            cursor = cursor.next;

        }
        while (secCursor != null) {
            int v = secCursor.val + addOne;
            addOne = addNode(cursor, v);
            secCursor = secCursor.next;
            cursor = cursor.next;
        }
        if (addOne != 0) {
            addNode(cursor, addOne);
            cursor = cursor.next;
        }
        return dummy.next;

    }

    public int addNode(ListNode cursor, int v) {
        int addOne = v / 10;
        int val = v % 10;
        ListNode node = new ListNode(val);
        cursor.next = node;
        cursor = cursor.next;
        return addOne;
    }

    public static void main(String[] args) {
        ListNode node2 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        node2.next = node4;
        node4.next = node3;

        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node44 = new ListNode(4);

        node5.next = node6;
        node6.next = node44;
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode listNode = addTwoNumbers.addTwoNumbers(node2, node5);
        System.out.println(listNode);
    }


}
