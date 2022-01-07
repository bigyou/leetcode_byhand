package in.kaixin.leetcode_byhand.search;

public class MaxSubArray {
    //    https://leetcode-cn.com/problems/maximum-subarray/
    public static int maxSubArray(int[] nums) {
        Integer max = nums[0];
        Integer maxN = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxN = Math.max(maxN + nums[i], nums[i]);
            max = Math.max(max, maxN);
        }
        return max;

    }

    public static void main(String... args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = maxSubArray(nums);
        System.out.println(max);
    }
}
