//package in.kaixin.leetcode_byhand.numbers;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class SumSubarrayMins {
//    //    https://leetcode.cn/problems/sum-of-subarray-minimums/
//    public int sumSubarrayMins(int[] arr) {
//        Map<Integer, List<Integer>> locationMap = convert2Map(arr);
//        List<Integer> keyList = locationMap.keySet().stream().collect(Collectors.toList());
//        Collections.sort(keyList);
//        int length = arr.length;
//
//
//    }
//
//    public int caculte(Map<Integer, List<Integer>> locationMap, List<Integer> keyList, int arrLen) {
//        int total = 0;
//        for (int i = 0; i < keyList.size(); i++) {
//            total += doCaculate(locationMap, keyList, i, arrLen);
//        }
//        return total;
//    }
//
//    public int doCaculate(Map<Integer, List<Integer>> locationMap, List<Integer> keyList, int index, int arrLen) {
//        if (index < keyList.size() - 1) {
//
//        }
//
//    }
//
//
//    public Map<Integer, List<Integer>> convert2Map(int[] arr) {
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < arr.length; i++) {
//            List<Integer> locations = map.get(arr[i]);
//            if (locations == null) {
//                locations = new LinkedList<>();
//            }
//            map.put(arr[i], locations);
//        }
//        return map;
//    }
//
//}
