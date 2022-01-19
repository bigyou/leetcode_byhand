package in.kaixin.leetcode_byhand;

public class Utils {
    public static ListNode getListNode(int[] nums) {
        if (nums == null) {
            return null;
        }
        ListNode root = new ListNode(nums[0]);
        ListNode cursor = root;
        for (int i = 1; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            cursor.next = node;
            cursor = cursor.next;
        }
        return root;
    }
}
