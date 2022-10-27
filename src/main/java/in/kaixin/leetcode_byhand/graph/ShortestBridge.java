package in.kaixin.leetcode_byhand.graph;

public class ShortestBridge {
    //    https://leetcode.cn/problems/shortest-bridge/
    public int shortestBridge(int[][] grid) {
        seprateGrid(grid);
        int offset = 2;
        Integer step = null;
        for (int i = 0; i < Math.min(grid.length, grid[0].length) && step == null; i++) {
            step = doCover(grid, offset + i);
        }
        return step - offset;

    }

    public Integer doCover(int[][] grid, int v) {
        Integer step = null;
        for (int i = 0; i < grid.length && step == null; i++) {
            for (int j = 0; j < grid[0].length && step == null; j++) {
                if (grid[i][j] == v) {
                    step = fillStep(grid, i + 1, j, v);
                    if (step == null)
                        step = fillStep(grid, i - 1, j, v);
                    if (step == null)
                        step = fillStep(grid, i, j + 1, v);
                    if (step == null)
                        step = fillStep(grid, i, j - 1, v);

                }
            }
        }
        return step;


    }

    public Integer getV(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x > grid.length - 1 || y > grid[0].length - 1) {
            return Integer.MAX_VALUE;
        }
        if (grid[x][y] == 0 || grid[x][y] == 1) {
            return Integer.MAX_VALUE;
        }
        return grid[x][y];
    }

    public Integer fillStep(int[][] grid, int x, int y, int v) {
        if (x < 0 || y < 0 || x > grid.length - 1 || y > grid[0].length - 1) {
            return null;
        }
        if (grid[x][y] == 1) {
            return v;
        } else if (grid[x][y] == 0) {
            int minNearby = v;
            minNearby = Math.min(minNearby, getV(grid, x - 1, y));
            minNearby = Math.min(minNearby, getV(grid, x + 1, y));
            minNearby = Math.min(minNearby, getV(grid, x, y - 1));
            minNearby = Math.min(minNearby, getV(grid, x, y + 1));
            grid[x][y] = minNearby + 1;
        }

        return null;

    }

    public void seprateGrid(int[][] grid) {
//        int[][] island = new int[grid.length][grid[0].length];
        int findFlag = 0;
        int x = 0;
        int y = 0;
        //找到第一个点的坐标，并区分两个不同的小岛
        for (int i = 0; i < grid.length && findFlag == 0; i++) {
            for (int j = 0; j < grid[0].length && findFlag == 0; j++) {
                if (grid[i][j] == 1) {
                    if (findFlag == 0) {
                        findFlag = 1;
                        x = i;
                        y = j;
                        break;
                    }

                }
            }
        }
        // 找出 其中一个小岛
        doSep(grid, x, y);
    }

    public void doSep(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x > grid.length - 1 || y > grid[0].length - 1) { //越界
            return;
        }
        if (grid[x][y] == 1) {
            grid[x][y] = 2;
            doSep(grid, x + 1, y);
            doSep(grid, x - 1, y);
            doSep(grid, x, y + 1);
            doSep(grid, x, y - 1);
        } else {
            return;
        }
    }

    public static void main(String... args) {
        ShortestBridge b = new ShortestBridge();
//        int[][] grid = new int[][]{{0, 1}, {1, 0}};

//        System.out.println(b.shortestBridge(grid));
        int[][] grid = new int[][]{{0, 1, 0, 0, 0}, {0, 1, 0, 1, 1}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        System.out.println(b.shortestBridge(grid));
    }

}
