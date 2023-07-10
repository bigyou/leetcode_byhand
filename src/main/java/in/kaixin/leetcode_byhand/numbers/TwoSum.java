package in.kaixin.leetcode_byhand.numbers;

import java.util.*;

/**
 * @Author bigyou
 * @Create 2023/7/5 20:50
 */
public class TwoSum {
    //    https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description/
//     mid
    public int[] twoSum(int[] numbers, int target) {
        int right = numbers.length - 1;
        int[] res = new int[2];
        int forward = 0;// 1向右，-1向左
        for (int i = 0; i < numbers.length - 1; i++) {
            right = right > numbers.length - 1 ? numbers.length - 1 : right;
            forward=0;
            while (right < numbers.length && right > i) {
                int v = numbers[i] + numbers[right];
                if (v == target) {
                    res[0] = i + 1;
                    res[1] = right + 1;
                    return res;
                } else if (v > target) {
                    if (forward == 1) {
                        break;
                    }
                    if (forward == 0) {
                        forward = -1;
                    }
                    right--;
                } else {
                    if (forward == -1) {
                        break;
                    }
                    if (forward == 0) {
                        forward = 1;
                    }
                    right++;

                }
            }
        }
        return res;
    }

    public static void main(String... args) {
        int[] nums =new int[]{-10,-8,-2,1,2,5,6};
        TwoSum t =new TwoSum();
        int[] ints = t.twoSum(nums, 0);
        System.out.println(ints);


    }
}
