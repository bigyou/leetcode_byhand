package in.kaixin.leetcode_byhand;

import java.util.*;

public class HighestPeak {
    //    https://leetcode-cn.com/problems/map-of-highest-peak/
    public int[][] highestPeak(int[][] isWater) {
        if (isWater == null) {
            return null;
        }
        int[][] res = new int[isWater.length][isWater[0].length];
        List<Location> list = new LinkedList<>();
        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[0].length; j++) {
                if (isWater[i][j] == 1) {
                    res[i][j] = 0;
                    Location location = new Location(i, j);//这里需要用location
                    list.add(location);
                } else {
                    res[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        boolean change = true;
        int step = 1;
        int max = step;
        while (change) {
            change = false;
            for (Location location : list) {
                int i = location.getX();
                int j = location.getY();
                for (int t = 0; t < step; t++) {
                    change = setValue(res, i - t, j - step + t, step) || change;//change 需要放到后面
                    change = setValue(res, i - step + t, j + t, step) || change;
                    change = setValue(res, i + t, j + step - t, step) || change;
                    change = setValue(res, i + step - t, j - t, step) || change;
                }
                if (change) {
                    max = step;
                }

            }
            step++;
        }
        return res;
    }

    public boolean setValue(int[][] res, int i, int j, int v) {
        if (i < 0 || j < 0) {
            return false;
        }
        if (i >= res.length) {
            return false;
        }
        if (j >= res[0].length) {
            return false;
        }
        if (res[i][j] == Integer.MAX_VALUE) {
            res[i][j] = v;
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] nums = {{0, 0}, {1, 1}, {1, 0}};
        HighestPeak highestPeak = new HighestPeak();
        int[][] ints = highestPeak.highestPeak(nums);
        System.out.println(ints);
    }
}

class Location {
    int x;
    int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
