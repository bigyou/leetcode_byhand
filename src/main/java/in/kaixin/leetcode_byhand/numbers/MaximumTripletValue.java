//package in.kaixin.leetcode_byhand.numbers;
//
//import java.util.Stack;
//
//public class MaximumTripletValue {
//    public long maximumTripletValue(int[] nums) {
//        int[] subMax = new int[nums.length];
//        int[] rightMax = new int[nums.length];
//        long res = 0l;
//        Stack<Integer> maxStack = new Stack<>();
//        long max = 0;
//        for (int i = 1; i < nums.length - 1; i++) {
//            int v = nums[i];
//            while (!maxStack.isEmpty()) {
//
//            }
//
//        }
//
//
//        rightMax[nums.length - 1] = nums[nums.length - 1];
//        for (int i = nums.length - 2; i > 1; i--) {
//            rightMax[i] = Math.max(nums[i], rightMax[i + 1]);
//        }
//
//        for (int i = 1; i < nums.length - 1; i++) {
//            res = Math.max(res, subMax[i] * rightMax[i]);
//        }
//        return res;
//
//    }
//
//    public static void main(String[] args) {
//        MaximumTripletValue m = new MaximumTripletValue();
//        long res = m.maximumTripletValue(new int[]{1, 10, 3, 4, 19});
//        System.out.println(res);
//    }
//}
