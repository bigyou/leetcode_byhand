package in.kaixin.leetcode_byhand.other;

import java.util.HashMap;
import java.util.Map;

public class NumDecodings {
//    https://leetcode-cn.com/problems/decode-ways/
    public int numDecodings(String s) {
        return doNumDecodings(s, 0, new HashMap<>());
    }

    public int doNumDecodings(String s, int offset, Map<Integer, Integer> note) {
        if (offset > s.length()) {
            return 0;
        }
        if (offset < s.length() && s.charAt(offset) == '0') {
            return 0;
        }
        if (offset == s.length() - 1 || offset == s.length()) {
            return 1;
        }


        if (note.get(offset) != null) {
            return note.get(offset);
        }

        char c = s.charAt(offset);
        char nextc = s.charAt(offset + 1);
        int v = new Integer("" + c + nextc);
        int cnt;
        if (v > 26) {
            cnt = doNumDecodings(s, offset + 1, note);
            note.put(offset, cnt);
            return cnt;
        } else {
            cnt = doNumDecodings(s, offset + 1, note) + doNumDecodings(s, offset + 2, note);
            note.put(offset, cnt);
            return cnt;
        }
    }

    public static void main(String[] args) {
        NumDecodings numDecodings = new NumDecodings();
//        System.out.println(numDecodings.numDecodings("0"));
//        System.out.println(numDecodings.numDecodings("2101"));
//        System.out.println(numDecodings.numDecodings("25"));
//        System.out.println(numDecodings.numDecodings("34"));
//        System.out.println(numDecodings.numDecodings("2023"));
//        System.out.println(numDecodings.numDecodings("06"));
        System.out.println(numDecodings.numDecodings("111111111111111111111111111111111111111111111"));
    }
}
