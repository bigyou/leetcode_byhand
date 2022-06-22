package in.kaixin.leetcode_byhand.str;

import com.alibaba.fastjson.JSON;

public class NumberOfLines {
    public int[] numberOfLines(int[] widths, String s) {
        int ls = 1;
        int ws = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (widths[index] + ws > 100) {
                ls++;
                ws = widths[index];
            } else {
                ws += widths[index];
            }
        }
        int[] res = new int[2];
        res[0] = ls;
        res[1] = ws;
        return res;

    }

    public static void main(String[] args) {
        NumberOfLines numberOfLines = new NumberOfLines();
        System.out.println(JSON.toJSONString(numberOfLines.numberOfLines(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, "abcdefghijklmnopqrstuvwxyz")));
        System.out.println(JSON.toJSONString(numberOfLines.numberOfLines(new int[]{4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10}, "bbbcccdddaaa")));
    }
}
