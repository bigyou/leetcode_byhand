package in.kaixin.leetcode_byhand.link;

import in.kaixin.leetcode_byhand.ListNode;

import java.util.LinkedList;

public class DeleteDuplicates {
    //    https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
    public ListNode deleteDuplicates(ListNode head) {
        LinkedList<ListNode> list = new LinkedList<>();
        ListNode cursor = head;
        Integer duplicateValue = null;
        while (cursor != null) {
            if (list.isEmpty() && (duplicateValue == null || duplicateValue != cursor.val)) {
                list.add(cursor);
            } else {
                if (duplicateValue != null && cursor.val == duplicateValue) {

                } else if (list.getLast() != null && cursor.val == list.getLast().val) {
                    list.removeLast();
                    duplicateValue = cursor.val;
                } else {
                    list.add(cursor);
                }
            }
            cursor = cursor.next;
        }
        if (list.size() == 0) {
            return null;
        }
        ListNode root = list.get(0);
        cursor = root;
        root.next = null;
        for (int i = 1; i < list.size(); i++) {
            list.get(i).next = null;
            cursor.next = list.get(i);
            cursor = cursor.next;
        }
        return root;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode root3 = new ListNode(2);
//        ListNode root32 = new ListNode(2);
//        ListNode root33 = new ListNode(3);
//        ListNode root4 = new ListNode(4);
//        ListNode root44 = new ListNode(4);
//        ListNode root5 = new ListNode(5);
        root.next = node2;
        node2.next = root3;
//        root3.next = root32;
//        root32.next = root33;
//        root33.next = root4;
//        root4.next = root44;
//        root44.next = root5;
        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        deleteDuplicates.deleteDuplicates(root);
    }
}
