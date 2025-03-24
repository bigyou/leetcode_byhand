package in.kaixin.leetcode_byhand.other;

import java.util.List;

public class MaxDistance {
    public int maxDistance(List<List<Integer>> arrays) {
        Integer premax = null;
        Integer premin = null;
        Integer res = Integer.MIN_VALUE;
        for (List<Integer> array : arrays) {
            int max = array.get(array.size() - 1);
            int min = array.get(0);

            if (premax == null) {
                premax = max;
                premin = min;
            } else {
                res = Math.max(premax - min, res);
                res = Math.max(max - premin, res);
                premax = Math.max(premax, max);
                premin = Math.min(premin, min);
            }
        }
        return res;
    }
}
