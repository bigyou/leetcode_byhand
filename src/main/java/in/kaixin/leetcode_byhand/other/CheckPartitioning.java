//package in.kaixin.leetcode_byhand.other;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class CheckPartitioning {
//    //    https://leetcode.cn/problems/palindrome-partitioning-iv/?envType=daily-question&envId=2025-03-04
////    hard
//    public boolean checkPartitioning(String s) {
//        Map<Character, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            List<Integer> list = map.getOrDefault(c, new ArrayList<>());
//            map.put(c, list);
//            list.add(i);
//        }
//        if (map.keySet().size() == 1 && s.length() >= 3) {
//            return true;
//        }
//        List<Integer> first = map.get(s.charAt(0));
//        for (int i = 0; i < first.size(); i++) {
//            doCheckFirst()
//        }
//
//    }
//
//    public boolean doCheckFirst(String s, Map<Character, List<Integer>> map, Integer position) {
//        if (position >= s.length() - 2) {
//            return false;
//        }
//    }
//
//    public boolean doCheckSec(String s, Map<Character, List<Integer>> map, Integer position) {
//        if (position >= s.length() - 1) {
//            return false;
//        }
//    }
//
//    public boolean doCheckThird(String s, Map<Character, List<Integer>> map, Integer position) {
//        if (position >= s.length()) {
//            return false;
//        }
//
//    }
//}
