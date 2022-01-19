package in.kaixin.leetcode_byhand.other;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {
    //    https://leetcode-cn.com/problems/climbing-stairs/
    public int climbStairs(int n) {
        Map<Integer, Integer> note = new HashMap<>();
        return climb(n, note);

    }

    public int climb(int n, Map<Integer, Integer> note) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (note.get(n) != null) {
            return note.get(n);
        } else {
            int i = climb(n - 1, note) + climb(n - 2, note);
            note.put(n, i);
            return i;
        }
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        System.out.println(climbStairs.climbStairs(5));
    }
}
