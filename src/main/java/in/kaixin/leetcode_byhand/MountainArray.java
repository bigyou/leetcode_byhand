package in.kaixin.leetcode_byhand;

public class MountainArray {
    int[] nums;
    int i=0;

    public int get(int index) {
        System.out.println(i++);
        return nums[index];
    }

    public int length() {
        return nums.length;
    }

    public MountainArray(int[] nums) {
        this.nums = nums;
    }
}
