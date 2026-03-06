package in.kaixin.leetcode_byhand.other;

public class MinTimeToVisitAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;
        for (int i = 1; i < points.length; i++) {
            int diffx = Math.abs(points[i][0] - points[i - 1][0]);
            int diffy = Math.abs(points[i][1] - points[i - 1][1]);
            int mindistance = Math.min(diffx, diffy);
            res += diffy - mindistance + diffx;
        }
        return res;
    }
}
