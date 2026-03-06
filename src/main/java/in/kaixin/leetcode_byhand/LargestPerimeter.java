package in.kaixin.leetcode_byhand;

import java.util.Arrays;

public class LargestPerimeter {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 3; i >= 0; i--) {
            if (nums[i] + nums[i + 1] > nums[i + 2]) {
                return nums[i] + nums[i + 2] + nums[i + 2];
            }

        }
        return 0;
    }
}
