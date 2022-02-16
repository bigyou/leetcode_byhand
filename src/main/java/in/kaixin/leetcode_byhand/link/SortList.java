package in.kaixin.leetcode_byhand.link;

import in.kaixin.leetcode_byhand.ListNode;
import in.kaixin.leetcode_byhand.utils.Utils;

import java.util.Currency;
import java.util.LinkedList;
import java.util.List;

public class SortList {
//    public ListNode sortList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        List<ListNode> list = new LinkedList<>();
//        ListNode cursor = head;
//        while (cursor != null) {
//            list.add(cursor);
//            cursor = cursor.next;
//        }
//        quickSort(list, 0, list.size() - 1);
//        ListNode root = list.get(0);
//        cursor = root;
//        for (int i = 1; i < list.size(); i++) {
//            list.get(i).next = null;
//            cursor.next = list.get(i);
//            cursor = cursor.next;
//        }
//        return root;
//
//    }
//
//    public void quickSort(List<ListNode> list, int start, int end) {
//        if (start >= end) {
//            return;
//        }
//        ListNode va = list.get(start);
//        int flag = 0;//左边可以
//        int left = start;
//        int right = end;
//        while (left < right) {
//            if (flag == 0) {//开始弄右边
//                if (list.get(right).val < va.val) {
//                    list.set(left, list.get(right));
//                    flag = 1;
//                    left++;
//                } else {
//                    right--;
//                }
//            } else {// 开始弄左边
//                if (list.get(left).val > va.val) {
//                    list.set(right, list.get(left));
//                    right--;
//                    flag = 0;
//                } else {
//                    left++;
//                }
//            }
//        }
//        list.set(left, va);
//        quickSort(list, start, left - 1);
//        quickSort(list, left + 1, end);
//        return;
//    }
//
//    public static void main(String[] args) {
//        ListNode root = Utils.getListNode(new int[]{4, 2, 1, 3});
//        SortList sortList = new SortList();
//        sortList.sortList(root);
//
//    }

    public ListNode sortList(ListNode head) {
        if(head==null){
            return head;
        }
        List<ListNode> nodes = new LinkedList<>();
        ListNode cursor = head;
        while (cursor != null) {
            nodes.add(cursor);
            cursor = cursor.next;
            nodes.get(nodes.size() - 1).next = null;
        }
        List<ListNode> listNodes = mergeSort(nodes, 0, nodes.size() - 1);
        ListNode root = listNodes.get(0);
        for (int i = 1; i < listNodes.size(); i++) {
            listNodes.get(i - 1).next = listNodes.get(i);
        }
        return root;
    }

    public List<ListNode> mergeSort(List<ListNode> nodes, int start, int end) {
        if (start == end) {
            List<ListNode> list = new LinkedList<>();
            list.add(nodes.get(start));
            return list;
        }
        List<ListNode> left = mergeSort(nodes, start, (start + end) / 2);
        List<ListNode> right = mergeSort(nodes, (start + end) / 2 + 1, end);
        List<ListNode> merge = merge(left, right);
//        for (int i = start; i <= end; i++) {
//            nodes.set(i, merge.get(i - start));
//        }
        return merge;
    }

    public List<ListNode> merge(List<ListNode> left, List<ListNode> right) {
        List<ListNode> res = new LinkedList<>();
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex).val <= right.get(rightIndex).val) {
                res.add(left.get(leftIndex));
                leftIndex++;
            } else {
                res.add(right.get(rightIndex));
                rightIndex++;
            }
        }
        if (leftIndex < left.size()) {
            for (int i = leftIndex; i < left.size(); i++) {
                res.add(left.get(i));
            }
        }
        if (rightIndex < right.size()) {
            for (int i = rightIndex; i < right.size(); i++) {
                res.add(right.get(i));
            }

        }
        return res;
    }

    public static void main(String[] args) {
        ListNode root = Utils.getListNode(new int[]{5, 4, 2, 1, 3});
        SortList sortList = new SortList();
        sortList.sortList(root);

    }

}
