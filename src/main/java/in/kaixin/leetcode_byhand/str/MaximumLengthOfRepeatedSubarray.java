package in.kaixin.leetcode_byhand.str;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MaximumLengthOfRepeatedSubarray {

    public int findLength2(int[] nums1, int[] nums2) {//这个做法会超时
        int[] least = nums1.length > nums2.length ? nums2 : nums1;
        int[] more = nums1.length > nums2.length ? nums1 : nums2;
        Map<Integer, List<Integer>> locationMap = new HashMap<>();
        for (int i = 0; i < least.length; i++) {
            List<Integer> list = locationMap.get(least[i]);
            if (list == null) {
                list = new LinkedList<>();
                locationMap.put(least[i], list);
            }
            list.add(i);
        }
        int max = 0;
        for (int i = 0; i < more.length; i++) {
            if (locationMap.get(more[i]) == null) {
                continue;
            }
            int j = 0;
            int start = -1;
            while (j < locationMap.get(more[i]).size()) {
                start = locationMap.get(more[i]).get(j);
                int k = 0;
                while (start <= more.length - max && start + k < least.length && i + k < more.length && least[start + k] == more[i + k]) {
                    k++;
                }
                max = Math.max(max, k);
                j++;
            }
        }
        return max;
    }


    /**
     * N 3 2 1 4 7
     * 1 0 0 1 0 0
     * 2 0 1 1 0 0
     * 3 1 0 0 0 0
     * 2 0 2 0 0 0
     * 1 0 0 3 0 0
     * 用了dp 数组
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength(int[] nums1, int[] nums2) {
        int max = 0;
        int matrix[][] = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {//这里需要注意数组越界
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                    max = Math.max(matrix[i][j], max);
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {
        MaximumLengthOfRepeatedSubarray maximumLengthOfRepeatedSubarray = new MaximumLengthOfRepeatedSubarray();
        System.out.println(maximumLengthOfRepeatedSubarray.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
        System.out.println(maximumLengthOfRepeatedSubarray.findLength(new int[]{0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0}));
        System.out.println(maximumLengthOfRepeatedSubarray.findLength(new int[]{0, 0, 0, 0, 0}, new int[]{}));
        System.out.println(maximumLengthOfRepeatedSubarray.findLength(new int[]{70, 39, 25, 40, 7}, new int[]{52, 20, 67, 5, 31}));
    }
}
