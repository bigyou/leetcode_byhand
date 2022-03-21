package in.kaixin.leetcode_byhand.graph;

public class MaximalRectangle {
    //    https://leetcode-cn.com/problems/maximal-rectangle/
    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return max;
        }
        int[][] v = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            int cnt = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    cnt++;
                } else {
                    cnt = 0;
                }
                v[i][j] = cnt;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (v[i][j] == 0) {
                    continue;
                }
                int maxVInRow = Integer.MAX_VALUE;
                for (int k = i; k >= 0; k--) {
                    if (v[k][j] == 0) {
                        break;
                    }
                    maxVInRow = Math.min(maxVInRow, v[k][j]);
                    max = Math.max(max, maxVInRow * (i - k + 1));
                }

            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaximalRectangle maximalRectangle = new MaximalRectangle();
        System.out.println(maximalRectangle.maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
        System.out.println(maximalRectangle.maximalRectangle(new char[][]{{'0'}}));
        System.out.println(maximalRectangle.maximalRectangle(new char[][]{{'0', '0'}}));
        System.out.println(maximalRectangle.maximalRectangle(new char[][]{{'0', '1'}}));
        System.out.println(maximalRectangle.maximalRectangle(new char[][]{{'1'}}));
        System.out.println(maximalRectangle.maximalRectangle(new char[][]{{}}));
    }
}
