package in.kaixin.leetcode_byhand;

import com.sun.deploy.util.StringUtils;

import java.util.Stack;

public class ReversePrefix {
    //    https://leetcode-cn.com/problems/reverse-prefix-of-word/
    public String reversePrefix(String word, char ch) {
        if (word == null || word == "") {
            return "";
        }
        Stack<Character> stack = new Stack<>();
        int i = 0;
        String right = "";
        boolean find = false;
        while (i < word.length()) {
            char c = word.charAt(i);
            stack.add(c);
            if (c == ch) {
                find = true;
                right = word.substring(i+1, word.length());
                break;
            }
            i++;
        }
        if (!find) {
            return word;
        } else {
            StringBuffer sb = new StringBuffer();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            sb.append(right);
            String res = sb.toString();
            return res;
        }
    }

    public static void main(String[] args) {
        ReversePrefix reversePrefix = new ReversePrefix();
        System.out.println(reversePrefix.reversePrefix("abcdefd", 'd'));
        System.out.println(reversePrefix.reversePrefix("xyxzxe", 'z'));
        System.out.println(reversePrefix.reversePrefix("abcd", 'z'));
        System.out.println(reversePrefix.reversePrefix("a", 'z'));
    }
}
