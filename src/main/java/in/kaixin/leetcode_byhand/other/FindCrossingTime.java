//package in.kaixin.leetcode_byhand.other;
//
//import java.util.Comparator;
//import java.util.PriorityQueue;
//import java.util.SortedSet;
//
///**
// * @Author bigyou
// * @Create 2023/7/7 22:42
// */
//public class FindCrossingTime { // TODO unsolved
//    //    https://leetcode.cn/problems/time-to-cross-a-bridge/
//    //    hard
//    public int findCrossingTime(int n, int k, int[][] time) {
//        PriorityQueue<Worker> rightWaitworkers = new PriorityQueue<>(new Comparator<Worker>() {
//            @Override
//            public int compare(Worker o1, Worker o2) {
//                int diff = o1.left2right + o1.right2left - o2.left2right - o2.right2left;
//                if (diff > 0) {
//                    return -1;
//                } else if (diff < 0) {
//                    return 1;
//                } else {
//                    if (o1.idx > o2.idx) {
//                        return -1;
//                    } else {
//                        return 1;
//                    }
//                }
//            }
//        });
//        PriorityQueue<Worker> leftworkers = new PriorityQueue<>(new Comparator<Worker>() {
//            @Override
//            public int compare(Worker o1, Worker o2) {
//                int diff = o1.left2right + o1.right2left - o2.left2right - o2.right2left;
//                if (diff > 0) {
//                    return -1;
//                } else if (diff < 0) {
//                    return 1;
//                } else {
//                    if (o1.idx > o2.idx) {
//                        return -1;
//                    } else {
//                        return 1;
//                    }
//                }
//            }
//        });
//        while (n > 0) {
//
//
//        }
//        return null;
//
//
//    }
//}
//
//class Worker {
//    int idx;
//    int left2right = 0;
//    int right2left = 0;
//    int pickold = 0;
//    int putnew = 0;
//    int cost;
//
//    public Worker(int idx, int left2right, int pickold, int right2left, int putnew) {
//        this.idx = idx;
//        this.left2right = left2right;
//        this.pickold = pickold;
//        this.right2left = right2left;
//        this.putnew = putnew;
//    }
//}
