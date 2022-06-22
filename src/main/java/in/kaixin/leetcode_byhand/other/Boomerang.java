package in.kaixin.leetcode_byhand.other;

public class Boomerang {
//    https://leetcode.cn/problems/valid-boomerang/
    public boolean isBoomerang(int[][] points) {
        int x1=points[1][0]-points[0][0];
        int y1=points[1][1]-points[0][1];
        int x2=points[2][0]-points[0][0];
        int y2=points[2][1]-points[0][1];
        if((x1==0&&y1==0)|| (x2==0&&y2==0)){
            return false;
        }
        if(x1==x2 && y1==y2){
            return false;
        }

        if(x1==x2 &&x1==0){
            return false;
        }
        if(y1==y2&& y1==0){
            return false;
        }

        if(1.0*x1/x2-1.0*y1/y2==0){
            return false;
        }
        return true;

    }
}
