package in.kaixin.leetcode_byhand.numbers;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author bigyou
 * @Create 2023/7/13 19:17
 */
public class MaxAlternatingSum {
    //    https://leetcode.cn/problems/maximum-alternating-subsequence-sum/description/
//    mid
    public long maxAlternatingSum(int[] nums) {
//        if (nums.length == 1) {
//            return nums[0];
//        }
        int forward = 1;
        Long res = 0l;
        Integer v = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (forward == 1) {
                if (v > nums[i]) {
                    res += forward * v;
                    forward = -1;
                }
                v = nums[i];
            } else {
                if (v < nums[i]) {
                    res += forward * v;
                    forward = 1;

                }
                v = nums[i];
            }
        }
        if (forward == 1) {
            res += v;
        }
        return res;
    }

    public static void main(String[] args) {
        MaxAlternatingSum m = new MaxAlternatingSum();
        long out = m.maxAlternatingSum(new int[]{4, 2, 5, 3});
        System.out.println(out);
        out = m.maxAlternatingSum(new int[]{5, 6, 7, 8});
        System.out.println(out);
        out = m.maxAlternatingSum(new int[]{6, 2, 1, 2, 4, 5});
        System.out.println(out); out = m.maxAlternatingSum(new int[]{6});
        System.out.println(out);
    }

}
