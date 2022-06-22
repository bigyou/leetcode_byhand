//package in.kaixin.leetcode_byhand.other;
//
//import java.util.HashSet;
//import java.util.Set;
//
//public class OpenLock {
//    int min = Integer.MAX_VALUE;
//
//    public int openLock(String[] deadends, String target) {
//        Set<String> deadSet = new HashSet<>();
//
//        for (String deadend : deadends) {
//            deadSet.add(deadend);
//        }
//        int a[] = new int[4];
//        for (int i = 0; i < 9; i++) {
//            doOpenLock(deadSet, a, 1, 0, target, 0);
//        }
//
//        if (min == Integer.MAX_VALUE) {
//            return -1;
//        }
//        return min;
//
//    }
//
//    public int getv(int a[], int index) {
//        if (a[index] < 0) {
//            return a[index] + 10;
//        }
//        return a[index];
//    }
//
//    public void doOpenLock(Set<String> deadends, int a[], int fangxiang, int po, String target, int n) {
//        if (po > 3) {
//            return;
//        }
//        for (int i : a) {
//            if (i > 9 || i < -9) {
//                return;
//            }
//        }
//        String s = "" + getv(a, 0) + getv(a, 1) + getv(a, 2) + getv(a, 3);
//        if (deadends.contains(s)) {
//            return;
//        }
//        if (s.equals(target)) {
//            min = Math.min(min, n);
//            return;
//        }
//        for (int i = po; i < 4; i++) {
//            if (a[i] > 0) {
//                a[i] = a[i] + 1;
//                doOpenLock(deadends, a, fangxiang, i, target, n + 1);
//            } else if (a[i] < 0) {
//                a[i] = a[i] - 1;
//                doOpenLock(deadends, a, fangxiang, i, target, n + 1);
//            } else {
//                a[i] = 1;
//                doOpenLock(deadends, a, fangxiang, i, target, n + 1);
//                a[i] = -1;
//                doOpenLock(deadends, a, fangxiang, i, target, n + 1);
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        OpenLock openLock = new OpenLock();
//        System.out.println(openLock.openLock(new String[]{"8888"}, "0009"));
//    }
//
//}
