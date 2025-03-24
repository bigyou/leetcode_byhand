package in.kaixin.leetcode_byhand.other;

import java.util.Arrays;

public class MaxCoin {
    //    https://leetcode.cn/problems/maximum-number-of-coins-you-can-get/?envType=daily-question&envId=2025-01-22
//    mid
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int res = 0;
        int n = piles.length / 3;
        for (int i = 0; i < n; i++) {
            res += piles[piles.length - 2 * i - 2];
        }
        return res;
    }

    public static void main(String[] args) {
        MaxCoin maxCoin = new MaxCoin();
        int res = maxCoin.maxCoins(new int[]{9, 8, 7, 6, 5, 1, 2, 3, 4});
        System.out.println(res);

    }
}
