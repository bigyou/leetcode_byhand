package in.kaixin.leetcode_byhand.numbers;

import java.util.HashMap;
import java.util.Map;

public class RepeatedNTimes {
//    https://leetcode.cn/problems/n-repeated-element-in-size-2n-array/description/?envType=daily-question&envId=2026-01-02
//    mid
    public int repeatedNTimes(int[] nums) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            int cnt = map.getOrDefault(v, 0) + 1;
            if (cnt == n) {
                return v;
            }
            map.put(v, cnt);

        }
        return 0;

    }
}
