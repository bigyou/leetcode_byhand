package in.kaixin.leetcode_byhand.search;

public class BinarySearch {
    //    https://leetcode-cn.com/problems/binary-search/
    public int search(int[] nums, int target) {
        return doSearch(nums, target, 0, nums.length - 1);
    }

    public int doSearch(int[] nums, int target, int start, int end) {
        if (start == end) {
            if (nums[start] == target) {
                return start;
            } else {
                return -1;
            }
        }
        if (end - start == 1) {
            if (nums[start] == target) {
                return start;
            }
            if (nums[end] == target) {
                return end;
            }
            return -1;
        }
        if (start < 0 || end > nums.length - 1) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return doSearch(nums, target, start, mid - 1);
        } else {
            return doSearch(nums, target, mid + 1, end);
        }

    }

    public int search2(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (high + low);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

}
