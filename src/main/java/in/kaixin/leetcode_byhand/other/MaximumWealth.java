package in.kaixin.leetcode_byhand.other;

public class MaximumWealth {
//    https://leetcode-cn.com/problems/richest-customer-wealth/
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int amt = 0;
            for (int j = 0; j < accounts[0].length; j++) {
                amt += accounts[i][j];
            }
            max = Math.max(max, amt);
        }
        return max;
    }
}
