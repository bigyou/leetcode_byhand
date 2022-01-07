package in.kaixin.leetcode_byhand.search;

public class SearchN {
    //https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
    public int search(int[] nums, int target) {
        if (nums[0] <= target) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] > target) {
                    return -1;
                } else if (nums[j] == target) {
                    return j;
                } else {
                    if (j == nums.length - 1) {
                        return -1;
                    } else {
                        if (nums[j] > nums[j + 1]) {
                            return -1;
                        }
                    }
                }

            }

        } else {//从后面开始查找
            for (int j = nums.length - 1; j >= 0; j--) {
                if (nums[j] < target) {//
                    return -1;
                } else if (nums[j] == target) {
                    return j;
                } else {
                    if (j == 0) {
                        return -1;//到最后一个了
                    } else {
                        if (nums[j - 1] > nums[j]) {//到边界了
                            return -1;
                        }
                    }
                }

            }
        }
        return -1;
    }


}
