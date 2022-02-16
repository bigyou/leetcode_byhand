package in.kaixin.leetcode_byhand;

import java.util.HashMap;
import java.util.Map;

public class NumSquares {
    public int numSquares(int n) {
        return numSq(n, new HashMap<>());

    }

    public int numSq(int v, Map<Integer, Integer> map) {
        if (v < 4) {
            map.put(v, v);
            return v;
        }
        if (map.get(v) != null) {
            return map.get(v);
        }
        int sq = (int) Math.sqrt(v);
        Integer cnt = Integer.MAX_VALUE;

        for (int i = sq; i >= 1; i--) {
            int tempSqr = i * i;
            for (int j = v / tempSqr; j >=1; j--) {
                cnt = Math.min(j + numSq(v - tempSqr * j, map), cnt);
            }
            if (tempSqr < v / cnt) {
                break;
            }
        }
        map.put(v, cnt);
        return cnt;

    }

    public static void main(String[] args) {
        NumSquares numSquares = new NumSquares();
        System.out.println(numSquares.numSquares(18));
    }


}
