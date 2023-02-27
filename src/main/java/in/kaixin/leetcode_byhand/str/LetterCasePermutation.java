package in.kaixin.leetcode_byhand.str;

import com.alibaba.fastjson.JSON;

import java.util.*;

public class LetterCasePermutation {
    //    https://leetcode.cn/problems/letter-case-permutation/
    public List<String> letterCasePermutation(String s) {
//        int cnt = 0;
        List<Integer> indexList = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                indexList.add(i);
            }
        }
        List<String> res = new LinkedList<>();
        if (indexList.size() == 0) {
            res.add(s);
            return res;
        }

        Deque<String> deque = new LinkedList<>();
        int pre = -1;
        for (int i = 0; i < indexList.size(); i++) {
            String sub = s.substring(pre + 1, indexList.get(i));
            pre = indexList.get(i);
            String subA = sub + s.charAt(indexList.get(i));
            String subB = sub + convert2OppositeChar(s.charAt(indexList.get(i)));
            if (deque.size() == 0) {
                deque.addFirst(subA);
                deque.addFirst(subB);
            } else {
                int len = indexList.get(i);
                while (deque.peekLast().length() < len) {
                    String next = deque.pollLast();
                    deque.addFirst(next + subA);
                    deque.addFirst(next + subB);
                }
            }
        }
        return res;
    }

    public String convert2OppositeChar(char c) {
        if (c >= 'a' && c <= 'z') {
            return (c + "").toUpperCase();
        } else {
            return (c + "").toLowerCase();
        }
    }

    public static void main(String[] args) {
        LetterCasePermutation letterCasePermutation = new LetterCasePermutation();
        System.out.println(JSON.toJSONString(letterCasePermutation.letterCasePermutation("a1b2")));
    }


}
