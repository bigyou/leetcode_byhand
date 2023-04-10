package in.kaixin.leetcode_byhand.str;

public class ShortestCommonSupersequence {
    //    https://leetcode.cn/problems/shortest-common-supersequence/ TODO
    public String shortestCommonSupersequence(String str1, String str2) {
        String lon = str1;
        String sho = str2;
        if (str1.length() < str2.length()) {
            lon = str2;
            sho = str1;
        }
        int maxSubLen = 0;
        for (int i = sho.length(); i >= 0; i--) {//左侧
            String sub = sho.substring(sho.length() - i, sho.length());
            if (lon.startsWith(sub)) {
                maxSubLen = i;
                break;
            }
        }
        int flag = 1;
        for (int i = 0; i < sho.length(); i++) {
            String sub = sho.substring(0, sho.length()-i);
            if (lon.endsWith(sub)) {
                if (sho.length() - i > maxSubLen) {
                    maxSubLen = sho.length() - i;
                    flag = 2;
                }
                break;
            }
        }
        String str = lon;
        if (flag == 1) {
            str = sho.substring(0, sho.length() - maxSubLen) + str;
        } else {
            str = str + sho.substring(maxSubLen, sho.length());
        }
        return str;
    }

    public static void main(String[] args) {
        ShortestCommonSupersequence s = new ShortestCommonSupersequence();
//        System.out.println(s.shortestCommonSupersequence("abac", "cab"));
//        System.out.println(s.shortestCommonSupersequence("a", "b"));
//        System.out.println(s.shortestCommonSupersequence("aa", "ab"));
//        System.out.println(s.shortestCommonSupersequence("ab", "aa"));
        System.out.println(s.shortestCommonSupersequence("bbbaaaba", "bbababbb"));
        System.out.println("bbabaaababb");
    }
}
