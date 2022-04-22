package in.kaixin.leetcode_byhand.other;

public class MaxRotateFunction {
    // 这种做法超时
    public int maxRotateFunction1(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int v = 0;
            for (int j = 0; j < nums.length; j++) {
                int idx = (j - i + nums.length) % nums.length;
                v += nums[idx] * j;
            }
            max = Math.max(max, v);
        }
        return max;
    }


    public int maxRotateFunction(int[] nums) {
        int v = 0;
        int sum = 0;
        int maxv = 0;
        for (int i = 0; i < nums.length; i++) {
            v += i * nums[i];
            sum += nums[i];
        }
        maxv = v;
        for (int i = 0; i < nums.length - 1; i++) {
            v = v + sum - nums.length * nums[nums.length - 1 - i];
            maxv= Math.max(v,maxv);
        }
        return maxv;
    }
}