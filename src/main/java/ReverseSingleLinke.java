public class ReverseSingleLinke {
//    https://leetcode-cn.com/problems/reverse-linked-list/submissions/

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode cursor = head;
        ListNode pre = null;
        while (cursor != null) {
            ListNode next = cursor.next;
            cursor.next = pre;
            pre = cursor;
            cursor = next;
        }
        return pre;
    }

    public static void main(String... args) {

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
