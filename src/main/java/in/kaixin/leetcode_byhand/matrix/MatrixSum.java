package in.kaixin.leetcode_byhand.matrix;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @Author bigyou
 * @Create 2023/7/5 19:18
 */
public class MatrixSum {
    //    mid
//    https://leetcode.cn/problems/sum-in-a-matrix/
    public int matrixSum(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            int[] ints = Arrays.stream(nums[i]).sorted().toArray();
            nums[i] = ints;
        }
        for (int i = 0; i < nums[0].length; i++) {
            int[] ints = new int[nums.length];
            for (int j = 0; j < nums.length; j++) {
                ints[j] = nums[j][i];
            }
            ints = Arrays.stream(ints).sorted().toArray();
            for (int j = 0; j < nums.length; j++) {
                nums[j][i] = ints[j];
            }

        }
        int cnt = 0;
        for (int j = 0; j < nums[0].length; j++) {
            cnt += nums[nums.length - 1][j];
        }
        return cnt;
    }

}
