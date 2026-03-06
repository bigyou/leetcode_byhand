package in.kaixin.leetcode_byhand.matrix;

import java.util.LinkedList;
import java.util.List;

public class SortMatrix {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 1; i < n - 1; i++) { //右上方
            List<Integer> list = new LinkedList<>();
            for (int j = i; j < n; j++) {
                list.add(grid[j - i][j]);
            }
            list.sort((a, b) -> a - b);
            for (int j = i; j < n; j++) {
                grid[j - i][j] = list.get(j - i);
            }
            list.clear();
        }
        for (int i = 0; i < n; i++) {
            List<Integer> list = new LinkedList<>();
            for (int j = i; j < n; j++) {
                list.add(grid[j][j - i]);
            }
            list.sort((a, b) -> b - a);
            for (int j = i; j < n; j++) {
                grid[j][j - i] = list.get(j - i);
            }
            list.clear();
        }
        return grid;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 7, 3}, {9, 8, 2}, {4, 5, 6}};
        SortMatrix s = new SortMatrix();
        s.sortMatrix(grid);


    }
}
