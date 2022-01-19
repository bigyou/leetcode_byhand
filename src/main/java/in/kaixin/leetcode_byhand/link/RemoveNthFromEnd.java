package in.kaixin.leetcode_byhand.link;

import in.kaixin.leetcode_byhand.ListNode;

public class RemoveNthFromEnd {
    //    https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode faster = head;

        for (int i = 0; i < n; i++) {
            if (faster == null) {
                return head;
            }
            faster = faster.next;
        }
        ListNode root = new ListNode(-1);
        ListNode slow = root;
        slow.next = head;

        while (faster != null) {
            faster = faster.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = slow.next.next;
        temp.next = null;
        return root.next;

    }


}

