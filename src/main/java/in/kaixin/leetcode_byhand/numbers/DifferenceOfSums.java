package in.kaixin.leetcode_byhand.numbers;

public class DifferenceOfSums {
    public int differenceOfSums(int n, int m) {
        int num1 = (1 + n) * n / 2;
        int times = n / m;
        int num2 = (times + 1) * times / 2 * m;
        int res=num1-2*num2;
        return res;
    }
}
