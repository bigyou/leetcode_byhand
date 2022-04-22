package in.kaixin.leetcode_byhand.other;

import java.util.Stack;

public class LengthLongestPath {
    public int lengthLongestPath(String input) {
        if (input.indexOf(".") < 0) {
            return 0;
        }
        String[] split = input.split("\\n");
        Stack<Integer> stack = new Stack<>();
        int size = 0;
        int max = 0;
        for (String s : split) {
            int i = countT(s);
            while (stack.size() < i) {
                stack.push(0);
            }
            while (stack.size() > i) {
                Integer pop = stack.pop();
                size -= pop;
            }
            int len = s.length() - i;
            stack.push(len);
            size += len;
            if(s.indexOf(".")>=0){
                max = Math.max(max, size + stack.size() - 1);
            }

        }
        return max;


    }

    public int countT(String s) {
        int idx = 0;
        int depth = 0;
        int cnt = 0;
        while (idx < s.length()) {
            String substring = s.substring(idx, idx + 1);
            if (substring.equals("\t")) {
                cnt++;
                idx += 1;
            } else {
                break;
            }

        }
        return cnt;
    }

    public static void main(String[] args) {
        LengthLongestPath lengthLongestPath = new LengthLongestPath();
        System.out.println(lengthLongestPath.lengthLongestPath("file1.txt\nfile2.txt\nlongfile.txt"));
        System.out.println(lengthLongestPath.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
        System.out.println(lengthLongestPath.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
        System.out.println(lengthLongestPath.lengthLongestPath("a"));
    }

}
