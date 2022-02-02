package in.kaixin.leetcode_byhand;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    //    https://leetcode-cn.com/problems/longest-consecutive-sequence/
    public int longestConsecutive(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        Set<Integer> integerSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            integerSet.add(nums[i]);
        }
        int maxLength = 0;
        while (integerSet.size() > maxLength) {
            int continueNum = caculateContinue(integerSet.iterator().next(), integerSet);
            maxLength = Math.max(maxLength, continueNum);
        }
        return maxLength;

    }

    public int caculateContinue(int value, Set<Integer> s) {
        int v = value;
        int continueNum = 0;
        while (s.contains(v)) {
            s.remove(v);
            continueNum++;
            v--;
        }
        v = value + 1;
        while (s.contains(v)) {
            s.remove(v);
            continueNum++;
            v++;
        }
        return continueNum;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        LongestConsecutive longestConsecutive = new LongestConsecutive();
        System.out.println(longestConsecutive.longestConsecutive(ints));
        System.out.println(longestConsecutive.longestConsecutive(new int[]{1, 3}));
        System.out.println(longestConsecutive.longestConsecutive(new int[]{1,2, 3}));
    }

}

