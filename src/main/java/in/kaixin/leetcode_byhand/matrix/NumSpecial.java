package in.kaixin.leetcode_byhand.matrix;

public class NumSpecial {
    public int numSpecial(int[][] mat) {
        int[] v = new int[mat.length];
        int[] h = new int[mat[0].length];
        int res = 0;
        for (int i = 0; i < mat.length; i++) {
            int sum = 0;
            for (int j = 0; j < mat[0].length; j++) {
                sum += mat[i][j];
            }
            v[i] = sum;
        }
        for (int i = 0; i < mat[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < mat.length; j++) {
                sum += mat[j][i];
            }
            h[i]=sum;
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if(mat[i][j]==1 && v[i]==1 && h[j]==1){
                    res++;
                }

            }
        }
        return res;


    }
}
