package in.kaixin.leetcode_byhand.link;

import in.kaixin.leetcode_byhand.ListNode;

public class MergeKlink {
//    https://leetcode-cn.com/problems/merge-k-sorted-lists/

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode node = merge(lists, 0, lists.length - 1);
        return node;
    }

    public ListNode merge(ListNode[] lists, int begin, int end) {
        if (end - begin == 0) {
            return lists[begin];
        } else if (begin - end == 1) {
            //merge two
            return merge(lists[begin], lists[end]);
        }
        ListNode a = merge(lists, begin, (begin + end) / 2);
        ListNode b = merge(lists, (begin + end) / 2 + 1, end);
        return merge(a, b);
    }

    public ListNode merge(ListNode a, ListNode b) {
        if (a == null && b == null) {
            return null;
        }
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        ListNode acursor = a;
        ListNode bcursor = b;
        ListNode cursor = new ListNode(-1);
        ListNode head = null;
        while (acursor != null && bcursor != null) {
            if (acursor.val < bcursor.val) {
                if (head == null) {
                    head = acursor;
                }
                cursor.next = acursor;
                cursor = cursor.next;
                acursor = acursor.next;
                if (acursor == null) {
                    cursor.next = bcursor;
                }
            } else {
                if (head == null) {
                    head = bcursor;
                }
                cursor.next = bcursor;
                cursor = cursor.next;
                bcursor = bcursor.next;
                if (bcursor == null) {
                    cursor.next = acursor;
                }
            }
        }
        return head;
    }

}
