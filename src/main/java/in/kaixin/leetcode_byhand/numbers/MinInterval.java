package in.kaixin.leetcode_byhand.numbers;

import java.util.*;

/**
 * @Author bigyou
 * @Create 2023/7/18 20:05
 */
public class MinInterval {
//    https://leetcode.cn/problems/minimum-interval-to-include-each-query/description/
//    hard
    public int[] minInterval(int[][] intervals, int[] queries) {
        PriorityQueue<Info> queue = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if (o1.distance > o2.distance) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        Arrays.sort(intervals, (a1, a2) -> {
            if (a1[0] > a2[0]) {
                return 1;
            } else if (a1[0] == a2[0]) {
                return 0;
            } else {
                return -1;
            }
        });
        int[] sortedqueries = Arrays.copyOf(queries, queries.length);
        Arrays.sort(sortedqueries);
        Map<Integer, Integer> distanceMap = new HashMap<>();
        int cursor = 0;

        for (int i = 0; i < sortedqueries.length; i++) {
            int q = sortedqueries[i];
            while (cursor < intervals.length) {
                int start = intervals[cursor][0];
                int end = intervals[cursor][1];
                if (start <= q && q <= end) {
                    queue.add(new Info(start, end));
                    cursor++;
                }
                if (end < q) {
                    cursor++;
                }
                if (start > q) {
                    break;
                }
            }
            int distance = -1;
            while (queue.peek() != null) {
                Info peek = queue.peek();
                if (peek.end < q || peek.start > q) {
                    queue.poll();
                } else {
                    distance = peek.distance;
                    break;
                }
            }
            distanceMap.put(q, distance);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = distanceMap.get(queries[i]);

        }
        return res;

    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{54, 82}, {55, 66}, {81, 89}, {38, 67}, {81, 86}, {47, 47}, {13, 61}, {33, 39}, {61, 66}, {97, 97}, {52, 68}, {96, 98}, {89, 92}, {1, 41}, {81, 89}, {9, 57}, {81, 90}, {41, 73}, {29, 80}, {98, 98}, {61, 95}, {93, 98}, {5, 65}, {91, 96}, {91, 99}, {28, 68}, {55, 71}, {35, 45}, {1, 89}, {48, 48}, {26, 36}, {5, 83}, {20, 83}, {73, 92}, {69, 69}, {77, 89}, {12, 52}, {5, 53}, {33, 53}, {70, 83}, {81, 98}, {69, 69}, {28, 90}, {9, 77}, {40, 53}, {53, 71}, {7, 55}, {7, 28}, {5, 88}, {61, 68}, {25, 93}, {45, 73}, {13, 51}, {27, 70}, {47, 87}, {71, 91}, {93, 98}, {1, 35}, {24, 39}, {86, 90}, {19, 33}, {1, 69}, {21, 100}, {85, 85}, {99, 99}, {25, 25}, {90, 94}, {13, 61}, {69, 85}, {89, 97}, {1, 43}, {11, 35}, {41, 95}, {31, 99}, {86, 94}, {33, 63}, {22, 91}, {61, 75}, {71, 83}, {31, 85}, {28, 83}, {1, 21}, {81, 97}, {5, 29}, {74, 83}, {33, 83}, {13, 24}, {92, 94}, {71, 71}, {59, 79}, {21, 37}, {33, 87}, {97, 97}, {34, 57}, {11, 59}, {57, 62}, {22, 23}, {13, 53}, {84, 85}, {71, 80}};
        int[] query = new int[]{31, 9, 21, 91, 91, 58, 13, 76, 21, 69, 41, 1, 73, 2, 71, 51, 69, 89, 31, 85, 61, 61, 39, 76, 36, 50, 1, 33, 41, 38, 29, 91, 93, 47, 1, 11, 33, 79, 15, 7, 21, 36, 65, 1, 1, 93, 45, 51, 33, 5, 15, 65, 49, 81, 59, 21, 1, 7, 81, 6, 1, 80, 81, 21, 24, 41, 47, 85, 38, 26, 100, 33, 57, 24, 71, 16, 65, 96, 81, 83, 17, 75, 76, 21, 85, 47, 77, 49, 31, 61, 9, 49, 1, 73, 32, 66, 96, 97, 30, 21};
        MinInterval mi = new MinInterval();
        int[] res = mi.minInterval(a, query);

        System.out.println(res);
    }
}

class Info {
    public Info(int start, int end) {
        this.start = start;
        this.end = end;
        this.distance = this.end - this.start + 1;
    }

    int start;
    int end;
    int distance;

}
