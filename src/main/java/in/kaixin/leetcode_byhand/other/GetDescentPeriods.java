package in.kaixin.leetcode_byhand.other;

import java.util.HashMap;
import java.util.Map;

public class GetDescentPeriods {
    //   https://leetcode.cn/problems/number-of-smooth-descent-periods-of-a-stock/description/?envType=daily-question&envId=2025-12-10
//    mid
    public  long getDescentPeriods(int[] prices) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < prices.length; ) {
            int j = i + 1;
            for (; j < prices.length; j++) {
                if ( (prices[j] - prices[j - 1] ) == -1) {
                    continue;
                } else {
                    break;
                }
            }
            Integer offset = j - i;
            int cnt = map.getOrDefault(offset, 0);
            map.put(offset, cnt + 1);
            i = j;

        }
        long res = 0;
        for (Integer key : map.keySet()) {
            res += 1l*(key + 1) * key / 2 *map.get(key);
        }
        return res;

    }

//    public static void main(String[] args) {
//        int[] prices=new int[]{8,6,7,7};
//        System.out.println(getDescentPeriods(prices));
//    }
}
