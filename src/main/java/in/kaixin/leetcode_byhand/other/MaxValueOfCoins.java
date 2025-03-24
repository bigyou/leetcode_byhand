//package in.kaixin.leetcode_byhand.other;
//
//import java.util.LinkedList;
//import java.util.List;
//
//public class MaxValueOfCoins {
//    //    https://leetcode.cn/problems/maximum-value-of-k-coins-from-piles/?envType=daily-question&envId=2025-01-21
//    //    hard
//
//    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
//
//        int size = 0;
//        for (List<Integer> pile : piles) {
//            size += pile.size();
//        }
//        int max = maxValue(piles, k, size);
//        return max;
//    }
//
//    public int maxValue(List<List<Integer>> piples, int k, int leftSize) {
//        int max = 0;
//        if (leftSize < k) {
//            return -1;
//        }
//        if (k == 0) {
//            return 0;
//        }
//
//        for (int i = 0; i < piples.size(); i++) {
//            if (piples.get(i).size() == 0) {
//                continue;
//            }
//            int p = piples.get(i).remove(0);
//            if (k > leftSize) {
//                break;
//            }
//            int max1 = maxValue(piples, k - 1, leftSize - 1);
//            int max2 = maxValue(piples, k, leftSize);
////            piples.get(i).add(0, p);
//
//            if (max1 == -1 && max2 == -1) {
//                return -1;
//            } else {
//                max = Math.max(p + max1, max2);
//            }
//        }
//        return max;
//    }
//
//    public static void main(String[] args) {
//        MaxValueOfCoins c = new MaxValueOfCoins();
//        List<List<Integer>> list = new LinkedList<>();
//        List<Integer> la = new LinkedList<>();
//        la.add(1);
//        la.add(100);
//        la.add(3);
//        List<Integer> lb = new LinkedList<>();
//        lb.add(7);
//        lb.add(8);
//        lb.add(9);
//        list.add(la);
//        list.add(lb);
//
//        int max = c.maxValueOfCoins(list, 2);
//        System.out.println(max);
//        list.clear();
//        new LinkedList<>().add(100
//        list.add(new LinkedList<>().add(100));
//
//    }
//}
