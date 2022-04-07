package in.kaixin.leetcode_byhand.str;

public class RotateString {
    //    https://leetcode-cn.com/problems/rotate-string/
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        int sindex = 0;
        while (sindex < s.length()) {
            char sc = s.charAt(sindex);
            if (sc == goal.charAt(0)) {
                if (validate(sindex, s, goal)) {
                    return true;
                }
            }
            sindex++;
        }
        return false;
    }

    public boolean validate(int start, String s, String goal) {
        if (start == 0) {
            return s.equals(goal);
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt((i + start) % s.length()) != goal.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RotateString rotateString = new RotateString();
        System.out.println(rotateString.rotateString("abcde", "cdeab"));
        System.out.println(rotateString.rotateString("abcde", "abced"));
        System.out.println(rotateString.rotateString("a", "b"));
    }
}
