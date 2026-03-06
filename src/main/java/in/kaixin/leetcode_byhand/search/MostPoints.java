package in.kaixin.leetcode_byhand.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MostPoints {
    //    https://leetcode.cn/problems/solving-questions-with-brainpower/?envType=daily-question&envId=2025-04-01
//    mid
    public long mostPoints(int[][] questions) {
        int size = questions.length;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            int target = questions[i][1] + i + 1;
            if (target >= size) {
                continue;
            }
            ArrayList<Integer> arr = map.getOrDefault(target, new ArrayList<>());
            arr.add(i);
            map.put(target, arr);
        }
        long[] maxPoints = new long[size];
        long freeMax = 0;//游离的最大值。
        long max = freeMax;
        for (int i = 0; i < questions.length; i++) {
            ArrayList<Integer> sourceset = map.get(i);
            if (sourceset != null) {
                for (Integer idx : sourceset) {
                    freeMax = Math.max(maxPoints[idx], freeMax);
                }
            }
            long maxPoint = freeMax + questions[i][0];
            maxPoints[i] = maxPoint;
            max = Math.max(max, maxPoint);
        }
        return max;
    }

    public static void main(String[] args) {
        MostPoints mostPoints = new MostPoints();
        long res = mostPoints.mostPoints(new int[][]{{3, 2},{100,1}, {4, 3}, {4, 4}, {200, 5},{8,2},{9,4}});
        System.out.println(res);
    }
}
