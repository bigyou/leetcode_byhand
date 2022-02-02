package in.kaixin.leetcode_byhand;

import java.util.HashMap;
import java.util.Map;

public class UniqPath {
    //    https://leetcode-cn.com/problems/unique-paths/
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int res = doUniqPath(0, 0, m - 1, n - 1, new HashMap<>());
        return res;

    }

    public int doUniqPath(int x, int y, int m, int n, Map<String, Integer> map) {
        if (x == m && y == n) {
            return 1;
        }
        String key = x + "_" + y;
        if (map.get(key) != null) {
            return map.get(key);
        }
        int res = 0;
        if (x < m && y < n) {
            res = doUniqPath(x + 1, y, m, n, map) + doUniqPath(x, y + 1, m, n, map);

        } else if (x < m) {
            res = doUniqPath(x + 1, y, m, n, map);

        } else if (y < n) {
            res = doUniqPath(x, y + 1, m, n, map);
        }
        map.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        UniqPath uniqPath = new UniqPath();
        System.out.println(uniqPath.uniquePaths(3, 7));
        System.out.println(uniqPath.uniquePaths(3, 3));
        System.out.println(uniqPath.uniquePaths(3, 2));
    }
}
