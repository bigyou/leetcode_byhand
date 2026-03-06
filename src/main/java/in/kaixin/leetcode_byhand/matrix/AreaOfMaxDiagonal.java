package in.kaixin.leetcode_byhand.matrix;

public class AreaOfMaxDiagonal {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int dis = 0;
        int t = 0;
        for (int i = 0; i < dimensions.length; i++) {
            int x = dimensions[i][0];
            int y = dimensions[i][1];
            int tmp = x * x + y * y;
            if (tmp > t) {
                dis=x*y;
                t = tmp;
            }else if(tmp==t){
                dis = Math.max(dis, x * y);
            }
        }
        return dis;

    }
}
