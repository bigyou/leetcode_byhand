package in.kaixin.leetcode_byhand;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UncommonFromSentences {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] sArr = s1.split(" ");
        String[] s2Arr = s2.split(" ");
        Map<String, Integer> sMap = new HashMap<>();
        for (String s : sArr) {
            sMap.put(s, sMap.getOrDefault(s, 0) + 1);
        }

        for (String s : s2Arr) {
            sMap.put(s, sMap.getOrDefault(s, 0) + 1);
        }
        Set<String> res = new HashSet<>();
        for (String s : sMap.keySet()) {
            if (sMap.get(s) == 1) {
                res.add(s);
            }
        }
        String[] strings = res.toArray(new String[]{});
        return strings;
    }
}
