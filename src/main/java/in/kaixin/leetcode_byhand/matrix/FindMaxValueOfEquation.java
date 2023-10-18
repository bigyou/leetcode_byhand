package in.kaixin.leetcode_byhand.matrix;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author bigyou
 * @Create 2023/7/21 23:28
 */
public class FindMaxValueOfEquation {
    //    https://leetcode.cn/problems/max-value-of-equation/
//    hard
    public int findMaxValueOfEquation(int[][] points, int k) {
//        int left = 0;
//        int right = left + 1;
        long max = Long.MIN_VALUE;
        PriorityQueue<Info> priorityQueue = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if (o1.v > o2.v) {
                    return -1;
                } else if (o1.v == o2.v) {
                    if (o1.x > o2.x) {
                        return -1;
                    } else {
                        return 1;
                    }
                } else {
                    return 1;
                }
            }
        });
        for (int i = 0; i < points.length; i++) {
            int[] p = points[i];
            int px = p[0];
            int py = p[1];
            while (!priorityQueue.isEmpty()) {
                Info peek = priorityQueue.peek();
                if (px - peek.x > k) {
                    priorityQueue.poll();
                }else {
                    break;
                }
            }
            Info peek = priorityQueue.peek();
            if (peek != null) {
                max = Math.max(peek.v + px + py, max);
            }
            priorityQueue.add(new Info(px, py-px));
        }


//        while (left < points.length - 1) {
//            if (left >= right) {
//                right = left + 1;
//            }
//            if (right > points.length - 1) {
//                left++;
//                right = left + 1;
//                continue;
//            }
//            if (points[right][0] - points[left][0] <= k) {
//                max = Math.max(points[right][1] + points[left][1] + points[right][0] - points[left][0], max);
//                right++;
//            } else {
//                left++;
//                right = left + 1;
////                continue;
//
//            }
//        }
        return (int) max;

    }


    public static void main(String[] args) {
        FindMaxValueOfEquation f = new FindMaxValueOfEquation();
        int res = f.findMaxValueOfEquation(new int[][]{{1, 3}, {2, 0}, {5, 10}, {6, -10}}, 1);
        System.out.println(res);

    }
}

class Info {
    int x;
    int v;

    public Info(int x, int v) {
        this.x = x;
        this.v = v;
    }
}

