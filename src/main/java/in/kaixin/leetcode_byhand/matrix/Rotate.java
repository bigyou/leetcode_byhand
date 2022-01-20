package in.kaixin.leetcode_byhand.matrix;

public class Rotate {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 0 || n == 1) {
            return;
        }
        route(matrix, 0, n - 1);
    }

    public void route(int[][] matrix, int start, int end) {
        if (start >= end) {
            return;
        }
        for (int i = start; i < end; i++) {
            int temp = matrix[start][i];
            matrix[start][i] = matrix[end-i+start][start];
            matrix[end-i+start][start] = matrix[end][end-i+start];
            matrix[end][end-i+start] = matrix[i][end];
            matrix[i][end] = temp;
        }

        route(matrix, start + 1, end - 1);
    }

    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate.rotate(array);
    }
}
