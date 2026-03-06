package in.kaixin.leetcode_byhand.numbers;

import java.util.HashSet;
import java.util.Set;

public class MinOperations {
    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num < k) {
                return -1;
            }
            set.add(num);
        }
        return set.contains(k) ? set.size() - 1 : set.size();
    }
}
