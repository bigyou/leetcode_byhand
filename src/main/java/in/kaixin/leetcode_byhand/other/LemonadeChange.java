package in.kaixin.leetcode_byhand.other;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author bigyou
 * @Create 2023/7/23 20:23
 */
public class LemonadeChange {
//    https://leetcode.cn/problems/lemonade-change/
//    easy
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < bills.length; i++) {
            if (!canGiveChange(map, bills[i])) {
                return false;
            }
        }
        return true;

    }

    public boolean canGiveChange(Map<Integer, Integer> map, int payAmount) {
        map.put(payAmount, map.getOrDefault(payAmount, 0) + payAmount);
        int giveBack = payAmount - 5;
        int tenLeft = giveBack / 10 * 10;
        int fiveLeft = giveBack - tenLeft;

        if (tenLeft > 0) {
            Integer ten = map.getOrDefault(10, 0);
            if (ten >= tenLeft) {
                map.put(10, map.getOrDefault(10, 0) - tenLeft);
                tenLeft = 0;
            } else {
                map.put(10, 0);
                tenLeft -= ten;
            }
        }
        fiveLeft += tenLeft;
        if (fiveLeft > 0) {
            Integer five = map.getOrDefault(5, 0);
            if (five >= fiveLeft) {
                map.put(5, five - fiveLeft);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LemonadeChange l = new LemonadeChange();
        System.out.println(l.lemonadeChange(new int[]{5, 5, 10, 10, 20}));
    }
}
