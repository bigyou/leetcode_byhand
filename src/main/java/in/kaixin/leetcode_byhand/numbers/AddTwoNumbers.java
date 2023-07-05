package in.kaixin.leetcode_byhand.numbers;

import in.kaixin.leetcode_byhand.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @Author bigyou
 * @Create 2023/7/5 19:55
 */
public class AddTwoNumbers {
//    https://leetcode.cn/problems/add-two-numbers-ii/
//    mid

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> l1que = new ArrayDeque<>();
        Deque<Integer> l2que = new ArrayDeque<>();
        ListNode cursor = l1;
        while (cursor != null) {
            l1que.addFirst(cursor.val);
            cursor = cursor.next;
        }
        cursor = l2;
        while (cursor != null) {
            l2que.addFirst(cursor.val);//这个地方容易写成addlast
            cursor = cursor.next;
        }
        int flag = 0;
        Deque<ListNode> deque = new ArrayDeque<>();
        while (l1que.size() > 0 || l2que.size() > 0) {
            int tmp = flag;
            if (l1que.size() > 0) {
                tmp += l1que.pollFirst();
            }
            if (l2que.size() > 0) {
                tmp += l2que.pollFirst();
            }
            flag = tmp > 9 ? 1 : 0;
            ListNode node = new ListNode();
            node.val = tmp % 10;
            deque.addFirst(node);
        }
        if(flag>0){//这个地方容易忽略
            ListNode node = new ListNode();
            node.val = flag;
            deque.addFirst(node);
        }
        ListNode res = deque.pollFirst();
        cursor = res;
        while (deque.size() > 0) {
            ListNode f = deque.pollFirst();
            cursor.next = f;
            cursor = f;

        }

        return res;
    }
}
