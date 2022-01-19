package in.kaixin.leetcode_byhand.other;

public class CountSquar {
    //    https://leetcode-cn.com/problems/count-square-submatrices-with-all-ones/
    public int countSquares(int[][] matrix) {
        return dp(matrix);
    }

    public int dp(int[][] matrix) {
        int cnt = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                int up = i - 1 >= 0 ? matrix[i - 1][j] : 0;
                int left = j - 1 >= 0 ? matrix[i][j - 1] : 0;
                int upleft = i - 1 >= 0 && j - 1 >= 0 ? matrix[i - 1][j - 1] : 0;
                matrix[i][j] = Math.min(Math.min(up, left), upleft) + 1;
                cnt += matrix[i][j];
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
    }

}
