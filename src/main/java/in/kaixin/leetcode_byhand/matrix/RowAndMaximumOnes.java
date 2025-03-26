package in.kaixin.leetcode_byhand.matrix;

public class RowAndMaximumOnes {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int maxOneCnt = 0;
        int row = 0;
        for (int i = 0; i < mat.length; i++) {
            int oneCnt = 0;
            for (int j = 0; j < mat[0].length; j++) {
                oneCnt += mat[i][j];
            }
            row = maxOneCnt < oneCnt ? i : row;
            maxOneCnt = Math.max(maxOneCnt, oneCnt);

        }
        int []res=new int[]{row,maxOneCnt};
        return res;

    }
}
