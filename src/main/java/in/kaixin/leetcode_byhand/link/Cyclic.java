package in.kaixin.leetcode_byhand.link;

import in.kaixin.leetcode_byhand.ListNode;

public class Cyclic {
    //    https://leetcode-cn.com/problems/linked-list-cycle/
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode onecursor = head;
        ListNode twocursor = head.next;
        boolean hasCycle = false;
        while (!hasCycle) {
            if (onecursor.next == null || twocursor == null || twocursor.next == null || twocursor.next.next == null) {
                return hasCycle;
            }
            if (onecursor == twocursor) {
                hasCycle = true;
                break;
            }
            onecursor = onecursor.next;
            twocursor = twocursor.next.next;
        }
        return hasCycle;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(3);
        root.next = new ListNode(2);
        root.next.next = new ListNode(0);
        root.next.next.next = new ListNode(-4);
        root.next.next.next.next = root.next;
        Cyclic cyclic = new Cyclic();
        boolean cycle = cyclic.hasCycle(root);
        System.out.println(cycle);
    }
}
