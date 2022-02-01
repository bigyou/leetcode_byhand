package in.kaixin.leetcode_byhand;

public class MinPathSum {
    //    https://leetcode-cn.com/problems/minimum-path-sum/
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        return minPath(grid, grid.length - 1, grid[0].length - 1, dp);
    }

    public int minPath(int[][] grid, int x, int y, int[][] dp) {
        if (x == 0 && y == 0) {
            return grid[0][0];
        }
        if (dp[x][y] > 0) {
            return dp[x][y];
        }
        if (x == 0) {
            dp[x][y] = minPath(grid, 0, y - 1, dp) + grid[0][y];
            return dp[x][y];
        }
        if (y == 0) {
            dp[x][y] = minPath(grid, x - 1, 0, dp) + grid[x][0];
            return dp[x][y];
        }
        dp[x][y] = Math.min(minPath(grid, x - 1, y, dp), minPath(grid, x, y - 1, dp)) + grid[x][y];
        return dp[x][y];
    }

    public static void main(String[] args) {
        int[][] grid = {{3, 8, 6, 0, 5, 9, 9, 6, 3, 4, 0, 5, 7, 3, 9, 3},
                {0, 9, 2, 5, 5, 4, 9, 1, 4, 6, 9, 5, 6, 7, 3, 2}, {8, 2, 2, 3, 3, 3, 1, 6, 9, 1, 1, 6, 6, 2, 1, 9},
                {1, 3, 6, 9, 9, 5, 0, 3, 4, 9, 1, 0, 9, 6, 2, 7}, {8, 6, 2, 2, 1, 3, 0, 0, 7, 2, 7, 5, 4, 8, 4, 8},
                {4, 1, 9, 5, 8, 9, 9, 2, 0, 2, 5, 1, 8, 7, 0, 9}, {6, 2, 1, 7, 8, 1, 8, 5, 5, 7, 0, 2, 5, 7, 2, 1},
                {8, 1, 7, 6, 2, 8, 1, 2, 2, 6, 4, 0, 5, 4, 1, 3}, {9, 2, 1, 7, 6, 1, 4, 3, 8, 6, 5, 5, 3, 9, 7, 3},
                {0, 6, 0, 2, 4, 3, 7, 6, 1, 3, 8, 6, 9, 0, 0, 8}, {4, 3, 7, 2, 4, 3, 6, 4, 0, 3, 9, 5, 3, 6, 9, 3},
                {2, 1, 8, 8, 4, 5, 6, 5, 8, 7, 3, 7, 7, 5, 8, 3}, {0, 7, 6, 6, 1, 2, 0, 3, 5, 0, 8, 0, 8, 7, 4, 3},
                {0, 4, 3, 4, 9, 0, 1, 9, 7, 7, 8, 6, 4, 6, 9, 5}, {6, 5, 1, 9, 9, 2, 2, 7, 4, 2, 7, 2, 2, 3, 7, 2},
                {7, 1, 9, 6, 1, 2, 7, 0, 9, 6, 6, 4, 4, 5, 1, 0}, {3, 4, 9, 2, 8, 3, 1, 2, 6, 9, 7, 0, 2, 4, 2, 0},
                {5, 1, 8, 8, 4, 6, 8, 5, 2, 4, 1, 6, 2, 2, 9, 7}};
        MinPathSum minPathSum = new MinPathSum();
        int min = minPathSum.minPathSum(grid);
        System.out.println(min);
    }
}
