package in.kaixin.leetcode_byhand.matrix;

public class MaxMatrixSum {
    public long maxMatrixSum(int[][] matrix) {
//        https://leetcode.cn/problems/maximum-matrix-sum/description/?envType=daily-question&envId=2026-01-05
//        mid
        Integer min = Integer.MAX_VALUE;
        long ret = 0;
        int cnt = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int v = matrix[i][j];
                int absv = Math.abs(v);
                ret += absv;
                min = Math.min(min, absv);
                if (v <= 0) {
                    cnt++;
                }
            }
        }
        if (cnt % 2 == 1) {
            ret-= 2 * min;
        }
        return ret;

    }
}
