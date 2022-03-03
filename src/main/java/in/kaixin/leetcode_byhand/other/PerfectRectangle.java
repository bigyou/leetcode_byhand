package in.kaixin.leetcode_byhand.other;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PerfectRectangle {
    public boolean isRectangleCover2(int[][] rectangles) {//超出内存限制
        Integer minx = Integer.MAX_VALUE;
        Integer minY = Integer.MAX_VALUE;
        Integer maxx = Integer.MIN_VALUE;
        Integer maxY = Integer.MIN_VALUE;
        Integer totalArea = 0;
        for (int i = 0; i < rectangles.length; i++) {
            minx = Math.min(Math.min(rectangles[i][0], rectangles[i][2]), minx);
            minY = Math.min(Math.min(rectangles[i][1], rectangles[i][3]), minY);
            maxx = Math.max(Math.max(rectangles[i][0], rectangles[i][2]), maxx);
            maxY = Math.max(Math.max(rectangles[i][1], rectangles[i][3]), maxY);
            totalArea += Math.abs((rectangles[i][2] - rectangles[i][0]) * (rectangles[i][3] - rectangles[i][1]));
        }
        int expectArea = Math.abs((maxx - minx) * (maxY - minY));
        if (totalArea != expectArea) {
            return false;
        }
        int[][] area = new int[maxx - minx][maxY - minY];
        for (int i = 0; i < rectangles.length; i++) {
            for (int j = rectangles[i][0] - minx; j < rectangles[i][2] - minx; j++) {
                for (int k = rectangles[i][1] - minY; k < rectangles[i][3] - minY; k++) {
//                    if (area[j][k] == 1) {
//                        return false;
//                    } else {
                    area[j][k] = 1;
//                    }
                }
            }
        }
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[0].length; j++) {
                if (area[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isRectangleCover(int[][] rectangles) {
        Integer minx = Integer.MAX_VALUE;
        Integer minY = Integer.MAX_VALUE;
        Integer maxx = Integer.MIN_VALUE;
        Integer maxY = Integer.MIN_VALUE;
        Integer totalArea = 0;
        for (int i = 0; i < rectangles.length; i++) {
            minx = Math.min(Math.min(rectangles[i][0], rectangles[i][2]), minx);
            minY = Math.min(Math.min(rectangles[i][1], rectangles[i][3]), minY);
            maxx = Math.max(Math.max(rectangles[i][0], rectangles[i][2]), maxx);
            maxY = Math.max(Math.max(rectangles[i][1], rectangles[i][3]), maxY);
            totalArea += Math.abs((rectangles[i][2] - rectangles[i][0]) * (rectangles[i][3] - rectangles[i][1]));
        }
        int expectArea = Math.abs((maxx - minx) * (maxY - minY));
        if (totalArea != expectArea) {
            return false;
        }
        Map<String, Integer> locationMap = new HashMap<>();
        for (int i = 0; i < rectangles.length; i++) {
            String key = rectangles[i][0] + "_" + rectangles[i][1];
            locationMap.put(key, locationMap.getOrDefault(key, 0) + 1);
            key = rectangles[i][2] + "_" + rectangles[i][3];
            locationMap.put(key, locationMap.getOrDefault(key, 0) + 1);
            key = rectangles[i][0] + "_" + rectangles[i][3];
            locationMap.put(key, locationMap.getOrDefault(key, 0) + 1);
            key = rectangles[i][2] + "_" + rectangles[i][1];
            locationMap.put(key, locationMap.getOrDefault(key, 0) + 1);


        }
        Set<String> outer = new HashSet<>();
        outer.add(minx + "_" + minY);
        outer.add(minx + "_" + maxY);
        outer.add(maxx + "_" + minY);
        outer.add(maxx + "_" + maxY);
        for (String s : locationMap.keySet()) {
            if (locationMap.get(s) == 1) {
                if (!outer.contains(s)) {
                    return false;
                }else{
                    outer.remove(s);
                }
            } else if (locationMap.get(s) != 2 && locationMap.get(s) != 4) {
                return false;
            }
        }
        return outer.size()==0;
    }

    public static void main(String[] args) {
        PerfectRectangle perfectRectangle = new PerfectRectangle();
        System.out.println(perfectRectangle.isRectangleCover(new int[][]{{1, 1, 3, 3}, {3, 1, 4, 2}, {1, 3, 2, 4}, {2, 2, 4, 4}}));
        System.out.println(perfectRectangle.isRectangleCover(new int[][]{{1, 1, 2, 3}, {1, 3, 2, 4}, {3, 1, 4, 2}, {3, 2, 4, 4}}));
        System.out.println(perfectRectangle.isRectangleCover(new int[][]{{1, 1, 3, 3}, {3, 1, 4, 2}, {3, 2, 4, 4}, {1, 3, 2, 4}, {2, 3, 3, 4}}));
        System.out.println(perfectRectangle.isRectangleCover(new int[][]{{1, 1, 3, 3}, {1, 3, 2, 4}, {3, 2, 4, 4}, {1, 3, 2, 4}, {2, 3, 3, 4}}));
        System.out.println(perfectRectangle.isRectangleCover(new int[][]{{0, 0, 1, 1}, {0, 1, 3, 2}, {1, 0, 2, 2}}));
        System.out.println(perfectRectangle.isRectangleCover(new int[][]{{0, 0, 4, 1}}));
        System.out.println(perfectRectangle.isRectangleCover(new int[][]{{0, 0, 2, 2}, {1, 1, 3, 3}, {2, 0, 3, 1}, {0, 3, 3, 4}}));
        System.out.println(perfectRectangle.isRectangleCover(new int[][]{{0, 0, 1, 1}, {0, 0, 2, 1}, {1, 0, 2, 1}, {0, 2, 2, 3}}));
        System.out.println(perfectRectangle.isRectangleCover(new int[][]{{0, 0, 1, 1}, {0, 0, 1, 1}, {1, 1, 2, 2}, {1, 1, 2, 2}}));

    }
}
