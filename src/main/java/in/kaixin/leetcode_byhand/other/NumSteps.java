package in.kaixin.leetcode_byhand.other;

import java.util.Stack;

public class NumSteps {
    //    https://leetcode.cn/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/?envType=daily-question&envId=2026-02-26
//    mid
    public int numSteps(String s) {
        int cnt = 0;
        int jin = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            stack.push(ch);
        }
        while (stack.size() > 1) {
            char c = stack.pop();
            if (c == '1') {
                jin = jin + 1;
            }
            if (jin % 2 == 0) {
                cnt++;
            } else {
                jin++;
                cnt += 2;
            }
            jin = jin / 2;
        }
        jin += stack.pop()-'0';
        while (jin > 1) {
            if(jin%2==1){
                cnt+=2;
            }else {
                cnt++;
            }
            jin = jin / 2;
        }
        return cnt;
    }

    public static void main(String[] args) {
        NumSteps numSteps = new NumSteps();
//        System.out.println(numSteps.numSteps("1101"));
        System.out.println(numSteps.numSteps("1"));
    }
}

