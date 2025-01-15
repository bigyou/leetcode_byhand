package in.kaixin.leetcode_byhand.other;

public class WaysToSplitArray {
    //    https://leetcode.cn/problems/number-of-ways-to-split-array/?envType=daily-question&envId=2025-01-13
//mid
    public int waysToSplitArray(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        long cursorSum = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            cursorSum += nums[i];
            if (2 * cursorSum >= sum) {
                cnt++;
            }
        }
        return cnt;
    }
}
