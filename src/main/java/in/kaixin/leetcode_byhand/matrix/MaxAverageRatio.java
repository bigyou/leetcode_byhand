package in.kaixin.leetcode_byhand.matrix;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaxAverageRatio {
    //    https://leetcode.cn/problems/maximum-average-pass-ratio/?envType=daily-question&envId=2025-09-01
//    mid
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Info> queue = new PriorityQueue<>((a, b) -> {
            if (a.delta == b.delta) {
                return 0;
            } else {
                return a.delta > b.delta ? -1 : 1;
            }
        });
        for (int i = 0; i < classes.length; i++) {
            int total = classes[i][1];
            int pass = classes[i][0];
            double delta = getdelta(pass, total);
            Info info = new Info();
            info.total = total;
            info.pass = pass;
            info.idx = i;
            info.delta = delta;
            queue.offer(info);
        }

        for (int i = 0; i < extraStudents; i++) {
            Info v = queue.poll();
            v.total = ++v.total;
            v.pass = ++v.pass;
            v.delta = getdelta(v.pass, v.total);
            queue.offer(v);
        }
        double v = 0;
        while (queue.size() > 0) {
            Info i = queue.poll();
            v += 1.0 * i.pass / i.total;

        }
        double res = v / classes.length;
        return res;
    }

    public double getdelta(int pass, int total) {
        double v = 1.0 * (1.0*total - pass) / (1.0*total * (total + 1));
        return v;
    }

    class Info {
        int pass;
        int total;
        double delta;
        int idx;
    }

    public static void main(String[] args) {
        int[][] a;
        double v = 0;
        MaxAverageRatio m = new MaxAverageRatio();
//        a = {{1, 2}, {3, 5}, {2, 2}}；
//        v = m.maxAverageRatio(a, 2);
//        System.out.println(v);

        a = new int[][]{{13609, 17094}, {24079, 89827}};
        v = m.maxAverageRatio(a, 22159);
        System.out.println(v);

    }
}

