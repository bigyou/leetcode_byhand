package in.kaixin.leetcode_byhand.matrix;

public class MaxPresentValue {

    public int maxValue(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int maxv = 0;
                if (i > 0) {
                    maxv = Math.max(grid[i - 1][j], maxv);
                }
                if (j > 0) {
                    maxv = Math.max(grid[i][j - 1], maxv);
                }
                grid[i][j] += maxv;
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
