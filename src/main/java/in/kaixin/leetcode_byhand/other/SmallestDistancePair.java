//package in.kaixin.leetcode_byhand.other;
//
//import java.util.Arrays;
//
//public class SmallestDistancePair {
//https://leetcode.cn/problems/find-k-th-smallest-pair-distance/
//    public int smallestDistancePair(int[] nums, int k) {
//        Arrays.sort(nums);
//        Info[] valueArr = new Info[nums.length - 1];
//        for (int i = 0; i < nums.length - 1; i++) {
//
//            for(int j=i+1;i<nums.length;j++){
//                int v = nums[j] - nums[i];
//                if(v==0){
//                    j++;
//                }
//            }
//
//        }
//
//
//    }
//
//}
//
//class Info {
//
//    int start;
//    int current;
//    int v;
//
//    Info(int start, int current, int v) {
//        this.start = start;
//        this.current = current;
//        this.v = v;
//    }
//}
