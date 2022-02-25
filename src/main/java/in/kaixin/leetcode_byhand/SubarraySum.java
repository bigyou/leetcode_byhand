package in.kaixin.leetcode_byhand;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    //    https://leetcode-cn.com/problems/subarray-sum-equals-k/
//    public int subarraySum(int[] nums, int k) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        int times = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int v = 0;
//            for (int j = i; j < nums.length; j++) {
//                v += nums[j];
//                if (v == k) {
//                    times++;
//                }
//            }
//        }
//        return times;
//
//    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);
        int v = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            v = v + nums[i];
            res += sumMap.getOrDefault(v - k, 0);
            sumMap.put(v, sumMap.getOrDefault(v, 0) + 1);

        }
        return res;
    }

    public static void main(String[] args) {
        SubarraySum subarraySum = new SubarraySum();
        System.out.println(subarraySum.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum.subarraySum(new int[]{1, 2, 3}, 3));
        System.out.println(subarraySum.subarraySum(new int[]{1, 2, 1, 2, 1}, 3));
    }
}
