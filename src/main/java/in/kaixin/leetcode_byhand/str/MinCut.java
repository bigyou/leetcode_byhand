package in.kaixin.leetcode_byhand.str;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MinCut {
//    https://leetcode-cn.com/problems/palindrome-partitioning-ii/
    public int minCut(String s) {// 本来想用贪心来做，结果发现贪心求不出结果  老老实实用dp吧
        Map<Character, List<Integer>> locationMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            List<Integer> list = locationMap.get(c);
            if (list == null) {
                list = new LinkedList<>();
                locationMap.put(c, list);
            }
            list.add(i);
        }
        int res = doCut(0, s.length() - 1, s, locationMap, new HashMap<>());
        return res - 1;
    }
    public int doCut(int start, int end, String s, Map<Character, List<Integer>> locationMap, Map<Integer, Integer> noteMap) {
        if (end < 0) {
            return 0;
        }
        if (noteMap.get(end) != null) {
            return noteMap.get(end);
        }
        char c = s.charAt(end);
        List<Integer> list = locationMap.get(c);
        Integer subMin = Integer.MAX_VALUE;
        for (Integer location : list) {//BFS
            if (location > end) {
                break;
            }
            boolean find = validate(location, end, s);
            if (find == true) {
                subMin = Math.min(1 + doCut(0, location - 1, s, locationMap, noteMap), subMin);
            }
        }
        noteMap.put(end, subMin);
        return subMin;
    }
    public boolean validate(int start, int end, String s) {
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        MinCut minCut = new MinCut();
        System.out.println(minCut.minCut("adabdcaebdcebdcacaaaadbbcadabcbeabaadcbcaaddebdbddcbdacdbbaedbdaaecabdceddccbdeeddccdaabbabbdedaaabcdadbdabeacbeadbaddcbaacdbabcccbaceedbcccedbeecbccaecadccbdbdccbcbaacccbddcccbaedbacdbcaccdcaadcbaebebcceabbdcdeaabdbabadeaaaaedbdbcebcbddebccacacddebecabccbbdcbecbaeedcdacdcbdbebbacddddaabaedabbaaabaddcdaadcccdeebcabacdadbaacdccbeceddeebbbdbaaaaabaeecccaebdeabddacbedededebdebabdbcbdcbadbeeceecdcdbbdcbdbeeebcdcabdeeacabdeaedebbcaacdadaecbccbededceceabdcabdeabbcdecdedadcaebaababeedcaacdbdacbccdbcece"));
//        System.out.println(minCut.minCut("abbab"));
    }
}
