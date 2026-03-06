package in.kaixin.leetcode_byhand.matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindDiagonalOrder2 {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        List<Integer> v = new ArrayList<>(m * n);
        int[] res = new int[m * n];
        int flag = 1;
        int idx = 0;
        for (int k = 0; k < m + n - 1; k++) {
            if (flag == 1) {
                idx = addVUp(mat, k, res, m, n, idx);
            } else {
                idx = addVDown(mat, k, res, m, n, idx);
            }
            flag = flag * -1;
        }
        return res;
    }

    public int addVUp(int[][] mat, int k, int[] v, int m, int n, int idx) {
        int i = Math.min(k, m);
        int j = k - i;
        while (i >= 0 && j < n - 1) {
            v[idx++] = mat[i][j];
            i--;
            j++;
        }
        return idx;
    }

    public int addVDown(int[][] mat, int k, int[] v, int m, int n, int idx) {
        int j = Math.min(k, n);
        int i = k - j;
        while (i < m - 1 && j >= 0) {
            v[idx++] = mat[i][j];
            i++;
            j--;
        }
        return idx;
    }
}
