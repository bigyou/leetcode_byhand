package in.kaixin.leetcode_byhand.str;

import com.alibaba.fastjson.JSON;

import java.util.*;

public class FindSubstring {
    //    https://leetcode.cn/problems/substring-with-concatenation-of-all-words/description/
//    hard
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new LinkedList<>();
        int wordsLen = words[0].length() * words.length;
        int wordLen = words[0].length();
        Map<String, Integer> wordFreMap = new HashMap<>();
        if (wordsLen > s.length()) {
            return res;
        }

        Map<String, Integer> wordsFreMap = new HashMap<>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                wordsFreMap.put(word.charAt(i) + "", wordsFreMap.getOrDefault(word.charAt(i) + "", 0) + 1);
            }
            wordFreMap.put(word, wordFreMap.getOrDefault(word, 0) + 1);
        }
        Map<String, Integer> windowMap = new HashMap<>();
        for (int i = 0; i < wordsLen - 1; i++) {
            windowMap.put(s.charAt(i) + "", windowMap.getOrDefault(s.charAt(i) + "", 0) + 1);
        }
        for (int i = 0; i <= s.length() - wordsLen; i++) {
            String str = s.charAt(i + wordsLen - 1) + "";
            windowMap.put(str, windowMap.getOrDefault(str, 0) + 1);
            if (validate(windowMap, wordsFreMap)) {
                if (windowMap.keySet().size() == 1) {
                    res.add(i);

                }else {
                    boolean successChecked = check(s, words, i, wordFreMap);
                    if (successChecked) {
                        res.add(i);
                    }
                }

            }
            String head = s.charAt(i) + "";
            windowMap.put(head, windowMap.get(head) - 1);
            if (windowMap.get(head) == 0) {
                windowMap.remove(head);
            }
        }
        return res;
    }


    public boolean validate(Map<String, Integer> windowMap, Map<String, Integer> wordsFreMap) {
        if (windowMap.keySet().size() != wordsFreMap.keySet().size()) {
            return false;
        }
        for (String k : wordsFreMap.keySet()) {
            if (!wordsFreMap.get(k).equals(windowMap.get(k))) {
                return false;
            }
        }
        return true;
    }

    public boolean check(String s, String[] words, int start, Map<String, Integer> wordFreqMap) {
        Map<String, Integer> subStringFreqMap = new HashMap<>();
        int wordLen = words[0].length();
        for (int i = 0; i < words.length; i++) {
            String str = s.substring(start + i * wordLen, start + i * wordLen + wordLen);
            if (!wordFreqMap.containsKey(str)) {
                return false;
            } else {
                subStringFreqMap.put(str, subStringFreqMap.getOrDefault(str, 0) + 1);
                if (subStringFreqMap.get(str) > wordFreqMap.get(str)) {
                    return false;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        FindSubstring find = new FindSubstring();
        List<Integer> res = find.findSubstring("aaaaaaaa", new String[]{"a", "a"});
        System.out.println(JSON.toJSONString(res));
    }
}
