package in.kaixin.leetcode_byhand.numbers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author bigyou
 * @Create 2023/7/15 11:51
 */
public class FourSum {
    //    https://leetcode.cn/problems/4sum/description/
//    mid
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();

        nums = Arrays.stream(nums).sorted().toArray();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (4 * (long) nums[i] > target) {
                break;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j - i > 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((long) nums[i] + 3 * (long) nums[j] > target) {
                    break;
                }
                for (int k = j + 1; k < nums.length - 1; k++) {
                    if (k - j > 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    if ((long) nums[i] + (long) nums[j] + 2 * (long) nums[k] > target) {
                        break;
                    }
                    for (int h = k + 1; h < nums.length; h++) {
                        if (h - k > 1 && nums[h] == nums[h - 1]) {
                            continue;
                        }
                        if ((long) nums[i] + (long) nums[j] + (long) nums[k] + (long) nums[h] == target) {
                            List<Integer> list = new LinkedList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(nums[h]);
                            res.add(list);
                        }

                    }

                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        List<List<Integer>> lists = fourSum.fourSum(new int[]{0, 0, 0, -1000000000, -1000000000, -1000000000, -1000000000}, -1000000000);
        System.out.println(lists);
    }
}
