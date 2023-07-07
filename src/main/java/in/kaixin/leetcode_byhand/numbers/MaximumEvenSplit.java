package in.kaixin.leetcode_byhand.numbers;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author bigyou
 * @Create 2023/7/6 18:55
 */
public class MaximumEvenSplit {
    public List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 == 1) {
            return new LinkedList<>();
        }
        long left = finalSum;
        long maxv = 0;//记录放入list的最大值，开始为0
        List<Long> list = new LinkedList<>();
        while (left > 0) {
            if (left >= maxv + 2) {
                maxv += 2;
                list.add(maxv);

                left -= maxv;
            } else {
                long last = maxv + left;
                list.set(list.size() - 1, last);
                left = 0;
            }
            if (left == 0) {
                break;
            }
        }
        return list;
    }
}
