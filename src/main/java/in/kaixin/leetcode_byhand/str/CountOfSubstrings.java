package in.kaixin.leetcode_byhand.str;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountOfSubstrings {

    public int countOfSubstrings(String word, int k) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        Map<Character, Integer> freq = new HashMap<>();
        int res = 0;
        int distance = k + 5;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (isYuanYin(c)) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
            if (i < distance-1) {
                continue;
            } else {
                if (valid(freq)) {
                    res++;
                }
                char pre = word.charAt(i - distance + 1);
                if (isYuanYin(pre)) {
                    freq.put(pre, freq.get(pre) - 1);
                }
            }
        }
        return res;
    }

    public boolean valid(Map<Character, Integer> freq) {
        return freq.getOrDefault('a', 0) == 1 && freq.getOrDefault('e', 0) == 1 && freq.getOrDefault('i', 0) == 1 && freq.getOrDefault('o', 0) == 1 && freq.getOrDefault('u', 0) == 1;
    }

    public boolean isYuanYin(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CountOfSubstrings c = new CountOfSubstrings();
        System.out.println(c.countOfSubstrings("iqeaouqi", 2));
    }

}
