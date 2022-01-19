package in.kaixin.leetcode_byhand.other;

import java.util.*;

public class MinimumWindow {
//    https://leetcode-cn.com/problems/minimum-window-substring/


//    public String minWindow(String s, String t) {
//        if (t == null || s == null || t.length() > s.length() || s == "" || t == "") {
//            return "";
//        }
//        Map<Character, List<Integer>> locationMap = new HashMap<>();
//        Set<Character> tset = new HashSet<>();
//        char[] chars = s.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            Character c = chars[i];
//            tset.add(c);
//            List<Integer> list = locationMap.get(c);
//            if (list == null) {
//                list = new LinkedList<>();
//                locationMap.put(c, list);
//
//            }
//            list.add(i);
//        }
//        //--找到出现次数最小的c
//        int max = Integer.MAX_VALUE;
//        Character minFreqc = null;
//        for (Character character : t.toCharArray()) {
//            if (locationMap.get(character) == null) {
//                return "";//没有全部包括
//            }
//            if (locationMap.get(character).size() < max) {
//                max = locationMap.get(character).size();
//                minFreqc = character;
//            }
//        }
//        List<Integer> list = locationMap.get(minFreqc);
//        int start = s.length() - 1;
//        int end = 0;
//        for (int i = 0; i < list.size(); i++) {
//            int[] use = new int[s.length()];
//            int location = list.get(i);
//            use[location] = 0;
//            int singgleStart = location;
//            int singgleEnd = location;
//            for (Character character : t.toCharArray()) {
//                if (minFreqc == character && use[location] == 0) {
//                    use[location] = 1;
//                    continue;
//                }
//                int minC = Integer.MAX_VALUE;
//                List<Integer> list1 = locationMap.get(character);
//
//                int index = -1;
//                for (Integer integer : list1) {//这里去找每个字符距离最近的坐标
//                    if (use[integer] == 1) {
//                        continue;
//                    }
//                    if (minC > Math.abs(integer - location)) {
//                        index = integer;
//                        minC = Math.min(minC, Math.abs(integer - location));
//                    } else if (minC ==Math.abs(integer - location)){
//
//                    }
//                    if (integer > location) {
//                        break;
//                    }
//                }
//                if (index < 0) {
//                    return "";
//                }
//                use[index] = 1;
//                singgleStart = Math.min(index, singgleStart);
//                singgleEnd = Math.max(index, singgleEnd);
//            }
//
//            if (singgleEnd - singgleStart <= Math.abs(end - start)) {
//                start = singgleStart;
//                end = singgleEnd;
//            }
//
//        }
//        if (end < start) {
//            return "";
//        }
//        return s.substring(start, end + 1);

    //    }
    Integer resEnd = null;
    Integer resStart = null;

    public String minWindow(String s, String t) {
        Map<Character, Integer> windowFreq = new HashMap<>();
        char[] tchars = t.toCharArray();
        for (char c : tchars) {
            windowFreq.put(c, 0);
        }
        Map<Character, Integer> tFreq = new HashMap<>();
        for (char c : tchars) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }
        char[] schars = s.toCharArray();
        Integer windowStart = Integer.MAX_VALUE;
        Integer windowEnd = -1;
        Integer resStart = null;
        Integer resEnd = null;
        int start = 0;

        Map<Character, Integer> initMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            int index = initMap.getOrDefault(tchars[i], -1) + 1;
            if (index > s.length() - 1) {
                return "";
            }
            for (int j = index; j < s.length(); j++) {
                if (tchars[i] == schars[j]) {
                    windowStart = Math.min(windowStart, j);
                    windowEnd = Math.max(windowEnd, j);
                    initMap.put(tchars[i], j);
                    break;
                }
                if (j == s.length() - 1) {
                    return "";//没有找到
                }
            }
        }
        if (windowStart == -1 || windowEnd == Integer.MAX_VALUE) {
            return "";//没有找到
        }
        for (int i = windowStart; i <= windowEnd; i++) {
            if (tFreq.containsKey(schars[i])) {
                windowFreq.put(schars[i], windowFreq.getOrDefault(schars[i], 0) + 1);
            }
        }

        windowStart = compressLeft(schars, windowFreq, tFreq, windowStart, windowEnd);
        resEnd = windowEnd;
        resStart = windowStart;

        for (int i = windowEnd + 1; i < s.length(); i++) {
            if (windowFreq.containsKey(schars[i])) {
                windowFreq.put(schars[i], windowFreq.get(schars[i]) + 1);
                windowEnd = i;
                windowStart = compressLeft(schars, windowFreq, tFreq, windowStart, windowEnd);

                if (windowEnd - windowStart < resEnd - resStart) {
                    resStart = windowStart;
                    resEnd = windowEnd;
                }
            } else {
                continue;
            }

        }
        return s.substring(resStart, resEnd + 1);


    }

    public int compressLeft(char[] schars, Map<Character, Integer> windowFreq, Map<Character, Integer> tFreq,
                            Integer windowStart, Integer windowEnd) {
        Integer left = windowStart;
        for (int j = windowStart; j < windowEnd; j++) {
            if (windowFreq.containsKey(schars[j])) {
                if (windowFreq.get(schars[j]) > tFreq.get(schars[j])) {
                    windowFreq.put(schars[j], windowFreq.get(schars[j]) - 1);
                    left++;
                    continue;
                } else {
                    left = j;
                    break;
                }
            } else {
                left++;
                continue;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        MinimumWindow minimumWindow = new MinimumWindow();
        System.out.println(minimumWindow.minWindow("acbbaca", "aba"));
        System.out.println(minimumWindow.minWindow("aa", "aa"));
        System.out.println(minimumWindow.minWindow("a", "aa"));
        System.out.println(minimumWindow.minWindow("aaa", "aab"));
        System.out.println(minimumWindow.minWindow("aaa", "aaa"));
        System.out.println(minimumWindow.minWindow("abc", "cba"));
    }
}
