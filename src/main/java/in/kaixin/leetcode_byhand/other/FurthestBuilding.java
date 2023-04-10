package in.kaixin.leetcode_byhand.other;

import com.sun.xml.internal.ws.api.message.Header;
import javafx.collections.transformation.SortedList;

import java.util.PriorityQueue;

public class FurthestBuilding {
    //    https://leetcode.cn/problems/furthest-building-you-can-reach/description/
//    int max = 0;
//
//    public int furthestBuilding(int[] heights, int bricks, int ladders) {
//        doFurth(heights, bricks, ladders, 0);
//        return max;
//
//    }
//
//    public void doFurth(int[] heights, int bricks, int leaders, int start) { 会超时
//        if (bricks < 0) {
//            max = Math.max(max, start - 1);
//            return;
//        }
//        if (leaders < 0) {
//            max = Math.max(max, start - 1);
//            return;
//        }
//        if (start == heights.length - 1) {
//            max = heights.length-1;
//            return;
//        }
//
//        for (int i = start; i < heights.length - 1; i++) {
//            if (heights[i] >= heights[i + 1]) {
//                if (i == heights.length - 2) {
//                    max = heights.length - 1;
//                }
//                continue;
//            }
//            doFurth(heights, bricks - (heights[i + 1] - heights[i]), leaders, i + 1);
//            doFurth(heights, bricks, leaders - 1, i + 1);
//            break;
//
//        }

//    }


    public int furthestBuilding(int[] heights, int bricks, int ladders) {//    贪心算法
        int size = 0;
        int leftbricks = bricks;
        int leftladders = ladders;
        int max = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(ladders, (a, b) -> (b - a));
        for (int i = 0; i < heights.length - 1; i++) {
            if (heights[i] >= heights[i + 1]) {
                continue;
            } else {
                int offset = heights[i + 1] - heights[i];
                queue.add(offset);
                leftbricks -= offset;
                while (leftbricks < 0 && leftladders > 0) {
                    Integer brickstoAdd = queue.poll();
                    if (brickstoAdd != null && brickstoAdd > 0) {
                        leftbricks += brickstoAdd;
                        leftladders--;
                    }
                }
                if (leftbricks < 0) {
                    max = i;
                    break;
                }
            }
        }
        if (leftbricks >= 0) {
            max = heights.length - 1;
        }
        return max;
    }


    public static void main(String[] args) {
        FurthestBuilding furthestBuilding = new FurthestBuilding();
//        System.out.println(furthestBuilding.furthestBuilding(new int[]{3, 19}, 87, 1));
//        System.out.println(furthestBuilding.furthestBuilding(new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1));
        System.out.println(furthestBuilding.furthestBuilding(new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2));
        System.out.println(furthestBuilding.furthestBuilding(new int[]{14, 3, 19, 3}, 17, 0));
    }

}
