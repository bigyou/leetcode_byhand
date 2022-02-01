package in.kaixin.leetcode_byhand;

import java.util.Map;

public class DivideTwoIntegers {
//    https://leetcode-cn.com/problems/divide-two-integers/solution/liang-shu-xiang-chu-by-leetcode-solution-5hic/
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        // 考虑被除数为 0 的情况
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            return -dividend;
        }
        int res = dodivide(-Math.abs(dividend), -Math.abs(divisor));
        if ((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)) {
            return res;
        }
        return -res;
    }

//    public int dodivide(int dividend, int divisor) {
//        int res = 0;
//        while (dividend <= divisor) {
//            dividend = dividend - divisor;
//            res++;
//        }
//        return res;
//    }

    public int dodivide(int dividend, int divisor) {
        if (dividend == 0 || dividend > divisor) {
            return 0;
        }
        int res = 0;
        int cost = 0;
        while (dividend - cost <= cost) {
            if (cost == 0) {
                res = 1;
                cost = divisor;
                continue;
            }
            cost = cost << 1;
            res = 2 * res;
        }
        int left = dividend - cost;
        return res + dodivide(left, divisor);
    }

    public static void main(String[] args) {
        DivideTwoIntegers d = new DivideTwoIntegers();
        System.out.println(d.divide(7, 2));
    }
}
