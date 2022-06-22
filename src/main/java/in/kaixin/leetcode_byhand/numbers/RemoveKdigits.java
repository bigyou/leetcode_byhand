package in.kaixin.leetcode_byhand.numbers;

import java.util.*;

public class RemoveKdigits {
    //    https://leetcode-cn.com/problems/remove-k-digits/
    String min = null;

    public String removeKdigits2(String num, int k) { //这个做法会超出时间限制
        this.min = null;
        doSmall(num, k, k, new HashSet<>(), "");
        cleanAheadZero(min);
        return min;
    }


    public void doSmall(String num, int k, int left, Set<String> note, String path) {
        if (left == 0) {
            if (min == null) {
                min = num;
            } else {
                if (min.compareTo(num) > 0) {
                    min = num;
                }
            }
            note.add(path);
            return;
        }
        if (note.contains(path)) {//最小值肯定出现过了
            return;
        }
        for (int i = 0; i < num.length() - left + 1; i++) {
            doSmall(num.substring(0, i) + num.substring(i + 1, num.length()), k, left - 1, note, path + "_" + i);
        }

    }

    public String removeKdigits(String num, int k) {
        Deque<Character> singleRiseStack = new LinkedList<>();
        int i = 0;
        for (; i < num.length() ; i++) {
            char c = num.charAt(i);
            while (!singleRiseStack.isEmpty() && c < singleRiseStack.peekLast() && k > 0) {
                singleRiseStack.pollLast();
                k--;
            }
            singleRiseStack.offerLast(c);
        }
        StringBuilder sb = new StringBuilder();

        while (!singleRiseStack.isEmpty()) {
            sb.append(singleRiseStack.pollFirst());
        }
        String res = sb.toString();
        if ( k>0) {
            res = res.substring(0, res.length() - k);
        }

        res = cleanAheadZero(res);
        return res;
    }

    public String cleanAheadZero(String str) {
        while (str != null && str.startsWith("0") && str.length() > 1) {
            str = str.substring(1, str.length());
        }
        str = str == null || "".equals(str) ? "0" : str;
        return str;
    }

    public static void main(String[] args) {
        RemoveKdigits removeKdigits = new RemoveKdigits();
        System.out.println(removeKdigits.removeKdigits("10000", 1));
        System.out.println(removeKdigits.removeKdigits("1432219", 3));
        System.out.println(removeKdigits.removeKdigits("10", 2));
        System.out.println(removeKdigits.removeKdigits("4321", 2));
        System.out.println(removeKdigits.removeKdigits("112", 1));
        System.out.println(removeKdigits.removeKdigits("1173", 2));
    }


}
