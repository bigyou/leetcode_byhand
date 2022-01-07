package in.kaixin.leetcode_byhand;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DailyTemp {
//    https://leetcode-cn.com/problems/daily-temperatures/


    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int j = temperatures.length - 1; j >= 0; j--) {
            int v = temperatures[j];
            while (!stack.isEmpty()) {
                int stackTopValue = temperatures[stack.peek()];
                if (stackTopValue <= v) {
                    stack.pop();
                    continue;
                } else {
                    res[j] = stack.peek() - j;
                    break;
                }
            }
            stack.push(j);
        }
        return res;

    }
}
