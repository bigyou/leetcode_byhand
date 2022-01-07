package in.kaixin.leetcode_byhand;

public class LogestSubUpString {
    //    https://leetcode-cn.com/problems/longest-increasing-subsequence/
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int[] res = new int[nums.length];
        res[0] = 1;
        int maxlength = 1;
        for (int i = 1; i < nums.length; i++) {
            int subMax = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    subMax = Math.max(subMax, res[j] + 1);
                }
            }
            res[i] = subMax;
            maxlength = Math.max(maxlength, subMax);
        }
        return maxlength;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int res = lengthOfLIS(nums);
        System.out.println(res);
    }


}
