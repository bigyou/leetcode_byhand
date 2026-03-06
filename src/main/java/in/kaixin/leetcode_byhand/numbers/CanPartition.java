//package in.kaixin.leetcode_byhand.numbers;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Stack;
//
//public class CanPartition {
//    public boolean canPartition(int[] nums) {
//        long sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//        }
//        if (sum % 2 == 1) {
//            return false;
//        }
//        Arrays.sort(nums);
//
//        boolean suc = doPart(nums, new Stack<Integer>(), sum / 2, 0);
//        return suc;
//
//
//    }
//
//    public boolean doPart(int[] nums, Stack<Integer> idxArr, long expectV, int idx) {
//
//
//    }
//}
