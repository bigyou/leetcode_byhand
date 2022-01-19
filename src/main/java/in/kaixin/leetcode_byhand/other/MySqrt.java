package in.kaixin.leetcode_byhand.other;

public class MySqrt {
    //    https://leetcode-cn.com/problems/sqrtx/
    public int mySqrt(int x) {
        return (int) doSqrt(x, 0l, x);

    }

    public long doSqrt(int x, long begin, long end) {
        long mid = (begin + end) / 2;
        long va = mid * mid;
        if (va == x) {
            return mid;
        }
        if (begin == end) {
            return begin;
        }
        if (end - begin == 1) {
            if (end * end > x) {
                return begin;
            } else {
                return end;
            }
        }
        if (va > x) {
            return doSqrt(x, begin, mid);
        } else {
            return doSqrt(x, mid, end);
        }
    }

    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        System.out.println(mySqrt.mySqrt(2147395599));
    }
}
