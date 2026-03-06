package in.kaixin.leetcode_byhand.numbers;

import java.util.HashSet;
import java.util.Set;

public class MinimumOperations {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int v = nums[i];
            if (set.contains(v)) {
                return (int) Math.ceil((i + 1) / 3.0);
            } else {
                set.add(v);
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        MinimumOperations m = new MinimumOperations();
        System.out.println(m.minimumOperations(new int[]{4, 5, 6, 4, 4}));
    }
}
