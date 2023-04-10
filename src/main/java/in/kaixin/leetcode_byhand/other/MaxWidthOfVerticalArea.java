package in.kaixin.leetcode_byhand.other;

import java.util.PriorityQueue;

public class MaxWidthOfVerticalArea {
    public int maxWidthOfVerticalArea(int[][] points) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->(a-b));
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            queue.add(x);


        }
        int max = 0;
        int size= queue.size();
        for (int i = 0; i < size - 1; i++) {
            int v=queue.poll();
            int peek= queue.peek();
            max = Math.max(max,peek-v);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxWidthOfVerticalArea area = new MaxWidthOfVerticalArea();
        System.out.println(area.maxWidthOfVerticalArea(new int[][]{{3, 1}, {9, 0}, {1, 0}, {1, 4}, {5, 3}, {8, 8}}));
    }
}
