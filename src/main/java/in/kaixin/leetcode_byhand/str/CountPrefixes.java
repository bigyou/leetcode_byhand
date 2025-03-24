package in.kaixin.leetcode_byhand.str;

import java.util.HashMap;
import java.util.Map;

public class CountPrefixes {
    public int countPrefixes(String[] words, String s) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            freqMap.put(str, freqMap.getOrDefault(str, 0) + 1);
        }
        String subStr = "";
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            subStr = subStr + s.charAt(i);
            res += freqMap.getOrDefault(subStr, 0);
        }
        return res;

    }

}
