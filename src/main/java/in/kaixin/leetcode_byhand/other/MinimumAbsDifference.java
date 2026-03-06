package in.kaixin.leetcode_byhand.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MinimumAbsDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new LinkedList<>();
        Integer minDiffer = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int differ = arr[i] - arr[i - 1];
            if (differ < minDiffer) {
                minDiffer = differ;
                res.clear();

            } else if (differ == minDiffer) {

            }
            if (minDiffer == differ) {
                List<Integer> list = new ArrayList<>(2);
                list.add(arr[i - 1]);
                list.add(arr[i]);
                res.add(list);
            }
        }
        return res;
    }
}
