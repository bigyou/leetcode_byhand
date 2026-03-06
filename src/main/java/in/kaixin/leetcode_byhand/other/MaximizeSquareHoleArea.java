package in.kaixin.leetcode_byhand.other;

import java.util.Arrays;

public class MaximizeSquareHoleArea {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int res = 1;
        int hcnt = getContinueCnt(hBars);
        int vcnt = getContinueCnt(vBars);
        int edge = Math.min(hcnt, vcnt) + 1;
        res = edge * edge;
        return res;
    }

    public int getContinueCnt(int[] hBars) {
        int cnt = 0;
        Arrays.sort(hBars);
        if (hBars.length == 0) {
            return cnt;
        }
        int pre = hBars[0];
        cnt = 1;
        int tempcnt = 1;
        for (int i = 1; i < hBars.length; i++) {
            int v = hBars[i];
            if (v - pre == 1) {
                tempcnt++;
            } else {
                cnt = Math.max(tempcnt, cnt);
                tempcnt = 1;
            }
            pre = v;
        }
        cnt = Math.max(tempcnt, cnt);
        return cnt;
    }
}
