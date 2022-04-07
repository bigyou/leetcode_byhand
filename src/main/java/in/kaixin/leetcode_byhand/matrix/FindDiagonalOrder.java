package in.kaixin.leetcode_byhand.matrix;

import com.alibaba.fastjson.JSON;

public class FindDiagonalOrder {
    //    https://leetcode-cn.com/problems/diagonal-traverse/
    public int[] findDiagonalOrder(int[][] mat) {
        int[] res = new int[mat.length * mat[0].length];
        int max = Math.max(mat.length, mat[0].length);
        int x = 0;
        int y = 0;
        int cursor = 0;
        for (int i = 0; i < 2 * max; i++) {
            if (i % 2 == 0) {//uprise
                while (x >= 0 && y < max) {
                    Integer v = getV(mat, x--, y++);
                    if (v != null) {
                        res[cursor++] = v;
                    }
                }
                x++;
                y--;
                if (y < max) {
                    y++;
                } else {
                    x++;
                }
            } else {//downrise
                while (y >= 0 && x < max) {
                    Integer v = getV(mat, x++, y--);
                    if (v != null) {
                        res[cursor++] = v;
                    }
                }
                x--;
                y++;
                if (x < max) {
                    x++;
                } else {
                    y++;
                }
            }


        }
        return res;
    }

    public Integer getV(int[][] mat, int x, int y) {
        if (x >= 0 && y >= 0 && x < mat.length && y < mat[0].length) {
            return mat[x][y];
        }
        return null;
    }

    public static void main(String[] args) {
        FindDiagonalOrder findDiagonalOrder = new FindDiagonalOrder();
        System.out.println(JSON.toJSONString(findDiagonalOrder.findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
        System.out.println(JSON.toJSONString(findDiagonalOrder.findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}})));
        System.out.println(JSON.toJSONString(findDiagonalOrder.findDiagonalOrder(new int[][]{{1, 2}, {4, 5}, {7, 8}})));
        System.out.println(JSON.toJSONString(findDiagonalOrder.findDiagonalOrder(new int[][]{{1, 2}, {3, 4}})));
        System.out.println(JSON.toJSONString(findDiagonalOrder.findDiagonalOrder(new int[][]{{1}, {3}})));
        System.out.println(JSON.toJSONString(findDiagonalOrder.findDiagonalOrder(new int[][]{{1, 2, 3}})));
    }
}
