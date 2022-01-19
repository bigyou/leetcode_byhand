package in.kaixin.leetcode_byhand.other;

import java.util.HashMap;
import java.util.Map;

public class SlowestKey {
//    https://leetcode-cn.com/problems/slowest-key/

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        if (releaseTimes == null) {
            return ' ';
        }
        if (releaseTimes.length == 1) {
            return keysPressed.toCharArray()[0];
        }
        char[] chars = keysPressed.toCharArray();
        int max = releaseTimes[0];
        Character c = chars[0];
        for (int i = 1; i < releaseTimes.length; i++) {
            int cost = releaseTimes[i] - releaseTimes[i - 1];
            if (cost > max) {
                max = cost;
                c = chars[i];
            } else if (cost == max) {
                c = c > chars[i] ? c : chars[i];
            } else {
                continue;
            }
        }
        return c;
    }

}

