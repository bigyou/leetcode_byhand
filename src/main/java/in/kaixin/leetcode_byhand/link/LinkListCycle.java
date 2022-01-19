package in.kaixin.leetcode_byhand.link;

import in.kaixin.leetcode_byhand.ListNode;

public class LinkListCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        int circleSize = 0;
        while (true) {
            if (fast.next == null || fast.next.next == null) {
                return null;//不存在环
            }
            fast = fast.next.next;
            slow = slow.next;
            circleSize++;
            if (fast == slow) {
                break;
            }
        }
        fast = head;
        slow = head;
        for (int i = 0; i < circleSize; i++) {
            fast = fast.next;
        }
        while (true) {
            if (fast == slow) {
                return fast;
            }
            fast = fast.next;
            slow = slow.next;
        }
    }
}
