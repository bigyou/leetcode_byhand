package in.kaixin.leetcode_byhand.other;

import java.util.*;

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

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]) && set.size() <= k) {
                return true;
            }
            if (i >= k) {
                set.remove(nums[i - k]);
            }
            set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        FindSameInK findSameInK = new FindSameInK();
        boolean find = findSameInK.containsNearbyDuplicate2(new int[]{1, 2, 1}, 1);
        System.out.println(find);

    }
}

