package in.kaixin.leetcode_byhand;


public class StrAdd {
    //    https://leetcode-cn.com/problems/add-strings/
    public static String addStrings(String num1, String num2) {
        String longstr = num1.length() >= num2.length() ? num1 : num2;
        String shortstr = num1.length() >= num2.length() ? num2 : num1;

        int[] str = new int[longstr.length() + 1];
        int diff = longstr.length() - shortstr.length();
        int subfull = 0;
        for (int i = 0; i < longstr.length(); i++) {
            if (i < diff) {
                str[longstr.length() - i] = new Integer(longstr.charAt(longstr.length() - 1 - i)+"");
                continue;
            }
            int va = new Integer(longstr.charAt(longstr.length() - 1 - i) + "") +
                    new Integer(shortstr.charAt(shortstr.length() + diff - i - 1) + "") + subfull;
            if (va >= 10) {
                subfull = 1;
                va = va % 10;
            } else {
                subfull = 0;
            }
            str[longstr.length() - i] = va;
        }
        if (subfull == 1) {
            str[0] = 1;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length; i++) {
            if (i == 0 && str[0] == 0) {
                continue;
            }
            sb.append(str[i]);

        }
        java.lang.String res = sb.toString();
        return res;

    }

    public static void main(String[] args) {
        System.out.println(addStrings("11", "123"));
    }
}
