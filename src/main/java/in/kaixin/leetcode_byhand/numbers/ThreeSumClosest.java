package in.kaixin.leetcode_byhand.numbers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author bigyou
 * @Create 2023/7/10 19:05
 */
public class ThreeSumClosest {
    //    https://leetcode.cn/problems/3sum-closest/
    public int threeSumClosest(int[] nums, int target) {
        nums = Arrays.stream(nums).sorted().toArray();
        long v = doAction(nums, target);
        return (int) v;
    }

    public long doAction(int[] nums, int target) {
        long minDiff = Long.MAX_VALUE;
        Long mostNearV = null;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    long v = nums[i] + nums[j] + nums[k];
                    long diff = target - v;
                    diff = diff > 0 ? diff : -diff;
                    if (diff < minDiff) {
                        minDiff = diff;
                        mostNearV = v;
                    }
                    if (v < target) {

                    } else if (v > target) {
                        break;
                    } else {
                        return target;
                    }
                }
            }
        }
        return mostNearV;
    }

    public static void main(String... args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int[] nums = new int[]{-1, 2, 1, -4};
        int closest = threeSumClosest.threeSumClosest(nums, 1);
        System.out.println(closest);
    }


}
