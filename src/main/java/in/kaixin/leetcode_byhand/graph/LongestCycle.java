package in.kaixin.leetcode_byhand.graph;

import java.util.*;

public class LongestCycle {
    //    https://leetcode.cn/problems/longest-cycle-in-a-graph/?envType=daily-question&envId=2025-03-29
//    hard
//    public int longestCycle(int[] edges) {
//    超时
//        Set<Integer> crossedNode = new HashSet<>();
//        Set<Integer> loopNode = new HashSet<>();
//        Map<Integer, Integer> positionMap = new HashMap<>();
//        int maxLoopSize = -1;
//        for (int i = 0; i < edges.length; i++) {
//            if (crossedNode.contains(edges[i]) || edges[i] == -1) {
//                continue;
//            }
//            if (maxLoopSize >= edges.length - crossedNode.size()) {
//                break;
//            }
//            int node = i;
//            int cnt = 0;
//            do {
//                if (loopNode.contains(node)) {
//                    maxLoopSize = Math.max(positionMap.size() - positionMap.get(node), maxLoopSize);
//                    break;
//                } else {
//                    positionMap.put(node, cnt++);
//                    crossedNode.add(node);
//                    loopNode.add(node);
//                    node = edges[node];
//                }
//            } while (edges[node] != -1);
//            positionMap = new HashMap<>();
//            loopNode = new HashSet<>();
//        }
//        return maxLoopSize;
//    }
    public int longestCycle(int[] edges) {
//        Set<Integer> loopNode = new HashSet<>();
//        Map<Integer, Integer> positionMap = new HashMap<>();
        int maxLoopSize = -1;
        int cnt = -2;
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] < 0) {
                continue;
            }
            int node = i;
            int startIdx = cnt;
            do {
                if (edges[node] < 0 && edges[node] > startIdx) {
                    break;
                }
                if (edges[node] < -1) {
                    maxLoopSize = Math.max(edges[node] - cnt, maxLoopSize);
                    break;
                } else {
                    int n = node;
                    node = edges[node];
                    edges[n] = cnt--;
                }
            } while (true);
        }
        return maxLoopSize;
    }


    public static void main(String[] args) {
        LongestCycle longestCycle = new LongestCycle();
//        int res = longestCycle.longestCycle(new int[]{3, 3, 4, 2, 3});
        int res = longestCycle.longestCycle(new int[]{2, -1, 3, 1});
//        int res = longestCycle.longestCycle(new int[]{-1, 4, -1, 2, 0, 4});
        System.out.println(res);
    }


}
