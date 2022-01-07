package in.kaixin.leetcode_byhand.graph;

public class ComputerArea {
    //https://leetcode-cn.com/problems/rectangle-area/
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int oneMinx = Math.min(ax1, ax2);
        int oneMaxX = Math.max(ax1, ax2);
        int oneMinY = Math.min(ay1, ay2);
        int oneMaxY = Math.max(ay1, ay2);

        int twoMinx = Math.min(bx1, bx2);
        int twoMaxX = Math.max(bx1, bx2);
        int twoMinY = Math.min(by1, by2);
        int twoMaxY = Math.max(by1, by2);
        int cover = 0;
        if (twoMinx > oneMaxX || twoMaxX < oneMinx || twoMinY > oneMaxY || twoMaxY < oneMinY) {
            cover= 0;
        } else {
            int distanceX = Math.min(twoMaxX, oneMaxX) - Math.max(twoMinx, oneMinx);
            int distancey = Math.min(twoMaxY, oneMaxY) - Math.max(twoMinY, oneMinY);
            cover = distanceX * distancey;
        }
        return Math.abs((ax2 - ax1) * (ay2 - ay1)) + Math.abs((bx2 - bx1) * (by2 - by1)) - cover;


    }
}
