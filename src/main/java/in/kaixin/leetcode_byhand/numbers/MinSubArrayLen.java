package in.kaixin.leetcode_byhand.numbers;

public class MinSubArrayLen {
    //    https://leetcode-cn.com/problems/minimum-size-subarray-sum/
    //

    public int minSubArrayLen(int target, int[] nums) {//时间窗口的解法
        int min = Integer.MAX_VALUE;
        int cnt = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length && min != 1) {//如果发现最小值已经是1 了，可以退出
            cnt += nums[right];
            while (left <= right && cnt >= target) {
                min = Math.min(min, right - left + 1);
                cnt -= nums[left];
                left++;
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int minSubArrayLen1(int target, int[] nums) {
        long[] sum = new long[nums.length];
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            cnt = cnt + nums[i];
            sum[i] = cnt;
        }
        if (sum[nums.length - 1] < target) {
            return 0;
        }
        int i = 0;
        while (sum[i] < target) {
            i++;
        }
        int min = i + 1;
        for (int j = min - 1; j < nums.length; j++) {
            for (int k = 1; k < min && min > 0; k++) {
                if (sum[j] - sum[j - k] >= target) {
                    min = k;
                    break;
                }
            }
        }
        return min;
    }


    public static void main(String[] args) {
        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
        System.out.println(minSubArrayLen.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen.minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(minSubArrayLen.minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
        System.out.println(minSubArrayLen.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));

    }
}
