package in.kaixin.leetcode_byhand.matrix;

/**
 * @Author bigyou
 * @Create 2023/7/13 11:25
 */
public class MinFallingPathSum {
    //    https://leetcode.cn/problems/minimum-falling-path-sum/
    public int minFallingPathSum(int[][] matrix) {
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int v = matrix[i][j] + matrix[i - 1][j];
                if (j > 0) {
                    v = Math.min(v, matrix[i][j] + matrix[i - 1][j - 1]);
                }
                if (j < matrix[0].length - 1) {
                    v = Math.min(v, matrix[i][j] + matrix[i - 1][j + 1]);
                }
                matrix[i][j]=v;
            }
        }
        for(int j=0;j<matrix[0].length;j++){
            res=Math.min(res,matrix[matrix.length-1][j]);
        }
        return res;


    }

    public static void main(String[] args) {
        int[][] matix = new int[][]{new int[]{2, 1, 3}, new int[]{6, 5, 4}, new int[]{7, 8, 9}};
        MinFallingPathSum m =new MinFallingPathSum();
        int v= m.minFallingPathSum(matix);
        System.out.println(v);

    }


}
