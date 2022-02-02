package in.kaixin.leetcode_byhand;

import java.util.Stack;

public class MaxAreaOfIsland {
    //    https://leetcode-cn.com/problems/max-area-of-island/
    public int maxAreaOfIsland2(int[][] grid) {//use dfs
        int maxLand = 0;
//        int[][] visit = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int caculate = caculate(grid, i, j, grid.length - 1, grid[0].length - 1);
                    maxLand = Math.max(maxLand, caculate);
                }
            }
        }
        return maxLand;
    }

    public int caculate(int[][] grid, int x, int y, int r, int h) {
        if (x < 0 || x > r || y < 0 || y > h || grid[x][y] == 0) {//访问过了
            return 0;
        }
        int v = getv(grid, x, y, r, h);
        if (v == 1) {
            return 1 + caculate(grid, x - 1, y, r, h)
                    + caculate(grid, x, y + 1, r, h)
                    + caculate(grid, x + 1, y, r, h)
                    + caculate(grid, x, y - 1, r, h);
        } else {
            return 0;
        }

    }

    public int getv(int[][] grid, int x, int y, int r, int h) {
        if (x < 0 || x > r || y < 0 || y > h) {
            return 0;
        } else {
            int res = grid[x][y];
            grid[x][y] = 0;
            return res;
        }
    }

    public int getv(int[][] grid, int x, int y, int r, int h, Stack<Loc> locs) {
        if (x < 0 || x > r || y < 0 || y > h) {
            return 0;
        } else {
            int res = grid[x][y];
            if (res == 1) {
                locs.add(new Loc(x, y));
                grid[x][y] = 0;
            }
            return res;

        }
    }

    public int maxAreaOfIsland(int[][] grid) {//use bfs
        int maxLand = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int caculate = caculateByBFS(grid, i, j, grid.length - 1, grid[0].length - 1);
                    maxLand = Math.max(maxLand, caculate);
                }
            }
        }
        return maxLand;
    }

    public int caculateByBFS(int[][] grid, int x, int y, int r, int h) {
        Stack<Loc> locs = new Stack<>();
        if (grid[x][y] == 1) {
            locs.push(new Loc(x, y));
            grid[x][y] = 0;
        } else {
            return 0;
        }
        int res = 1;
        while (!locs.isEmpty()) {
            Loc pop = locs.pop();
            res += getv(grid, pop.x - 1, pop.y, r, h, locs);
            res += getv(grid, pop.x + 1, pop.y, r, h, locs);
            res += getv(grid, pop.x, pop.y - 1, r, h, locs);
            res += getv(grid, pop.x, pop.y + 1, r, h, locs);
        }
        return res;
    }

}

class Loc {
    int x;
    int y;

    public Loc(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
