package in.kaixin.leetcode_byhand;

public class FindPeakElement {
    //    https://leetcode-cn.com/problems/find-peak-element/
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        for (; left < right; ) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }
}
