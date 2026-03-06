//package in.kaixin.leetcode_byhand.other;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class MinimumCostString {
//    //    https://leetcode.cn/problems/minimum-cost-to-convert-string-i/description/?envType=daily-question&envId=2026-01-29
////    mid
//    //todo
//    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
//
//        Map<Character, Map<Character, Integer>> map = new HashMap<>();
//        for (int i = 0; i < original.length; i++) {
//            char orin = original[i];
//            char chang = changed[i];
//            int changecost = cost[i];
//            Map<Character, Integer> m = map.get(orin);
//            if (m == null) {
//                m = new HashMap<>();
//            }
//            if (m.get(chang) == null || m.get(chang) > changecost) {
//                m.put(chang, changecost);
//            }
//        }
//
//    }
//}
