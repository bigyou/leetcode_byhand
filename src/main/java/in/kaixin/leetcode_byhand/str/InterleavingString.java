package in.kaixin.leetcode_byhand.str;

import java.util.HashMap;
import java.util.Map;

public class InterleavingString {
    //    https://leetcode-cn.com/problems/interleaving-string/
    public boolean isInterleave(String s1, String s2, String s3) {
        int lenth = s1 == null ? 0 : s1.length();
        lenth += s2 == null ? 0 : s2.length();
        lenth -= s3 == null ? 0 : s3.length();
        if (lenth != 0) {
            return false;
        }
        s1 = s1 == null ? "" : s1;
        s2 = s2 == null ? "" : s2;
        boolean b = doInterLeave(s1, s2, s3, new HashMap<>());
        return b;
    }

    public boolean doInterLeave(String s1, String s2, String s3, Map<String, Boolean> map) {
        if (s1 == null || s1.length() == 0) {
            return s2.equals(s3);
        }
        if (s2 == null || s2.length() == 0) {
            return s1.equals(s3);
        }
        String key = s1 + "_" + s2 + "_" + s3;
        if (map.containsKey(key)) {
            return map.get(s1 + "_" + s2 + "_" + s3);
        }
        boolean oneSame = s1.charAt(0) == s3.charAt(0);
        boolean twoSame = s2.charAt(0) == s3.charAt(0);
        if (oneSame && twoSame) {
            boolean suc = doInterLeave(s1.substring(1, s1.length()), s2, s3.substring(1, s3.length()), map) ||
                    doInterLeave(s1, s2.substring(1, s2.length()), s3.substring(1, s3.length()), map);
            map.put(s1 + "_" + s2 + "_" + s3, suc);
            return suc;
        } else if (oneSame) {
            boolean suc = doInterLeave(s1.substring(1, s1.length()), s2, s3.substring(1, s3.length()), map);
            map.put(s1 + "_" + s2 + "_" + s3, suc);
            return suc;
        } else if (twoSame) {
            boolean suc = doInterLeave(s1, s2.substring(1, s2.length()), s3.substring(1, s3.length()), map);
            map.put(s1 + "_" + s2 + "_" + s3, suc);
            return suc;
        } else {
            map.put(s1 + "_" + s2 + "_" + s3, false);
            return false;
        }
    }

    public static void main(String[] args) {
        InterleavingString interleavingString = new InterleavingString();
        System.out.println(interleavingString.isInterleave("", null, ""));
        System.out.println(interleavingString.isInterleave("aaaa", "aa", "aaa"));
        System.out.println(interleavingString.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(interleavingString.isInterleave("aabcc", "dbbca", "aadbbcbccc"));
        System.out.println(interleavingString.isInterleave("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa", "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab", "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"));
    }
}
