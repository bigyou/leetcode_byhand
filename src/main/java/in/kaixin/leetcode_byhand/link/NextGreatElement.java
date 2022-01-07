package in.kaixin.leetcode_byhand.link;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreatElement {
    //    https://leetcode-cn.com/problems/next-greater-element-i/submissions/
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }
        LinkNode head = new LinkNode(-1);
        Map<Integer, LinkNode> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            LinkNode node = new LinkNode(nums2[i]);
            head.next = node;
            head = node;
            map.put(nums2[i], node);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            boolean find = false;
            LinkNode linkNode = map.get(nums1[i]);
            while (linkNode.next != null) {
                if (linkNode.next.val > nums1[i]) {
                    res[i] = linkNode.next.val;
                    find = true;
                    break;
                }
                linkNode = linkNode.next;
            }
            if (!find) {
                res[i] = -1;
            }
        }
        return res;

    }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int v = nums2[i];
            while (!stack.isEmpty()) {
                if (v > stack.peek()) {
                    stack.pop();
                    continue;
                } else {
                    nextGreaterMap.put(v, stack.peek());
                    break;
                }
            }
            stack.push(v);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int v = nums1[i];
            Integer biger = nextGreaterMap.getOrDefault(v, -1);
            res[i] = biger;
        }
        return res;
    }
}

class LinkNode {
    int val;
    LinkNode next;

    public LinkNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public LinkNode getNext() {
        return next;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }
}
