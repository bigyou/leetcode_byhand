package in.kaixin.leetcode_byhand;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new LinkedList<>();
        }
        List<List<Integer>> lists = dopermuteUnique(nums, 0, nums.length - 1);
        return lists;
    }

    public List<List<Integer>> dopermuteUnique(int[] nums, int start, int end) {
        if (start == end) {
            List<List<Integer>> res = new LinkedList<>();
            LinkedList<Integer> v = new LinkedList<>();
            v.add(nums[start]);
            res.add(v);
            return res;
        }
        List<List<Integer>> lists = dopermuteUnique(nums, start + 1, end);
        List<List<Integer>> res = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for (List<Integer> list : lists) {
            for (int i = 0; i < list.size() + 1; i++) {
                List<Integer> copy = copy(list);
                copy.add(i, nums[start]);
                if (!contains(copy, set)) {
                    res.add(copy);
                }
            }
        }
        return res;

    }

    public boolean contains(List<Integer> list, Set<String> set) {
        StringBuffer sb = new StringBuffer();
        for (Integer integer : list) {
            sb.append(integer).append("_");
        }
        String str = sb.toString();
        if (set.contains(str)) {
            return true;
        } else {
            set.add(str);
            return false;
        }
    }

    public List<Integer> copy(List<Integer> list) {
        List<Integer> copy = new LinkedList<>();
        for (Integer integer : list) {
            copy.add(integer);
        }
        return copy;
    }

    public static void main(String[] args) {
        PermuteUnique permuteUnique = new PermuteUnique();
        List<List<Integer>> res = permuteUnique.permuteUnique(new int[]{1, 2, 3, 1});
        System.out.println(res.size());
    }


}
