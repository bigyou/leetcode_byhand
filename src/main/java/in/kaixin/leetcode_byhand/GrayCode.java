package in.kaixin.leetcode_byhand;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GrayCode {
//    https://leetcode-cn.com/problems/gray-code/


//    public List<Integer> grayCode(int n) {
//        List<Integer> list = new LinkedList<>();
//        if (n == 0) {
//            list.add(0);
//            return list;
//        }
//
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 1; i <= n; i++) {
//
//
//        }
//
//    }
//
//    public Stack<Integer> generate(int n, List<Integer> ints) {
//
//        if (n == 1) {
//            Stack<Integer> stack = new Stack<>();
//            stack.push(0);
//            stack.push(1);
//            ints.add(0);
//            ints.add(1);
//            return stack;
//        }
//
//        Stack<Integer> stack = generate(n - 1, ints);
//        Stack<Integer> reverseStack = new Stack<>();
//        int basev = (int) Math.pow(2, n - 1);
//        while (!stack.isEmpty()) {
//            Integer pop = stack.pop();
//            int v = basev & pop;
//            reverseStack.push(v);
//            ints.add(v);
//        }
//
//
//    }
}
