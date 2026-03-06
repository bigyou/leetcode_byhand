package in.kaixin.leetcode_byhand.matrix;

public class MinTimeToReach {
    //    https://leetcode.cn/problems/find-minimum-time-to-reach-last-room-i/?envType=daily-question&envId=2025-05-07
    //mid
    public int minTimeToReach(int[][] moveTime) {
        moveTime[0][0]=0;
        for (int i = 0; i < moveTime.length; i++) {
            for (int j = 0; j < moveTime[0].length; j++) {
                if (i == 0 && j == 0) {

                    continue;
                }
                int min = getMin(moveTime, i, j);
                if (i == moveTime.length - 1 && j == moveTime[0].length - 1) {
                    return min ;
                } else {
                    moveTime[i][j] += min;
                }


            }

        }
        return -1;
    }

    public int getMin(int[][] moveTime, int i, int j) {
        if (i == 0) {
            return moveTime[i][j - 1] + 1;
        } else if (j == 0) {
            return moveTime[i - 1][0] + 1;
        } else {
            return Math.min(moveTime[i - 1][j], moveTime[i][j - 1]) + 1;
        }
    }

    public static void main(String[] args) {

    }
}
