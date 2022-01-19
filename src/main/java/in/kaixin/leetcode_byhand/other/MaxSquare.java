package in.kaixin.leetcode_byhand.other;

public class MaxSquare {
//    https://leetcode-cn.com/problems/maximal-square/

    public int maximalSquare(char[][] matrix) {
        if (matrix == null) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int min = Math.min(m, n);//最多是个min*min的正方形
        int max = 0;
        for (int i = 1; i <= min; i++) {
            for (int j = 0; j <= m - i; j++) {
                for (int k = 0; k <= n - i; k++) {
                    if (matrix[j][k] - '0' < i - 1) {
                        continue;
                    }
                    boolean validate = validate(matrix, i, j, k);
                    if (validate) {
                        matrix[j][k] = (char) (i + '0');
                        max = Math.max(max, i);
                    }


                }

            }


        }
        return max * max;

    }

    /**
     * @param matrix
     * @param i      第几层
     * @param j      坐标
     * @param k
     * @return
     */

    public boolean validate(char[][] matrix, int i, int j, int k) {
        for (int o = 0; o < i; o++) {
            if (matrix[j + i - 1][k + o] == '0') {
                return false;
            }
        }
        for (int o = 0; o < i - 1; o++) {
            if (matrix[j + o][k + i - 1] == '0') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        char[][] maxtrix = new char[][]{new char[]{'1', '0', '1', '0', '0'},
//                                        new char[]{'1', '0', '1', '1', '1'},
//                                        new char[]{'1', '1', '1', '1', '1'},
//                                        new char[]{'1', '0', '1', '1', '1'}};
        char[][] maxtrix = new char[][]{new char[]{'1', '0' },
                                        new char[]{'1', '0' } };
        MaxSquare maxSquare = new MaxSquare();
        int max = maxSquare.maximalSquare(maxtrix);
        System.out.println("max=" + max);


    }
}
