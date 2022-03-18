package in.kaixin.leetcode_byhand.other;

import java.util.HashMap;
import java.util.Map;

public class Rob {
    //    https://leetcode-cn.com/problems/house-robber/
    public int rob(int[] nums) {
        int sum = doRob(nums, 0, new HashMap<>());
        return sum;
    }

    public int doRob(int[] nums, int index, Map<Integer, Integer> noteMap) {
        if (index > nums.length - 1) {
            return 0;
        }
        if (noteMap.get(index) != null) {
            return noteMap.get(index);
        }
        int max = Math.max(getv(nums, index) + doRob(nums, index + 2, noteMap), getv(nums, index + 1) + doRob(nums, index + 3, noteMap));
        noteMap.put(index, max);
        return max;
    }

    public int getv(int[] nums, int index) {
        return index > nums.length - 1 ? 0 : nums[index];
    }

    public static void main(String[] args) {
        Rob rob = new Rob();
        System.out.println(rob.rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(rob.rob(new int[]{1,2,3,1}));

    }
}
