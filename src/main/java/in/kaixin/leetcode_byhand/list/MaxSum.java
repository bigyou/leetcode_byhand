package in.kaixin.leetcode_byhand.list;

import java.util.HashSet;
import java.util.Set;

public class MaxSum {
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        Integer sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            max = max < 0 ? Math.max(max, nums[i]) : max;
            if (nums[i] > 0) {
                sum += nums[i];
                set.add(nums[i]);
            }
        }
        if (max < 0) {
            sum = max;
        }
        return sum;

    }
}
