//package in.kaixin.leetcode_byhand.str;
//
//import java.util.Stack;
//
//public class DecodeString {
//    public String decodeString(String s) {
//        Stack<String> stack = new Stack<>();
//        Stack<Integer> cntStack = new Stack<>();
//        StringBuffer sb = new StringBuffer();
//        int cnt = 0;
//        Integer start = null;
//        Integer end = null;
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            int dig = getDig(c);
//            if (dig >= 0) {//数字
//                cnt = 10 * cnt + dig;
//                if (start != null) {
//                    end = i - 1;
//                    Location location = new Location(start, end, 1);
//                    stack.push(location);
//
//                }
//            } else if (isLeft(c)) {
//
//
//            } else if (isRight(c)) {
//
//            } else {//字符
//                if (start == null) {
//                    start = i;
//                }
//            }
//        }
//
//    }
//
//    public boolean isLeft(Character c) {
//        return c == '[';
//    }
//
//    public boolean isRight(Character c) {
//        return c == ']';
//    }
//
//    public int getDig(char c) {
//        if (c >= '0' || c <= '9') {
//            return c - '0';
//        }
//        return -1;
//    }
//}
//
//class Location {
//    int start;
//    int end;
//    int times;
//
//    public Location(int start, int end, int times) {
//        this.start = start;
//        this.end = end;
//        this.times = times;
//    }
//}
