package in.kaixin.leetcode_byhand.link;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author bigyou
 * @Create 2023/7/31 19:01
 */
public class ReorderList2 {
    //    https://leetcode.cn/problems/reorder-list/description/
//    mid
    public void reorderList(ListNode head) {
        int size = 0;
        ListNode cursor = head;
        List<ListNode> nodes = new LinkedList<>();
        while (cursor != null) {
            cursor = cursor.next;
            nodes.add(cursor);
        }
        int left = 0;
        int right = nodes.size() - 1;
        ListNode preNode = null;
        while (left < right) {
            ListNode leftNode = nodes.get(left);
            ListNode rightNode = nodes.get(right);
            leftNode.next = rightNode;
            if (preNode != null) {
                preNode.next = leftNode;
            }
            preNode = rightNode;
            left++;
            right++;

        }
        if(left==right){
            ListNode leftNode = nodes.get(left);
            if(preNode!=null){
                preNode.next=leftNode;

            }
        }
    }
}
