package in.kaixin.leetcode_byhand.matrix;

public class LongestIncreasingPath {
    //    https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/
    int maxLength = 0;

    public int longestIncreasingPath(int[][] matrix) {
        maxLength = 0;
        int[][] res = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (res[i][j] == 0) {
                    maxLength = Math.max(searchDown(matrix, res, i, j), maxLength);
                }

            }
        }
        return maxLength;

    }


    public int searchDown(int[][] matrix, int[][] res, int x, int y) {
        if (getV(res, x, y) != 0) {
            return getV(res, x, y);
        }
        int v = getV(matrix, x, y);
        int max = 0;
        if (getV(matrix, x - 1, y) != null && getV(matrix, x - 1, y) < v) {
            max = Math.max(searchDown(matrix, res, x - 1, y), max);
        }
        if (getV(matrix, x + 1, y) != null && getV(matrix, x + 1, y) < v) {
            max = Math.max(searchDown(matrix, res, x + 1, y), max);
        }
        if (getV(matrix, x, y - 1) != null && getV(matrix, x, y - 1) < v) {
            max = Math.max(searchDown(matrix, res, x, y - 1), max);
        }
        if (getV(matrix, x, y + 1) != null && getV(matrix, x, y + 1) < v) {
            max = Math.max(searchDown(matrix, res, x, y + 1), max);
        }
        res[x][y] = max + 1;
        return res[x][y];
    }

    public Integer getV(int[][] matrix, int x, int y) {
        if (x < 0 || y < 0 || x > matrix.length - 1 || y > matrix[0].length - 1) {
            return null;
        }
        return matrix[x][y];
    }

    public static void main(String[] args) {
        LongestIncreasingPath longestIncreasingPath =new LongestIncreasingPath();
        System.out.println(longestIncreasingPath.longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}}));
        System.out.println(longestIncreasingPath.longestIncreasingPath(new int[][]{{3,4,5},{3,2,6},{2,2,1}}));
        System.out.println(longestIncreasingPath.longestIncreasingPath(new int[][]{{1}}));
    }

}

