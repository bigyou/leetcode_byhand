package in.kaixin.leetcode_byhand.search;

/**
 * @Author bigyou
 * @Create 2023/7/20 21:00
 */
public class MaxSubArray2 {
    //    https://leetcode.cn/problems/maximum-subarray/description/
//    mid
    public int maxSubArray(int[] nums) {
        long[] dp = new long[nums.length];
        dp[0] = nums[0];
        long max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return (int) max;
    }
}
