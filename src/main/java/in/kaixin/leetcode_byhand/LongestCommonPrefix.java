package in.kaixin.leetcode_byhand;

public class LongestCommonPrefix {
    //    https://leetcode-cn.com/problems/longest-common-prefix/
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String minstr = "";
        int min = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < min) {
                minstr = str;
                min = str.length();
            }
        }
        int end = Integer.MAX_VALUE;
        for (String str : strs) {
            end = Math.min(end, getPrefixLen(str, minstr, min));
        }
        return minstr.substring(0, end);
    }

    public int getPrefixLen(String str, String minStr, int len) {
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == minStr.charAt(i)) {
                continue;
            }
            return i;
        }
        return len;
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"abc", "abc", "d"}));
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"abc", "abcd", "ab"}));
    }
}
