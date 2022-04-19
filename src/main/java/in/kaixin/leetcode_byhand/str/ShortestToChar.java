package in.kaixin.leetcode_byhand.str;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.List;

public class ShortestToChar {
    public int[] shortestToChar(String s, char c) {
        List<Integer> appearList = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                appearList.add(i);
            }
        }
        int[] res = new int[s.length()];
        int cursor = 0;
        for (int i = 0; i < s.length(); i++) {
            if (appearList.get(cursor) >= i) {
                res[i] = appearList.get(cursor) - i;
            } else {
                if (cursor < appearList.size() - 1) {
                    int right = appearList.get(cursor + 1) - i;
                    int left = i - appearList.get(cursor);
                    if (right < left) {
                        res[i] = right;
                        cursor++;
                    } else {
                        res[i] = left;
                    }
                } else {
                    res[i] = i - appearList.get(cursor);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ShortestToChar shortestToChar = new ShortestToChar();
        System.out.println(JSON.toJSONString(shortestToChar.shortestToChar("aaba", 'b')));
    }
}
