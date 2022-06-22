package in.kaixin.leetcode_byhand.numbers;

public class CountNumbersWithUniqueDigits {
    //    https://leetcode-cn.com/problems/count-numbers-with-unique-digits/
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        int res = 10;
        int t = n - 1;
        int v = 9;

        while (t > 0) {
            v = v * (10 - n + t);
            res += v;
            t--;
        }
        return res;
    }


    public static void main(String[] args) {
        CountNumbersWithUniqueDigits countNumbersWithUniqueDigits = new CountNumbersWithUniqueDigits();
        System.out.println(countNumbersWithUniqueDigits.countNumbersWithUniqueDigits(1));
        System.out.println(countNumbersWithUniqueDigits.countNumbersWithUniqueDigits(2));
        System.out.println(countNumbersWithUniqueDigits.countNumbersWithUniqueDigits(3));
    }
}
