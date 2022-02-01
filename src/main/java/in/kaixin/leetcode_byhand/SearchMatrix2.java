package in.kaixin.leetcode_byhand;

public class SearchMatrix2 {
    //    https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = matrix.length - 1;
        int y = matrix[0].length - 1;
        int n = Math.min(x, y);
        for (int i = 0; i <= n; i++) {
            if (target > matrix[i][i]) {
                continue;
            }
            if (matrix[i][i] == target) {
                return true;
            }
            if (i == 0) {
                return false;
            }
            for (int j = i - 1; j >= 0; j--) {
                if (matrix[j][i] == target || matrix[i][j] == target) {
                    return true;
                }
            }
        }
        if (x > n) {
            for (int i = n + 1; i <= x; i++) {
                if (target > matrix[i][n]) {
                    continue;
                }
                for (int j = n; j >= 0; j--) {
                    if (matrix[i][j] == target) {
                        return true;
                    }
                }
            }

        }
        if (y > n) {
            for (int i = n + 1; i <= y; i++) {
                if (target > matrix[n][i]) {
                    continue;
                }
                for (int j = n; j >= 0; j--) {
                    if (matrix[j][i] == target) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15, 20}, {2, 5, 8, 12, 19, 23}, {3, 6, 9, 16, 22, 26}, {10, 13, 14, 17, 24, 28}, {18, 21, 23, 26, 30, 32}};
        SearchMatrix2 searchMatrix2 = new SearchMatrix2();
        System.out.println(searchMatrix2.searchMatrix(matrix, 28));
    }
}
