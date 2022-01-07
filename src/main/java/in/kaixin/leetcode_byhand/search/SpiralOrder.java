package in.kaixin.leetcode_byhand.search;

import java.util.LinkedList;
import java.util.List;

public class SpiralOrder {
    //    https://leetcode-cn.com/problems/spiral-matrix/
    public List<Integer> spiralOrder(int[][] matrix) {
        int up = 0, left = 0;
        int down = matrix.length - 1;
        int right = matrix[0].length - 1;
        List<Integer> list = new LinkedList<>();
        int vertical = 0;
        int row = 0;
        while (true) {
            if (left > right) {
                break;
            }
            for (int i = left; i <= right; i++) {
                list.add(matrix[vertical][i]);
            }
            row = right;
            up++;
            if (up > down) {
                break;
            }
            for (int j = up; j <= down; j++) {
                list.add(matrix[j][row]);
            }
            vertical = down;
            right--;
            if (left > right) {
                break;
            }
            for (int i = right; i >= left; i--) {
                list.add(matrix[vertical][i]);
            }
            row = left;
            down--;
            if (up > down) {
                break;
            }
            for (int j = down; j >= up; j--) {
                list.add(matrix[j][row]);
            }
            vertical = up;
            left++;

        }

        return list;
    }
}
