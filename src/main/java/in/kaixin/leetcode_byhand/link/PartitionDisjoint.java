package in.kaixin.leetcode_byhand.link;

public class PartitionDisjoint {
    //    https://leetcode.cn/problems/partition-array-into-disjoint-intervals/
    public int partitionDisjoint(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int[] rightMin = rightMin(nums);
        Integer index = null;
        int max = nums[0];
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (max<= rightMin[i + 1]) {
                index = i;
                break;
            }
        }

        return index + 1;
    }

//    public int[] leftMax(int[] nums) {
//        int[] leftMax = new int[nums.length];
//        int max = nums[0];
//
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] > max) {
//                max = nums[i];
//            }
//            leftMax[i] = max;
//        }
//        return leftMax;
//
//    }

    public int[] rightMin(int[] nums) {
        int[] rightMin = new int[nums.length];
        int min = nums[nums.length - 1];

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < min) {
                min = nums[i];
            }
            rightMin[i] = min;
        }
        return rightMin;
    }


}

