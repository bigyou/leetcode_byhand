package in.kaixin.leetcode_byhand.other;

import java.util.*;

public class MaximizeSquareArea {
//    https://leetcode.cn/problems/maximum-square-area-by-removing-fences-from-a-field/?envType=daily-question&envId=2026-01-16
//    mid

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Integer[] hdistance = getDistances(hFences, m);
        Integer[] vdistance = getDistances(vFences, n);
        int i = hdistance.length - 1;
        int j = vdistance.length - 1;
        for (; i >= 0;) {
            for (; j >= 0;) {
                int h = hdistance[i];
                int v = vdistance[j];
                if (h > v) {
                    i--;
                    break;
                } else if (h < v) {
                    j--;
                } else {
                    int area = (v * v) % (1000000000 + 7);
                    return area;
                }

            }
        }

        return -1;

    }

    public Integer[] getDistances(int[] arr, int width) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        for (int i : arr) {
            list.add(i);
        }
        list.sort((a, b) -> (a - b));
        Set<Integer> distanceSet = new HashSet<>();
        distanceSet.add(width-1);
        for (int i = 0; i < list.size() - 1; i++) {
            int v = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                int v2 = list.get(j);
                distanceSet.add(v2 - v);
                distanceSet.add(width - v2);
            }
        }
        Integer[] l = distanceSet.toArray(new Integer[0]);
        Arrays.sort(l);
        return l;
    }

    public static void main(String[] args) {
        MaximizeSquareArea are = new MaximizeSquareArea();
        int res = are.maximizeSquareArea(4, 3, new int[]{2, 3}, new int[]{2});
        System.out.println(res);
    }
}
