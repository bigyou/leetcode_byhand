package in.kaixin.leetcode_byhand.other;

public class CoinChange {// TODO 这里会有重复计算的问题
    //    https://leetcode-cn.com/problems/coin-change-2/

    public int change(int amount, int[] coins) {
        int[] arr = new int[amount + 1];
        arr[0] = 1;
        for (int j = 0; j < coins.length; j++) {
            for (int i = coins[j]; i < amount + 1; i++) {
                arr[i] = arr[i] + arr[i - coins[j]];
            }
        }
        return arr[amount];
    }


    // 以下做法会超时

//    int cnt = 0;
//    public int change(int amount, int[] coins) {
//        Arrays.sort(coins);
//        this.cnt = 0;
//        doCoinChange(amount, coins, coins.length - 1);
//        return cnt;
//    }
//
//    public void doCoinChange(int amount, int[] coins, int po) {
//        if (amount == 0) {
//            cnt++;
//            return;
//        }
//        if (amount < 0) {
//            return;
//        }
//        for (int i = po; i >= 0; i--) {
//            doCoinChange(amount - coins[i], coins, i);
//        }
//    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.change(25, new int[]{1, 2, 5}) );
    }

}
