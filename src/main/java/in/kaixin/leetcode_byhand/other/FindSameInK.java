package in.kaixin.leetcode_byhand.other;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FindSameInK {
    //    https://leetcode-cn.com/problems/contains-duplicate-ii/
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < k && i < nums.length; i++) {
            if (indexMap.containsKey(nums[i])) {
                return true;
            }
            indexMap.put(nums[i], i);
        }
        for (int i = k; i < nums.length; i++) {
            Integer index = indexMap.get(nums[i]);
            if (index == null) {
                indexMap.put(nums[i], i);
            } else {
                if (i - index <= k) {
                    return true;
                } else {
                    indexMap.put(nums[i], i);
                }
            }


        }
        return false;
    }

    public static void main(String[] args) {
        FindSameInK findSameInK = new FindSameInK();
        boolean find = findSameInK.containsNearbyDuplicate(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15}, 15);
        System.out.println(find);

    }
}

