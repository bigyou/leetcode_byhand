package in.kaixin.leetcode_byhand.link;

import in.kaixin.leetcode_byhand.ListNode;
import in.kaixin.leetcode_byhand.utils.Utils;

public class SwapPairs {
    //    https://leetcode-cn.com/problems/swap-nodes-in-pairs/
    public ListNode swapPairs(ListNode head) {


        if (head==null||head.next == null) {
            return head;
        }
        ListNode newHead = null;
        ListNode cursor = head;
        ListNode pre = null;
        while (cursor != null && cursor.next != null) {
            ListNode next = cursor.next;
            cursor.next = next.next;
            next.next = cursor;
            if (pre != null) {
                pre.next = next;
            }
            pre = cursor;
            cursor = cursor.next;
            if (newHead == null) {
                newHead = next;
            }

        }
        return newHead;
    }

    public static void main(String[] args) {
        SwapPairs swapPairs = new SwapPairs();
        ListNode listNode = Utils.getListNode(new int[]{1});
        listNode = swapPairs.swapPairs(listNode);
        Utils.printNode(listNode);


    }
}
