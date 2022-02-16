package in.kaixin.leetcode_byhand;

import java.util.HashMap;
import java.util.Map;

public class SumOfUnique {
    //    https://leetcode-cn.com/problems/sum-of-unique-elements/
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (Integer integer : map.keySet()) {
            if (map.get(integer) == 1) {
                res += integer;
            }
        }
        return res;

    }
}
