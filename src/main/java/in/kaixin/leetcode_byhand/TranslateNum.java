package in.kaixin.leetcode_byhand;

import java.util.HashMap;
import java.util.Map;

public class TranslateNum {


    public int translateNum(int num) {
        int v = doTranslate(num + "", 0, new HashMap<>());
        return v;

    }

    public int doTranslate(String s, int offset, Map<Integer, Integer> note) {
        if (offset == s.length() - 1 || offset == s.length()) {
            return 1;
        }
        if (offset > s.length() - 1) {
            return 0;
        }
        if (note.get(offset) != null) {
            return note.get(offset);
        }
        char c = s.charAt(offset);
        if (c == '0') {
            int v = doTranslate(s, offset + 1, note);
            note.put(offset, v);
            return v;
        } else {
            String substring = s.substring(offset, offset + 2);
            int num = Integer.parseInt(substring);
            if (num < 26) {
                int v = doTranslate(s, offset + 1, note) + doTranslate(s, offset + 2, note);
                note.put(offset, v);
                return v;
            } else {
                int v = doTranslate(s, offset + 1, note);
                note.put(offset, v);
                return v;
            }
        }
    }

    public static void main(String[] args) {
        TranslateNum translateNum = new TranslateNum();
//        System.out.println(translateNum.translateNum(25));
        System.out.println(translateNum.translateNum(12258));
    }
}
