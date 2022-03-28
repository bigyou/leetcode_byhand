package in.kaixin.leetcode_byhand.matrix;

import com.alibaba.fastjson.JSON;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SurroundedRegions {
    //    https://leetcode-cn.com/problems/surrounded-regions/
    int containEdge = 0;

    public void solve1(char[][] board) {// 最开始的时候做法，dfs 然后标记是否会到达边界，同时用一个set标记已经访问过的path
        Set<String> visit = new HashSet<>();
        List<Location> list = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                doSolve(board, i, j, list, visit);
                toFillX(board, list);
            }
        }
        System.out.println(JSON.toJSONString(board));
    }

    public void toFillX(char[][] board, List<Location> list) {
        if (containEdge == 0) {//表示在边界上
            for (Location location : list) {
                board[location.x][location.y] = 'X';
            }
        }
        containEdge = 0;
        list.clear();

    }

    public void doSolve(char[][] board, int x, int y, List<Location> list, Set<String> visit) {
        if (x < 0 || x > board.length - 1 || y < 0 || y > board[0].length - 1) {
            return;
        }
        String key = x + "_" + y;
        if (visit.contains(key)) {
            return;
        }
        visit.add(key);

        if (board[x][y] == 'O') {
            list.add(new Location(x, y));
            if (x == 0 || x == board.length - 1 || y == 0 || y == board[0].length - 1) {
                containEdge = 1;
            }
            doSolve(board, x + 1, y, list, visit);
            doSolve(board, x - 1, y, list, visit);
            doSolve(board, x, y + 1, list, visit);
            doSolve(board, x, y - 1, list, visit);

        }

    }

    public static void main(String[] args) {
        SurroundedRegions surroundedRegions = new SurroundedRegions();
        surroundedRegions.solve(new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}});
    }


    public void solve(char[][] board) { //参考了题解
        for (int i = 0; i < board.length; i++) {
            doSolveEdge(board, i, 0);
            doSolveEdge(board, i, board[0].length - 1);
        }
        for (int i = 0; i < board[0].length; i++) {
            doSolveEdge(board, 0, i);
            doSolveEdge(board, board.length - 1, i);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'R') {
                    board[i][j] = 'O';
                }

            }
        }
        System.out.println(JSON.toJSONString(board));
    }

    public void doSolveEdge(char[][] board, int x, int y) {
        if (x < 0 || x > board.length - 1 || y < 0 || y > board[0].length - 1) {
            return;
        }
        if (board[x][y] == 'O') {
            board[x][y] = 'R';
            doSolveEdge(board, x, y + 1);
            doSolveEdge(board, x, y - 1);
            doSolveEdge(board, x + 1, y);
            doSolveEdge(board, x - 1, y);
        }

    }


}

class Location {
    int x;
    int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
