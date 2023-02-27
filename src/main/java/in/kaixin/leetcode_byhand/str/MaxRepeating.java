package in.kaixin.leetcode_byhand.str;

public class MaxRepeating {
    //https://leetcode.cn/problems/maximum-repeating-substring/
//     有更好的kmp算法
    public int maxRepeating(String sequence, String word) {
        int max = 0;
        for (int i = 0; i <= sequence.length() - word.length() && i <= sequence.length() - max * word.length(); i++) {
            int loop = 0;
            while (word.length() * loop + i + word.length() <= sequence.length()) {
                int start = loop * word.length() + i;
                String s = sequence.substring(start, start + word.length());
                if (s.equals(word)) {
                    loop++;
                } else {
                    max = loop > max ? loop : max;
                    break;
                }
            }
            max = loop > max ? loop : max;
        }
        return max;
    }

    public static void main(String[] args) {
        MaxRepeating maxRepeating = new MaxRepeating();
        System.out.println(maxRepeating.maxRepeating("abababa", "ba"));
        System.out.println(maxRepeating.maxRepeating("ababa", "ab"));
    }
}
