package in.kaixin.leetcode_byhand.matrix;

public class NumIslands {
    //    https://leetcode-cn.com/problems/number-of-islands/
    public int numIslands(char[][] grid) {
        int islandCnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    travelIsLand(grid, i, j);
                    islandCnt++;
                }
            }
        }

        return islandCnt;

    }

    public void travelIsLand(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return;
        }
        if (grid[x][y] == '1') {
            grid[x][y] = '0';
            travelIsLand(grid, x + 1, y);
            travelIsLand(grid, x - 1, y);
            travelIsLand(grid, x, y + 1);
            travelIsLand(grid, x, y - 1);
        }
    }

    public static void main(String[] args) {
        NumIslands numIslands = new NumIslands();
        System.out.println(numIslands.numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));
        System.out.println(numIslands.numIslands(new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}}));
    }
}
