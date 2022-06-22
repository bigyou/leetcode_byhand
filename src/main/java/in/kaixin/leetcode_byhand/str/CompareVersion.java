package in.kaixin.leetcode_byhand.str;

public class CompareVersion {
    //    https://leetcode-cn.com/problems/compare-version-numbers/
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
            int v1int = getInt(v1, i);
            int v2int = getInt(v2, i);
            if (v1int > v2int) {
                return 1;
            } else if (v1int < v2int) {
                return -1;
            }
        }
        return 0;

    }

    public int getInt(String[] sarr, int idx) {
        if (idx > sarr.length - 1) {
            return 0;
        }
        String s = sarr[idx];
        if ("".equals(s)) {
            return 0;
        }
        int i = 0;
        for (; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                continue;
            } else {
                break;
            }
        }
        s = s.substring(i, s.length());
        if ("".equals(s)) {
            return 0;
        }
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        CompareVersion compareVersion = new CompareVersion();
        System.out.println(compareVersion.compareVersion("1.01", "1.001"));
        System.out.println(compareVersion.compareVersion("1.11", "1.001"));
        System.out.println(compareVersion.compareVersion("1.01", "1.2"));
        System.out.println(compareVersion.compareVersion("1.21", "1.021"));
        System.out.println(compareVersion.compareVersion("1.2.1", "1.021"));
        System.out.println(compareVersion.compareVersion("1.0", "1.0.0"));
        System.out.println(compareVersion.compareVersion("1..0.2", "1.0.3"));
        System.out.println(compareVersion.compareVersion("1", "1.0.1"));
    }
}
