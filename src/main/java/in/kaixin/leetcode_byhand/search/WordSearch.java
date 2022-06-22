package in.kaixin.leetcode_byhand.search;

import java.util.LinkedList;
import java.util.List;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (word.length() > board.length * board[0].length) {
            return false;
        }
        int[][] data = new int[board.length][board[0].length];
        List<Location> fistEleLocations = findFistEleLocations(word, board);
        if (fistEleLocations.size() == 0) {
            return false;
        }
        for (Location loc : fistEleLocations) {
            data[loc.x][loc.y] = 1;
            boolean find = doSearch(board, data, word, 1, loc.x, loc.y);
            data[loc.x][loc.y] = 0;
            if (find) {
                return find;
            }
        }

        return false;
    }

    public boolean doSearch(char[][] board, int[][] d, String word, int idx, int x, int y) {

        if (idx == word.length()) {
            return true;
        }
        char c = word.charAt(idx);
        boolean find = false;
        if (x - 1 >= 0 && y >= 0 && x - 1 < d.length && y < d[0].length && d[x - 1][y] == 0) {
            Character boardV = getv(board, x - 1, y);
            if (boardV != null && boardV == c) {
                d[x - 1][y] = 1;
                find = find || doSearch(board, d, word, idx + 1, x - 1, y);
                d[x - 1][y] = 0;
            }
        }
        if (find) {
            return true;
        }
        if (x + 1 >= 0 && y >= 0 && x + 1 < d.length && y < d[0].length && d[x + 1][y] == 0) {
            Character boardV = getv(board, x + 1, y);
            if (boardV != null && boardV == c) {
                d[x + 1][y] = 1;
                find = find || doSearch(board, d, word, idx + 1, x + 1, y);
                d[x + 1][y] = 0;
            }
        }
        if (find) {
            return true;
        }
        if (x >= 0 && y - 1 >= 0 && x < d.length && y - 1 < d[0].length && d[x][y - 1] == 0) {
            Character boardV = getv(board, x, y - 1);
            if (boardV != null && boardV == c) {
                d[x][y - 1] = 1;
                find = find || doSearch(board, d, word, idx + 1, x, y - 1);
                d[x][y - 1] = 0;
            }
        }
        if (find) {
            return true;
        }
        if (x >= 0 && y + 1 >= 0 && x < d.length && y + 1 < d[0].length && d[x][y + 1] == 0) {
            Character boardV = getv(board, x, y + 1);
            if (boardV != null && boardV == c) {
                d[x][y + 1] = 1;
                find = find || doSearch(board, d, word, idx + 1, x, y + 1);
                d[x][y + 1] = 0;
            }
        }
        return find;


    }

    public Character getv(char[][] board, int x, int y) {
        if (x >= board.length || x < 0 || y >= board[0].length || y < 0) {
            return null;
        }
        return board[x][y];
    }

    public List<Location> findFistEleLocations(String word, char[][] board) {
        List<Location> locations = new LinkedList<>();

        char c = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == c) {
                    Location loc = new Location(i, j);
                    locations.add(loc);
                }
            }
        }
        return locations;

    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
        System.out.println(wordSearch.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));
        System.out.println(wordSearch.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABAB"));
        System.out.println(wordSearch.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ADFCSEE"));
        System.out.println(wordSearch.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ADFCSEED"));
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
