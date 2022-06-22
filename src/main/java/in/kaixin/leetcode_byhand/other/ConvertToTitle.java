package in.kaixin.leetcode_byhand.other;

import java.util.Stack;

public class ConvertToTitle {
//    https://leetcode-cn.com/problems/excel-sheet-column-title/
    public String convertToTitle(int columnNumber) {
        Stack<Character> strings = new Stack<>();
        while (columnNumber != 0) {
            char c = (char) ('A' + ((columnNumber - 1) % 26));
            columnNumber = (columnNumber - 1) / 26;
            strings.push(c);
        }
        StringBuffer sb = new StringBuffer();
        while (!strings.isEmpty()) {
            sb.append(strings.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ConvertToTitle convertToTitle = new ConvertToTitle();
        for (int i = 1; i < 54; i++) {
            System.out.println(convertToTitle.convertToTitle(i));
        }
    }
}
