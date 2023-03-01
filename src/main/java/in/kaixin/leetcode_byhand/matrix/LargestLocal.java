package in.kaixin.leetcode_byhand.matrix;

public class LargestLocal {
//    https://leetcode.cn/problems/largest-local-values-in-a-matrix/submissions/407772252/
    public int[][] largestLocal(int[][] grid) {
        caculateVerticalMax(grid);
        caculateHerticalMax(grid);
        int[][] res = new int[grid.length - 2][grid.length - 2];
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid.length - 2; j++) {
                res[i][j] = grid[i][j];
            }

        }
        return res;

    }

    public void caculateVerticalMax(int[][] grid) {
        for (int j = 0; j < grid.length; j++) {//计算纵向的最大值
            for (int i = 0; i < grid.length - 2; i++) {
                grid[i][j] = Math.max(grid[i][j], grid[i + 1][j]);
                grid[i][j] = Math.max(grid[i][j], grid[i + 2][j]);
            }
        }

    }

    public void caculateHerticalMax(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {//计算横向的最大值
            for (int j = 0; j < grid.length - 2; j++) {
                grid[i][j] = Math.max(grid[i][j], grid[i][j + 1]);
                grid[i][j] = Math.max(grid[i][j], grid[i][j + 2]);
            }
        }

    }
}
