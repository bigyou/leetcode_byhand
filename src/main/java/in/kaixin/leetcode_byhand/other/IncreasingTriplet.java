package in.kaixin.leetcode_byhand.other;

public class IncreasingTriplet {
    //    https://leetcode-cn.com/problems/increasing-triplet-subsequence/}
//    mid
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int[] maxright = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                maxright[i] = nums[i];
            } else {
                maxright[i] = maxright[i + 1] > nums[i] ? maxright[i + 1] : nums[i];
            }
        }

        int[] minLeft = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                minLeft[i] = nums[i];
            } else {
                minLeft[i] = minLeft[i - 1] < nums[i] ? minLeft[i - 1] : nums[i];
            }
        }


        for (int i = 1; i < nums.length - 1; i++) {
            if (minLeft[i] < nums[i] && nums[i] < maxright[i]) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        IncreasingTriplet increasingTriplet = new IncreasingTriplet();
//        System.out.println(increasingTriplet.increasingTriplet(new int[]{20, 100, 10, 12, 5, 13}));
        System.out.println(increasingTriplet.increasingTriplet(new int[]{1, 5, 0, 4, 1, 3}));

    }
}
