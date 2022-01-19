package in.kaixin.leetcode_byhand.other;

import java.util.Stack;

public class ValidParentheses {
    //https://leetcode-cn.com/problems/valid-parentheses/
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        boolean valide = true;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (stack.isEmpty()) {
                if (isLeft(c)) {
                    stack.push(c);
                } else {
                    valide = false;
                    break;
                }
            } else {
                if (isLeft(c)) {
                    stack.push(c);
                } else {
                    if (match(stack.peek(), c)) {
                        stack.pop();
                    } else {
                        valide = false;
                        break;
                    }
                }

            }
        }
        if (stack.size() > 0) {
            valide = false;
        }
        return valide;
    }

    public boolean match(char from, char to) {
        if ('(' == from && ')' == to) {
            return true;
        }
        if ('[' == from && ']' == to) {
            return true;
        }
        if ('{' == from && '}' == to) {
            return true;
        }
        return false;
    }

    public boolean isLeft(char c) {
        if ('(' == c || '{' == c || '[' == c) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("()[]{}"));
    }
}
