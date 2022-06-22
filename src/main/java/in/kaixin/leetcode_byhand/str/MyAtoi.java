package in.kaixin.leetcode_byhand.str;


import java.util.LinkedList;
import java.util.List;

public class MyAtoi {
//    public int myAtoi(String s) {
//        int flag = 1;
//        int start = -1;
//        int end = 0;
//        String vstr = "";
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
//                if (start == -1) {
//                    continue;
//                } else {
//                    break;
//                }
//            }
//            if (start == -1) {
//                start = i;
//                end = i;
//                continue;
//            }
//            end = i;
//        }
//        if (start == -1) {
//            return 0;
//        }
//        if (start > 0) {
//            if (s.charAt(start - 1) == '-') {
//                flag = -1;
//            }
//        }
//
//        if (start >= 0) {
//            vstr = s.substring(start, end + 1);
//        }
//        start = 0;
//        while (start < vstr.length() - 1) {
//            if (vstr.charAt(start) == '0') {
//                start++;
//            } else {
//                break;
//            }
//        }
//        vstr = vstr.substring(start, vstr.length());
//        if (flag == -1) {
//            vstr = "-" + vstr;
//            String minStr = "" + Integer.MIN_VALUE;
//            if (vstr.length() > minStr.length() || (vstr.compareTo(minStr) >= 0 && minStr.length() == vstr.length())) {
//                return Integer.MIN_VALUE;
//            } else {
//                return Integer.parseInt(vstr);
//            }
//        } else {
//            String maxStr = "" + Integer.MAX_VALUE;
//            if (vstr.length() > maxStr.length() || (maxStr.length() == vstr.length() && vstr.compareTo(maxStr) > 0)) {
//                return Integer.MAX_VALUE;
//            } else {
//                return Integer.parseInt(vstr);
//            }
//        }
//    }

    public int myAtoi(String s) {
        List<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-') {
                if (!stack.isEmpty()) {
                    break;
                } else {
                    stack.add(c);
                    continue;
                }
            }
            if (c == ' ') {
                if (!stack.isEmpty()) {
                    break;
                }
                continue;
            }
            if (c < '0' || c > '9') {
                break;
            } else {
                stack.add(c);
            }
        }
        int findNotZero = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < stack.size(); i++) {
            if (stack.get(i) == '+') {
                continue;
            }
            if (stack.get(i) == '-') {
                sb.append('-');
                continue;
            }
            if (stack.get(i) == '0' && findNotZero == 0) {
                continue;
            }
            findNotZero = 1;
            sb.append(stack.get(i));
        }

        java.lang.String vstr = sb.toString();
        if (vstr.length() == 0 || (vstr.length() == 1 && (vstr.equals("-") || vstr.equals("+")))) {
            return 0;
        }
        if (vstr.startsWith("-")) {
            String minStr = "" + Integer.MIN_VALUE;
            if (vstr.length() > minStr.length() || (vstr.compareTo(minStr) >= 0 && minStr.length() == vstr.length())) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.parseInt(vstr);
            }
        } else {
            String maxStr = "" + Integer.MAX_VALUE;
            if (vstr.length() > maxStr.length() || (maxStr.length() == vstr.length() && vstr.compareTo(maxStr) > 0)) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.parseInt(vstr);
            }
        }
    }

    public static void main(String[] args) {
        MyAtoi myAtoi = new MyAtoi();
        System.out.println(myAtoi.myAtoi("  -23"));
        System.out.println(myAtoi.myAtoi("-0023"));
        System.out.println(myAtoi.myAtoi(" 0023"));
        System.out.println(myAtoi.myAtoi("ef-00sf"));
        System.out.println(myAtoi.myAtoi("ef-009sf"));
        System.out.println(myAtoi.myAtoi("ef-39sf"));
        System.out.println(myAtoi.myAtoi("+03900000000002sf"));
        System.out.println(myAtoi.myAtoi("-03900000000002sf"));
        System.out.println(myAtoi.myAtoi("words and 987"));
        System.out.println(myAtoi.myAtoi("+-12"));
        System.out.println(myAtoi.myAtoi("00000-42a1234"));
        System.out.println(myAtoi.myAtoi("  +  413"));
    }
}
