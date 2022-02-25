package in.kaixin.leetcode_byhand;

import java.util.LinkedList;
import java.util.List;

public class SubarraySum {
    //    https://leetcode-cn.com/problems/subarray-sum-equals-k/
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        List<Integer> list = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            List<Integer> newList = new LinkedList<>();
            for (Integer integer : list) {
                int v = integer + nums[i];
                if (v == k) {
                    res++;
                }
                newList.add(v);
            }
            newList.add(nums[i]);
            if (nums[i] == k) {
                res++;
            }
            list = newList;
        }
        return res;
    }

    public static void main(String[] args) {
        SubarraySum subarraySum = new SubarraySum();
        System.out.println(subarraySum.subarraySum(new int[]{1, 2, 3}, 3));
    }
}
