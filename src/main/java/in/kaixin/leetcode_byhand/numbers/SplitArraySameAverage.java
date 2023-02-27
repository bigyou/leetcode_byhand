//package in.kaixin.leetcode_byhand.numbers;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class SplitArraySameAverage {
//    //    https://leetcode.cn/problems/split-array-with-same-average/
//    public boolean splitArraySameAverage(int[] nums) {
//        List<Integer> numsArr = new ArrayList<>(nums.length);
//        long sum = sum(nums, numsArr);
//
//
//    }
//
//    public long sum(int[] nums, List<Integer> numsArr) {
//        long sum = 0l;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//            numsArr.set(i, nums[i]);
//        }
//        return sum;
//    }
//
//    public boolean try2Split(List<Integer> nums, int sum,int total,int cnt, int index, int expectv) {
//        for (int i = index; i < nums.size(); i++) {
//            if (nums.get(i) == null) {
//                break;
//            }
//            int v = nums.get(i);
//            sum+=v;
//            if((total-sum)/(nums.size()-cnt-1)==(sum/(cnt+1))){
//                return true;
//            }
//            nums.set(i, null);
//            try2Split(nums, cnt + 1, index + 1, expectv - nums.get(i));
//            nums.set(i, v);
//        }
//
//    }
//}
//
