package in.kaixin.leetcode_byhand;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    //    https://leetcode-cn.com/problems/coin-change/

    public int coinChange(int[] coins, int amount) {

        Map<Integer, Integer> noteMap = new HashMap<>();
        Arrays.sort(coins);
        Integer out = doCoinChange(coins, amount, noteMap);
        if (out == null) {
            out = -1;
        }
        System.out.println(out);
        return out;


    }

    public Integer doCoinChange(int[] coins, int amount, Map<Integer, Integer> noteMap) {
        if (amount == 0) {
            return 0;
        }
        Integer time = null;
        if (noteMap.containsKey(amount)) {
            return noteMap.get(amount);
        }


        for (int i = coins.length - 1; i >= 0; i--) {
            if (amount - coins[i] == 0) {
                return 1;
            } else if (amount - coins[i] > 0) {
                Integer next = doCoinChange(coins, amount - coins[i], noteMap);
                if (next == null) {
                    continue;//未找到
                }
                if (time == null) {
                    time = next + 1;
                } else if (next + 1 < time) {
                    time = next + 1;
                }
            } else {
                continue;
            }
        }
        noteMap.put(amount, time);
        return time;
    }

    public static void main(String... args) {
        CoinChange cc = new CoinChange();
        cc.coinChange(new int[]{1, 2, 5}, 100);
    }
}
