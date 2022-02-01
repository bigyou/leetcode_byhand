package in.kaixin.leetcode_byhand;

public class SingleNumber {
    //    https://leetcode-cn.com/problems/single-number/
    public int singleNumber(int[] nums) {
        int v = 0;
        for (int num : nums) {
            v = v ^ num;
        }
        return v;
    }
}
