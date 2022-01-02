import java.util.*;

public class MaxLengthUnRepeatChar {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.trim() == "") {
            return 0;
        }
        int length = s.length();
        Integer maxLength = 0;
        Integer start = null;
        Map<String, Integer> unrepeatCharMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            String subStr = s.charAt(i) + "";
            if (!unrepeatCharMap.keySet().contains(subStr)) {
//                maxLength += 1;
                unrepeatCharMap.put(subStr, i);
                if (start == null) {
                    start = i;
                }
            } else {//discover repeat char
                Integer preIndex = unrepeatCharMap.get(subStr);
                maxLength = unrepeatCharMap.size() > maxLength ? unrepeatCharMap.size() : maxLength;
                Set<String> char2remove = new HashSet();
                for (String key : unrepeatCharMap.keySet()) {
                    Integer index = unrepeatCharMap.get(key);
                    if (index <= preIndex) {
                        char2remove.add(key);
                    }
                }
                for (String key : char2remove) {
                    unrepeatCharMap.remove(key);
                }
                unrepeatCharMap.put(subStr, i);

            }
        }
        maxLength = unrepeatCharMap.size() > maxLength ? unrepeatCharMap.size() : maxLength;

        return maxLength;

    }

    public static int lengthOfLongestSubstringupgrade(String s) {
        if (s == null || s.trim() == "") {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int length = s.length();
        Integer maxLength = 0;
        Integer start = null;
        Map<String, Integer> unrepeatCharMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            String subStr = s.charAt(i) + "";
            if (!unrepeatCharMap.keySet().contains(subStr)) {
//                maxLength += 1;
                unrepeatCharMap.put(subStr, i);
                if (start == null) {
                    start = i;
                }
            } else {//discover repeat char
                Integer preIndex = unrepeatCharMap.get(subStr);
                maxLength = unrepeatCharMap.size() > maxLength ? unrepeatCharMap.size() : maxLength;
                Iterator<Map.Entry<String, Integer>> iterator = unrepeatCharMap.entrySet().iterator();
                while (iterator.hasNext()) {
                    if (iterator.next().getValue() <= preIndex) {
                        iterator.remove();
                    }
                }
                unrepeatCharMap.put(subStr, i);

            }
        }
        maxLength = unrepeatCharMap.size() > maxLength ? unrepeatCharMap.size() : maxLength;

        return maxLength;

    }


    public static int lengthOfLongestSubstring5(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;

    }
    public static int lengthOfLongestSubstring4(String s) {
        if (s == null || s.equals( "")) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        Map<Character,Integer> charIndex =new HashMap<>();
        Integer start=0;
        Integer end=0;
        Integer maxLength=0;
        for (int i=0;i<s.length();i++){
            Character ch= s.charAt(i);
            if(!charIndex.keySet().contains(ch)){//没有发现重复的,将字符放入map里面并标记第一次出现的顺序
                end=i;
                charIndex.put(ch,i);
            }else {//发现重复的，找到上一次的重复index，将begin设置为index+1，并且计算当前的maxLength，
                //
                Integer preIndex= charIndex.get(ch);
                if(preIndex<start){
                    charIndex.put(ch,i);
                    end=i;
                    continue;
                }
                maxLength= end-start+1>maxLength?end-start+1:maxLength;
                start= preIndex+1;
                end=i;
                charIndex.put(ch,i);
            }

        }
        maxLength= end-start+1>maxLength?end-start+1:maxLength;
        return maxLength;

    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        Integer start = 0;
        Integer end = 0;
        Integer maxLength = 0;
        for (int i = 1; i < s.length(); i++) {
            String str = s.charAt(i) + "";
            Integer repeatIndex = find(s, start, end, str);
            if (repeatIndex == -1) {
                end = i;
                continue;
            } else {

                maxLength = end - start + 1 > maxLength ? end - start + 1 : maxLength;
                start = repeatIndex + 1;
                end = i;
            }
        }
        maxLength = end - start + 1 > maxLength ? end - start + 1 : maxLength;

        return maxLength;
    }

    public Integer find(String s, Integer start, Integer end, String c) {
        if (start > end) {
            return -1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (i < start) {
                continue;
            }
            if (i > end) {
                break;
            }
            String str = s.charAt(i) + "";
            if (str.equals(c)) {
                return i;
            }

        }
        return -1;
    }

    public static void main(String... args) {
//        Integer maxLength = lengthOfLongestSubstring("pwwkew");
//        Integer maxLength = lengthOfLongestSubstring2("bbbb");
        Integer maxLength = lengthOfLongestSubstring4("tmmzuxt");
        System.out.println(maxLength);
    }
}
