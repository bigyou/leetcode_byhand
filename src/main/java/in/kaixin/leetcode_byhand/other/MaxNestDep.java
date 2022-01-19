package in.kaixin.leetcode_byhand.other;

import java.util.Stack;

public class MaxNestDep {
    //    https://leetcode-cn.com/problems/maximum-nesting-depth-of-the-parentheses/
    public int maxDepth(String s) {
        int max = 0;
        char[] chars = s.toCharArray();
//        Stack<Character> stack = new Stack<>();
        int size=0;
        for (Character c : chars) {
            if ('(' == c) {
//                stack.push(c);
                size++;
                max = Math.max(max, size);
            } else if (')' == c) {
                size--;
//                if ('(' == stack.peek()) {
//                    stack.pop();
//                } else {
//                    max = 0;
//                    break;
                }
            }
        return size;
    }

    public static void main(String[] args) {
        MaxNestDep maxNestDep=new MaxNestDep();
        System.out.println(maxNestDep.maxDepth("(1+(2*3)+((8)/4))+1("));
    }
}
