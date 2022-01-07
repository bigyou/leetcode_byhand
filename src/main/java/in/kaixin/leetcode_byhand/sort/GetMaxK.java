package in.kaixin.leetcode_byhand.sort;

import java.util.Arrays;

public class GetMaxK {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
