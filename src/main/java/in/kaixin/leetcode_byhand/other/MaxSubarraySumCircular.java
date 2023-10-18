package in.kaixin.leetcode_byhand.other;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author bigyou
 * @Create 2023/7/20 19:52
 */
public class MaxSubarraySumCircular {
//    https://leetcode.cn/problems/maximum-sum-circular-subarray/
//    mid

    public int maxSubarraySumCircular(int[] nums) {
        long max = Integer.MIN_VALUE;

        for (int left = 0; left < nums.length; ) {
            long sum = 0;
            max = Math.max(nums[left], max);
            if (nums[left] < 0) {
                left++;
                continue;
            }
            int right = left;
            for (; right < nums.length + left; right++) {
                sum += nums[right % nums.length];
                if (sum <= 0) {
                    left = right;
                    break;
                }
                max = Math.max(sum, max);
            }
            if (left != right) {
                left++;
            }
        }
        return (int) max;
    }


    public static void main(String[] args) {
        MaxSubarraySumCircular m = new MaxSubarraySumCircular();
//        System.out.println(m.maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
//        System.out.println(m.maxSubarraySumCircular(new int[]{5,-3,5}));
        System.out.println(m.maxSubarraySumCircular(new int[]{0, 2, -2}));


    }

}
