package in.kaixin.leetcode_byhand.matrix;

import com.alibaba.fastjson.parser.JSONToken;

public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        doaction2(obstacleGrid);
        int res = obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
        return res;
    }
    public void doaction2(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int v = grid[i][j];
                if (v > 0) {
                    grid[i][j] = 0;
                    continue;
                }
                if (i == 0 && j == 0) {
                    grid[0][0] = 1;
                    continue;
                }
                grid[i][j] = getV(grid, i - 1, j) + getV(grid, i, j - 1);
            }
        }
    }

    public int getV(int[][] arr, int x, int y) {
        if (x >= 0 && x < arr.length && y >= 0 && y < arr[0].length) {
            return arr[x][y];
        }
        return 0;
    }
}
