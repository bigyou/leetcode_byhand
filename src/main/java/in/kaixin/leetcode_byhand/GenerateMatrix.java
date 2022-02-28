package in.kaixin.leetcode_byhand;

public class GenerateMatrix {
    //    https://leetcode-cn.com/problems/spiral-matrix-ii/
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        fill(res, 0, 0, n - 1, 0, n - 1);
        return res;
    }

    public void fill(int[][] res, int start, int left, int right, int up, int down) {
        while (left <= right && up <= down) {
            for (int i = left; i <= right; i++) {
                fillOne(res, up, i, ++start);
            }
            up++;
            for (int i = up; i <= down; i++) {
                fillOne(res, i, right, ++start);
            }
            right--;
            for (int i = right; i >= left; i--) {
                fillOne(res, down, i, ++start);
            }
            down--;
            for (int i = down; i >= up; i--) {
                fillOne(res, i, left, ++start);
            }
            left++;
        }

    }

    public void fillOne(int[][] res, int x, int y, int v) {
        res[x][y] = v;
    }


    public static void main(String[] args) {
        GenerateMatrix generateMatrix = new GenerateMatrix();
        generateMatrix.printMatis(generateMatrix.generateMatrix(10));
    }

    public void printMatis(int[][] n) {
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n[i].length; j++) {
                System.out.print(n[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
