package in.kaixin.leetcode_byhand.numbers;

/**
 * @Author bigyou
 * @Create 2023/7/20 21:34
 */
public class MaxProduct {
    //    https://leetcode.cn/problems/maximum-product-subarray/description/
//    mid todo
    public int maxProduct(int[] nums) {
        long[] positiveMaxv = new long[nums.length];
        long[] negetiveMinv = new long[nums.length];
        positiveMaxv[0] = 1;
        negetiveMinv[0] = 1;
        if (nums[0] > 0) {
            positiveMaxv[0] = nums[0];
        } else if (nums[0] < 0) {
            negetiveMinv[0] = nums[0];
        }
        long res = Long.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int v = nums[i];
            long max = v;
            max = Math.max(max, positiveMaxv[i - 1] * v);
            max = Math.max(max, negetiveMinv[i - 1] * v);
            long min = 1;
            min = Math.min(min, negetiveMinv[i - 1] * v);
            min = Math.max(min, negetiveMinv[i - 1] * v);
            if (v == 0) {
                positiveMaxv[i] = 1;
                negetiveMinv[i] = 1;
            } else {
                negetiveMinv[i] = min;
                positiveMaxv[i] = max;
            }
            res = Math.max(max, res);


        }
        return (int) res;

    }

}
