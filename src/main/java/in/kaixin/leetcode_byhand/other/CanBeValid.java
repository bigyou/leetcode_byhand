package in.kaixin.leetcode_byhand.other;

import java.util.Stack;

public class CanBeValid {
    //    https://leetcode.cn/problems/check-if-a-parentheses-string-can-be-valid/?envType=daily-question&envId=2025-03-23
//    mid
    public boolean canBeValid(String s, String locked) {
        int[] arr = new int[locked.length()];
        char[] sarr = s.toCharArray();
        for (int i = 0; i < locked.length(); i++) {
            if (locked.charAt(i) == '1') {
                arr[i] = 1;
            }
        }
        if ((sarr[0] == ')' && arr[0] == 1 ) || (sarr[sarr.length - 1] == '(') && arr[arr.length - 1] == 1) {
            return false;
        }
        sarr[0] = '(';
        sarr[sarr.length - 1] = ')';
        boolean res = checkInOrder(arr, sarr);
        if (res) {
            res = checkInReverse(arr, sarr);
        }
        return res;
    }

    public boolean checkInOrder(int[] arr, char[] sarr) {
        Stack<Character> stack = new Stack<>();
        stack.push('(');
        Stack<Character> freeStock = new Stack<>();
        for (int i = 1; i < sarr.length; i++) {
            if (arr[i] == 1) {
                char c = sarr[i];
                if (c == '(') {
                    stack.push('(');
                } else { //)
                    if (stack.isEmpty()) {
                        if (freeStock.size() == 0) {
                            return false;
                        } else {
                            freeStock.pop();
                        }
                    } else {
                        stack.pop();
                    }
                }
            } else {
                freeStock.push('0');
            }
        }
        if (freeStock.size() - stack.size() < 0) {
            return false;
        }
        return (freeStock.size() - stack.size()) % 2 == 0;
    }

    public boolean checkInReverse(int[] arr, char[] sarr) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> freeStock = new Stack<>();
        for (int i = sarr.length - 1; i > -1; i--) {
            if (arr[i] == 1) {
                char c = sarr[i];
                if (c == ')') {
                    stack.push(')');
                } else { //)
                    if (stack.isEmpty()) {
                        if (freeStock.size() == 0) {
                            return false;
                        } else {
                            freeStock.pop();
                        }
                    } else {
                        stack.pop();
                    }
                }
            } else {
                freeStock.push('0');
            }
        }
        if (freeStock.size() - stack.size() < 0) {
            return false;
        }
        return (freeStock.size() - stack.size()) % 2 == 0;
    }

    public static void main(String[] args) {
        CanBeValid canBeValid = new CanBeValid();
//        System.out.println(canBeValid.canBeValid("())(()(()(())()())(())((())(()())((())))))(((((((())(()))))(", "100011110110011011010111100111011101111110000101001101001111"));
        System.out.println(canBeValid.canBeValid("))()))", "010100"));
        System.out.println(canBeValid.canBeValid("))))(())((()))))((()((((((())())((()))((((())()()))(()", "101100101111110000000101000101001010110001110000000101"));
    }

}
