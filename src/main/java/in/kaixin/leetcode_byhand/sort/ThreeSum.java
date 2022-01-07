package in.kaixin.leetcode_byhand.sort;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Set<Integer> numset = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numset.add(nums[i]);
        }
        Integer[] sortedNums = numset.toArray(new Integer[numset.size()]);
        Arrays.sort(sortedNums);

//        Set<String> answers = new HashSet<>();
        for (int i = 0; i < sortedNums.length - 2; i++) {
            if (sortedNums[i] > 0) {
                break;
            }
            for (int j = i + 1; j < sortedNums.length - 1; j++) {
                if (sortedNums[i] + sortedNums[j] > 0) {
                    break;
                }
                for (int k = j + 1; k < sortedNums.length; k++) {
                    int sum = sortedNums[i] + sortedNums[j] + sortedNums[k];
                    if (sum < 0) {
                        continue;
                    } else if (sum == 0) {
                        List<Integer> list = new LinkedList<>();
                        list.add(sortedNums[i]);
                        list.add(sortedNums[j]);
                        list.add(sortedNums[k]);

                        res.add(list);
                        continue;
                    } else {
                        break;
                    }
                }
            }
        }

        return res;
    }

    public static void main(String... args) {
        threeSum(new int[]{-1, 0, 1, 2, -1, -4});

    }

}
