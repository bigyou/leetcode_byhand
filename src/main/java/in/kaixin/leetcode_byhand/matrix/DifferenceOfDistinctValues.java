package in.kaixin.leetcode_byhand.matrix;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class DifferenceOfDistinctValues {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int[][] res = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            op(0, i, grid, res);
        }
        for (int i = 1; i < grid.length; i++) {
            op(i, 0, grid, res);
        }
        return res;

    }

    public Map<Integer, Integer> caculateRight(int row, int column, int[][] grid) {
        int x = row;
        int y = column;
        Map<Integer, Integer> right = new HashMap<>();
        while (x < grid.length && y < grid[0].length) {
            int value = grid[x][y];
            right.put(value, right.getOrDefault(value, 0) + 1);
            x++;
            y++;
        }
        return right;
    }

    public void op(int row, int column, int[][] grid, int[][] res) {
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = caculateRight(row, column, grid);
        int x = row;
        int y = column;
        while (x < grid.length && y < grid[0].length) {
            int value = grid[x][y];
            int freq = right.remove(value);
            freq--;
            if (freq > 0) {
                right.put(value, freq);
            }
            res[x][y] = Math.abs(right.size() - left.size());
            left.put(value, left.getOrDefault(value, 0) + 1);

            x++;
            y++;
        }
    }

    public static void main(String[] args) {
        DifferenceOfDistinctValues d = new DifferenceOfDistinctValues();
        int[][] grid = new int[][]{{1, 2, 3}, {3, 1, 5}, {3, 2, 1}};
        int[][] res = d.differenceOfDistinctValues(grid);
        System.out.println(JSON.toJSONString(res));
    }
}
