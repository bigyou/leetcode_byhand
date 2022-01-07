package in.kaixin.leetcode_byhand.other;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
    //    https://leetcode-cn.com/problems/permutations/
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        dopermute(nums, new int[nums.length], 0, new LinkedList<>());
        return res;

    }

    public void dopermute(int[] nums, int[] use, int dep, List<Integer> values) {
        for (int i = 0; i < nums.length; i++) {
            if (use[i] == 1) {
                continue;
            }
            values.add(nums[i]);
            use[i] = 1;
            if (dep + 1 == nums.length) {
                List<Integer> list = values.stream().collect(Collectors.toList());
                res.add(list);
            }
            dopermute(nums, use, dep + 1, values);
            use[i] = 0;
            values.remove(values.size() - 1);
        }

    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        permutations.permute(new int[]{1, 2, 3});
    }
}
