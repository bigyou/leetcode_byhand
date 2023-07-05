package in.kaixin.leetcode_byhand.numbers;

import in.kaixin.leetcode_byhand.ListNode;

/**
 * @Author bigyou
 * @Create 2023/7/5 20:33
 */
public class AddTwoNumbersSimple {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cursor1 = l1;
        ListNode cursor2 = l2;
        int flag = 0;
        ListNode res = new ListNode();
        ListNode cursor = res;
        while (cursor2 != null || cursor1 != null || flag != 0) {
            ListNode node = new ListNode();
            int tmp = flag;
            if (cursor2 != null) {
                tmp += cursor2.val;
                cursor2 = cursor2.next;
            }
            if (cursor1 != null) {
                tmp += cursor1.val;
                cursor1 = cursor1.next;
            }
            flag = tmp > 9 ? 1 : 0;
            tmp = tmp % 10;
            node.val = tmp;
            cursor.next = node;
            cursor = node;
        }
        return res.next;
    }
}
