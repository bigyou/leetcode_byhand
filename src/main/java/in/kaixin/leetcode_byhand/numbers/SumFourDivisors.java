package in.kaixin.leetcode_byhand.numbers;

import java.util.HashMap;
import java.util.Map;

public class SumFourDivisors {
//    https://leetcode.cn/problems/four-divisors/description/?envType=daily-question&envId=2026-01-04
//    mid
    public int sumFourDivisors(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            if (map.containsKey(v)) {
                res += map.get(v);
                continue;
            }
            int sumV = 0;
            for (int j = 2; j <= ((int) Math.sqrt(v)); j++) {
                int div = v / j;
                if (v % j == 0) {
                    if (div == j || sumV != 0) {
                        sumV = 0;
                        break;
                    }
                    sumV = j + div + 1 + v;
                }

            }
            map.put(v, sumV);
            res += sumV;
        }
        return res;
    }

}
