package in.kaixin.leetcode_byhand.other;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LongestCommonSubsequence {
    //    https://leetcode-cn.com/problems/longest-common-subsequence/
//    public int longestCommonSubsequence(String text1, String text2) {
//        if (text1 == null || text2 == null || text1 == "" || text2 == "") {
//            return 0;
//        }
//        String ss = text1.length() > text2.length() ? text2 : text1;
//        String ls = text1.length() > text2.length() ? text1 : text2;
//        Map<Character, List<Integer>> locationMap = getLocationMap(ls);
//        int maxSubLength = 0;//最长字串
//        char[] ssArray = ss.toCharArray();
//        for (int i = 0; i < ss.length() - maxSubLength; i++) {
//            maxSubLength = Math.max(findLongest(ssArray, i, locationMap), maxSubLength);
//
//        }
//        return maxSubLength;
//    }

//    public int findLongest(char[] ss, int start, Map<Character, List<Integer>> locationMap) {
//        int cursor = -1;
//        int subLength = 0;
//        for (int i = start; i < ss.length; i++) {
//            char c = ss[i];
//            List<Integer> clocationList = locationMap.get(c);
//            if (clocationList == null || clocationList.size() == 0) {
//                continue;
//            }
//            int find = 0;
//            for (int j = 0; j < clocationList.size(); j++) {
//                if (clocationList.get(j) > cursor) {
//                    cursor = clocationList.get(j);
//                    find = 1;
//                    break;
//                }
//            }
//            if (find == 0) {
//                continue;
//            }
//            subLength++;
//        }
//        return subLength;
//    }
//
//    public Map<Character, List<Integer>> getLocationMap(String ls) {
//        Map<Character, List<Integer>> locationMap = new HashMap<>();
//        char[] chars = ls.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            char c = chars[i];
//            List<Integer> locationList = locationMap.get(c);
//            if (locationList == null) {
//                locationList = new LinkedList<>();
//                locationMap.put(c, locationList);
//            }
//            locationList.add(i);
//        }
//        return locationMap;
//    }

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == "" || text2 == "") {
            return 0;
        }
        char[] c1 = text1.toCharArray();
        char[] c2 = text2.toCharArray();
        int h = c1.length + 1;
        int r = c2.length + 1;
        int[][] matrix = new int[r][h];
        int maxLen = 0;
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < h; j++) {
                if (c2[i-1] == c1[j-1]) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    maxLen = Math.max(matrix[i][j],maxLen);
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }

            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        System.out.println(longestCommonSubsequence.longestCommonSubsequence("hofubmnylkra", "pqhgxgdofcvmr"));
//        System.out.println(longestCommonSubsequence.longestCommonSubsequence("abc", "abc"));
//        System.out.println(longestCommonSubsequence.longestCommonSubsequence("abc", "def"));

        System.out.println(longestCommonSubsequence.longestCommonSubsequence("mhunuzqrkzsnidwbun", "szulspmhwpazoxijwbq"));
        System.out.println(longestCommonSubsequence.longestCommonSubsequence("oxcpqrsvwf", "shmtulqrypy"));
    }

}
