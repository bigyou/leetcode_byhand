package in.kaixin.leetcode_byhand.graph;

import java.util.LinkedList;
import java.util.List;

public class LargestRectangleArea {
    //    https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
    public int largestRectangleArea(int[] heights) {
        //这里其实可以暴力破解，但是会超时
        List<Integer> rise = new LinkedList<>();
        List<Integer> down = new LinkedList<>();
        rise.add(0);
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] >= heights[i - 1]) {
                rise.add(i);
            }
        }
        down.add(heights.length - 1);
        for (int i = heights.length - 2; i >= 0; i--) {
            if (heights[i] >= heights[i + 1]) {
                down.add(i);
            }
        }

        int maxV = Integer.MIN_VALUE;
        for (Integer r : rise) {
            int min = Integer.MAX_VALUE;
            int start = r;
            for (int i = down.size() - 1; i >= 0; i--) {
                int index = down.get(i);
                if (r > index) {
                    continue;
                }
                for (int k = start; k <= index; k++) {
                    min = Math.min(heights[k], min);
                }
                maxV = Math.max(maxV, min * (index - r + 1));
            }
        }
        if (maxV == Integer.MIN_VALUE) {
            maxV = 0;
        }
        return maxV;

    }

    public static void main(String[] args) {
        LargestRectangleArea largestRectangleArea = new LargestRectangleArea();
        System.out.println(largestRectangleArea.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(largestRectangleArea.largestRectangleArea(new int[]{2, 4}));
        System.out.println(largestRectangleArea.largestRectangleArea(new int[]{2, 0, 2}));
        System.out.println(largestRectangleArea.largestRectangleArea(new int[]{4,2,0,3,2,5}));
    }
}
