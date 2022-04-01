package in.kaixin.leetcode_byhand.numbers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CanReorderDoubled {
    //    https://leetcode-cn.com/problems/array-of-doubled-pairs/
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        Integer[] keySetArr = new Integer[map.keySet().size()];
        Arrays.sort(map.keySet().toArray(keySetArr));
        for (int i = 0; i < keySetArr.length; i++) {
            Integer key = keySetArr[i];
            Integer cnt = map.get(key);
            if (cnt == null || cnt == 0) {
                continue;
            }
            if (key > 0) {
                int nextKey = key * 2;
                Integer cnt2 = map.get(nextKey);
                if (cnt2==null||cnt2 < cnt) {
                    return false;
                }
                map.put(nextKey, map.get(nextKey) - map.get(key));
            } else if (key < 0) {
                if (key % 2 != 0) {
                    return false;
                }
                int nextKey = key / 2;
                Integer cnt2 = map.get(nextKey);
                if (cnt2 == null || cnt2 < cnt) {
                    return false;
                }
                map.put(nextKey, map.get(nextKey) - map.get(key));

            } else {
                if (cnt % 2 != 0) {
                    return false;
                }

            }
            map.put(key, 0);
        }
        return true;
    }

    public static void main(String[] args) {
        CanReorderDoubled canReorderDoubled = new CanReorderDoubled();
        System.out.println(canReorderDoubled.canReorderDoubled(new int[]{-2, 4, -4, 2}));
        System.out.println(canReorderDoubled.canReorderDoubled(new int[]{-2, 4, -3, 2}));
        System.out.println(canReorderDoubled.canReorderDoubled(new int[]{-2, -5}));
        System.out.println(canReorderDoubled.canReorderDoubled(new int[]{1, 2, 1, -8, 8, -4, 4, -4, 2, -2}));
    }
}
