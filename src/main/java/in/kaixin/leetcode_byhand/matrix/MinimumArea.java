package in.kaixin.leetcode_byhand.matrix;

public class MinimumArea {

    public int minimumArea(int[][] grid) {
        int minx = grid[0].length;
        int miny = grid.length;
        int maxx = 0;
        int maxy = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    minx = Math.min(minx, j);
                    maxx = Math.max(maxx, j);
                    miny = Math.min(miny, i);
                    maxy = Math.max(maxy, i);
                }
            }
        }
        if(minx>maxx||miny>maxy){
            return 0;
        }
        int v =(maxy-miny+1)*(maxx-minx+1);
        return v;
    }
}
