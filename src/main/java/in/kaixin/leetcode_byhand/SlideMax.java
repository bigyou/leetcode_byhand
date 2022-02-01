package in.kaixin.leetcode_byhand;

import java.util.Deque;
import java.util.LinkedList;

public class SlideMax {
//    https://leetcode-cn.com/problems/sliding-window-maximum/

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0 || k == 1) {
            return nums;
        }
        Deque<Integer> deque = new LinkedList();
        int i = 0;
        int[] res = new int[nums.length - k + 1];
        while (i < nums.length) {

            if (!deque.isEmpty() && i - deque.peekLast() > k - 1) {//这里需要留意 边界问题，原来有==这里其实是错的
                deque.pollLast();
            }
            while (!deque.isEmpty() && nums[deque.peekFirst()] < nums[i]) {
                deque.pollFirst();
            }
            deque.addFirst(i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekLast()];
            }
            i++;

        }
        return res;
    }

    public static void main(String[] args) {
        SlideMax slideMax = new SlideMax();
        int[] ints = slideMax.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(ints);
    }


}
