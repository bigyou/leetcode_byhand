package in.kaixin.leetcode_byhand.other;

import java.util.Arrays;

public class MinPairSum {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        Integer min =Integer.MIN_VALUE;
        int n= nums.length/2;
        for(int i=0;i<n;i++){
            min=Math.max(min,(nums[i]+nums[nums.length-i-1]));

        }
        return min;

    }
}
