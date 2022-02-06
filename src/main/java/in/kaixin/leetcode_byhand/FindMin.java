package in.kaixin.leetcode_byhand;

public class FindMin {
    //    https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        for (int i = 0; i < nums.length / 2; i++) {
            if (nums[i] > nums[i + 1]) {
                return nums[i + 1];
            }
            if (nums[nums.length - 1 - i] < nums[nums.length - 2 - i]) {
                return nums[nums.length - 1 - i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        FindMin findMin = new FindMin();
        System.out.println(findMin.findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(findMin.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(findMin.findMin(new int[]{11, 13, 15, 17}));
    }
}
