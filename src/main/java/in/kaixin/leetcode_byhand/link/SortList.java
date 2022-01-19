package in.kaixin.leetcode_byhand.link;

import in.kaixin.leetcode_byhand.ListNode;
import in.kaixin.leetcode_byhand.Utils;

import java.util.Currency;
import java.util.LinkedList;
import java.util.List;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<ListNode> list = new LinkedList<>();
        ListNode cursor = head;
        while (cursor != null) {
            list.add(cursor);
            cursor = cursor.next;
        }
        quickSort(list, 0, list.size() - 1);
        ListNode root = list.get(0);
        cursor = root;
        for (int i = 1; i < list.size(); i++) {
            list.get(i).next = null;
            cursor.next = list.get(i);
            cursor = cursor.next;
        }
        return root;

    }

    public void quickSort(List<ListNode> list, int start, int end) {
        if (start >= end) {
            return;
        }
        ListNode va = list.get(start);
        int flag = 0;//左边可以
        int left = start;
        int right = end;
        while (left < right) {
            if (flag == 0) {//开始弄右边
                if (list.get(right).val < va.val) {
                    list.set(left, list.get(right));
                    flag = 1;
                    left++;
                } else {
                    right--;
                }
            } else {// 开始弄左边
                if (list.get(left).val > va.val) {
                    list.set(right, list.get(left));
                    right--;
                    flag = 0;
                } else {
                    left++;
                }
            }
        }
        list.set(left, va);
        quickSort(list, start, left - 1);
        quickSort(list, left + 1, end);
        return;
    }

    public static void main(String[] args) {
        ListNode root = Utils.getListNode(new int[]{4, 2, 1, 3});
        SortList sortList = new SortList();
        sortList.sortList(root);

    }

}
