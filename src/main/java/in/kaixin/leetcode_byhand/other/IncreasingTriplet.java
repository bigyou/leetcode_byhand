package in.kaixin.leetcode_byhand.other;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IncreasingTriplet {
    //    https://leetcode-cn.com/problems/increasing-triplet-subsequence/}
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int[] inc = new int[nums.length];
        Map<Integer, List<Integer>> note =new HashMap<>();
        boolean find = doIncreasing(nums, inc, nums.length - 1, false,note);
        return find;
    }

    public boolean doIncreasing(int[] nums, int[] inc, int i, boolean find, Map<Integer, List<Integer>> note ) {
        if (find) {
            return true;
        }
        if (i == 0) {
            inc[0] = 1;
            return false;
        }
        find = doIncreasing(nums, inc, i - 1, false,note);
        if (find) {
            return find;
        }
        inc[i] = 1;
        for (int j = i - 1; j >= 0; j--) {
            if (nums[j] < nums[i]) {
                inc[i] = Math.max(inc[j] + 1, inc[i]);
            }
        }
        if (inc[i] >= 3) {
            return true;
        }
        return find;
    }

    public static void main(String[] args) {
        IncreasingTriplet increasingTriplet = new IncreasingTriplet();
        System.out.println(increasingTriplet.increasingTriplet(new int[]{20, 100, 10, 12, 5, 13}));

    }
}
