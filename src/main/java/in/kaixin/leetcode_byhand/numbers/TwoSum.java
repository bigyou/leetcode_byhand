package in.kaixin.leetcode_byhand.numbers;

import java.util.*;

/**
 * @Author bigyou
 * @Create 2023/7/5 20:50
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] numInOrder = Arrays.stream(nums).sorted().toArray();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> positionList = map.get(nums[i]);
            if (positionList == null) {
                positionList = new LinkedList<>();
                map.put(nums[i], positionList);
            }
            positionList.add(i);
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = numInOrder[left] + numInOrder[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                return new int[]{map.get(numInOrder[left]).remove(0), map.get(numInOrder[right]).remove(0)};
            }
        }
        return null;
    }
}
