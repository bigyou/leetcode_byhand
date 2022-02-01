package in.kaixin.leetcode_byhand;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LongestNiceSubstring {
    //    https://leetcode-cn.com/problems/longest-nice-substring/
    public String longestNiceSubstring(String s) {
        if (s == null || s.length() < 2) {
            return "";
        }

        Map<Character, List<Integer>> charLocationMap = getCharLocationMap(s);
        String res = doLongestNiceStr(s, 0, s.length() - 1, charLocationMap);
        return res;

    }

    public Map<Character, List<Integer>> getCharLocationMap(String s) {
        Map<Character, List<Integer>> charLocationMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            List<Integer> list = charLocationMap.get(s.charAt(i));
            if (list == null) {
                list = new LinkedList<>();
                charLocationMap.put(c, list);
            }
            list.add(i);
        }
        return charLocationMap;

    }

    public String doLongestNiceStr(String s, int start, int end, Map<Character, List<Integer>> locationMap) {
        if (end - start < 1) {
            return "";
        }
        Integer singleCharIndex = null;
        for (int i = start; i <= end; i++) {
            if (existNice(locationMap, s.charAt(i), start, end)) {//
                continue;
            } else {
                singleCharIndex = i;
                break;
            }
        }
        if (singleCharIndex == null) {
            return s.substring(start, end + 1);
        }

        String left = doLongestNiceStr(s, start, singleCharIndex - 1, locationMap);
        String right = doLongestNiceStr(s, singleCharIndex + 1, end, locationMap);
        String res = left.length() >= right.length() ? left : right;
        return res;
    }

    public boolean existNice(Map<Character, List<Integer>> locationMap, char c, int start, int end) {
        Character toFindC = null;
        if (Character.isLowerCase(c)) {
            toFindC = Character.toUpperCase(c);
        } else {
            toFindC = Character.toLowerCase(c);
        }
        List<Integer> list = locationMap.get(toFindC);
        if (list != null && list.size() > 0) {
            for (Integer index : list) {
                if (index >= start && index <= end) {
                    return true;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        LongestNiceSubstring longestNiceSubstring = new LongestNiceSubstring();
        System.out.println(longestNiceSubstring.longestNiceSubstring("ab"));
        System.out.println(longestNiceSubstring.longestNiceSubstring("aaA"));
        System.out.println(longestNiceSubstring.longestNiceSubstring("Bb"));
        System.out.println(longestNiceSubstring.longestNiceSubstring("YazaAay"));
        System.out.println(longestNiceSubstring.longestNiceSubstring("dDzeE"));
    }

}
