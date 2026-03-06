package in.kaixin.leetcode_byhand.numbers;

public class FlowerGame {
    public long flowerGame(int n, int m) {
        int m2 = m / 2;
        int n2 = n / 2;
        long v = (long) m2 * (n - n2) + (long) n2 * (m - m2);
        return v;
    }
}
