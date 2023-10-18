package in.kaixin.leetcode_byhand.numbers;

import java.util.PriorityQueue;

/**
 * @Author bigyou
 * @Create 2023/10/18 10:28
 */
public class MaxKelements {
    //    https://leetcode.cn/problems/maximal-score-after-applying-k-operations/?envType=daily-question&envId=2023-10-18
//    mid
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        long res = 0;
        for (int i = 0; i < k; i++) {
            Integer maxInQ = queue.poll();
            double v = Math.ceil(maxInQ / 3.0);
            queue.add((int) v);
            res += maxInQ;
        }
        return res;
    }
}
