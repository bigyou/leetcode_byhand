package in.kaixin.leetcode_byhand.matrix;

public class GenerateMatrix {
    //    https://leetcode.cn/problems/spiral-matrix-ii/?envType=daily-question&envId=Invalid%20Date
//    mid
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int forwardType = 0;
        int x = 0;
        int y = 0;
        for (int i = 1; i <= n * n; i++) {
            res[x][y] = i;
            if (forwardType == 0) {
                if (y + 1 >= n || res[x][y + 1] != 0) {
                    forwardType = 1;
                    x++;
                } else {
                    y++;
                }
            } else if (forwardType == 1) {
                if (x + 1 >= n || res[x + 1][y] != 0) {
                    forwardType = 2;
                    y--;
                } else {
                    x++;
                }
            } else if (forwardType == 2) {
                if (y - 1 < 0 || res[x][y - 1] != 0) {
                    forwardType = 3;
                    x--;
                } else {
                    y--;
                }

            } else if (forwardType == 3) {

                if(x-1<0||res[x-1][y]!=0){
                    forwardType=0;
                    y++;
                }else {
                    x--;
                }

            } else {
            }
        }

        return res;
    }

}
