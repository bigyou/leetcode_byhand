package in.kaixin.leetcode_byhand.other;

import java.util.ArrayList;

public class MinimumCost4SameString {
    //    https://leetcode.cn/problems/minimum-cost-to-make-all-characters-equal/?envType=daily-question&envId=2025-03-27
    public long minimumCost(String s) {
        ArrayList<Long> startList = new ArrayList<>();
        ArrayList<Long> endList = new ArrayList<>();
        if (s.length() <= 1) {
            return 0;
        }
        char pre = s.charAt(0);
        long preSum = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != pre) {
                pre = c;

                long sum = startList.size() > 0 ? startList.get(startList.size() - 1) + i : i;
                startList.add(sum);
            }
        }
        if (startList.size() == 0) {
            return 0;
        }
        startList.add(startList.get(startList.size() - 1) + preSum + s.length());

        pre = s.charAt(s.length() - 1);
        preSum = 0;
        for (int i = s.length() - 2; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != pre) {
                pre = c;
                long sum = endList.size() > 0 ? endList.get(0) + s.length() - 1 - i : s.length() - 1 - i;
                endList.add(0, sum);
            }
        }
        endList.add(0, endList.get(0) + s.length());
        long res = Long.MAX_VALUE;
        for (int i = 0; i <  startList.size() ; i++) {
            res = Math.min(res, startList.get(i) + getNext2Value(endList, i + 2));
            res = Math.min(res, endList.get(endList.size() - 1 - i) + getNext2Value(startList, endList.size() - 1 - i - 2));
        }
        return res;
    }

    public long getNext2Value(ArrayList<Long> startList, int idx) {
        if (idx >= 0 && idx < startList.size()) {
            return startList.get(idx);
        }
        return 0;
    }

    public static void main(String[] args) {
        MinimumCost4SameString m = new MinimumCost4SameString();
//        System.out.println(m.minimumCost("010101"));
//        System.out.println(m.minimumCost("000000001"));
        System.out.println(m.minimumCost("000000101"));
    }
}
