package in.kaixin.leetcode_byhand.matrix;

import com.alibaba.fastjson.JSON;

public class DailyFindDiagonalOrder {
    public int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length;
        int colums = mat[0].length;
        int row = 0;
        int column = 0;
        int forward = 1;//1表示上升
        int[] res = new int[rows * colums];
        for (int i = 0; i < res.length; i++) {
            res[i] = mat[row ][column];
            if (forward == 1) {
                if(row==0||column==colums-1){
                    if(column<colums-1){
                        column++;
                    }else {
                        row++;
                    }
                    forward=-1;
                }else {
                    row=row-1;
                    column=column+1;
                }
            } else {

                if(row==rows-1||column==0){
                    if(row<rows-1){
                        row++;
                    }else {
                        column++;
                    }
                    forward=1;
                }else {
                    row=row+1;
                    column=column-1;
                }
            }

        }
        return res;
    }
    public static void main(String ...args){
        DailyFindDiagonalOrder dailyFindDiagonalOrder=new DailyFindDiagonalOrder();
        int[] diagonalOrder = dailyFindDiagonalOrder.findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(JSON.toJSONString(diagonalOrder));
        diagonalOrder = dailyFindDiagonalOrder.findDiagonalOrder(new int[][]{{1, 2}, {4, 5}, {7, 8}});
        System.out.println(JSON.toJSONString(diagonalOrder));
        diagonalOrder = dailyFindDiagonalOrder.findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}});
        System.out.println(JSON.toJSONString(diagonalOrder));
        diagonalOrder = dailyFindDiagonalOrder.findDiagonalOrder(new int[][]{{1}});
        System.out.println(JSON.toJSONString(diagonalOrder));
    }
}
