package in.kaixin.leetcode_byhand;

import java.util.HashMap;
import java.util.Map;

public class SuperEggDrop {
    //TODO 有性能问题，需要剪枝
    public int superEggDrop(int k, int n) {
//        return doDrop(k, n, new HashMap<>());
        return doDrop2(k, n);
    }

    public int doDrop(int k, int n, Map<String, Integer> map) {
        if (k == 1) {
            map.put(n + "_" + k, n);
            return n;
        }
        if (n <= 1) {
            map.put(n + "_" + k, n);
            return n;
        }
        Integer cnt = map.get(n + "_" + k);
        if (cnt != null) {
            return cnt;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            res = Math.min(Math.max(doDrop(k - 1, i - 1, map), doDrop(k, n - i, map)) + 1, res);
        }
        map.put(n + "_" + k, res);
        return res;
    }

    public int doDrop2(int k, int n) {
        int[][] data = new int[k + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            data[1][i] = i;
        }

        int i = 1;
        for (; data[k][i] < n; i++) {
            for (int j = 1; j <= k; j++) {
                data[j][i] = data[j - 1][i - 1] + data[j][i - 1] + 1;
            }

        }

        return i;
    }

    public static void main(String[] args) {
        SuperEggDrop superEggDrop = new SuperEggDrop();
        System.out.println(superEggDrop.superEggDrop(4, 100));
    }

}
