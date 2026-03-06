//package in.kaixin.leetcode_byhand.other;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class LongestBalanced {
//    static int maxLen = 0;
//
//    //    https://leetcode.cn/problems/longest-balanced-subarray-ii/?envType=daily-question&envId=2026-02-11
//    public int longestBalanced(int[] nums) {
//        Map<Integer, Integer> mapone = new HashMap<>();
//        Map<Integer, Integer> mapzero = new HashMap<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            int v = nums[i];
//            if (v % 2 == 1) {
//                mapone.put(v, mapone.getOrDefault(v, 0) + 1);
//            } else {
//                mapzero.put(v, mapone.getOrDefault(v, 0) + 1);
//            }
//        }
//
//
//    }
//
//    public void doAction(Map<Integer, Integer> mapone, Map<Integer, Integer> mapzero, int left, int right) {
//        if (mapone.size() > 0 && mapone.size() == mapzero.size()) {
//            maxLen = Math.max(maxLen, right - left + 1);
//            return;
//        }
//        Map<Integer, Integer> mapLeft=new HashMap<>();
//        Map<Integer, Integer> mapright=new HashMap<>();
//        while (mapone.size() != mapzero.size()) {
//
//
//        }
//
//    }
//    public void removeLeft(){
//
//    }
//    public void removeRight(){
//
//    }
//}
