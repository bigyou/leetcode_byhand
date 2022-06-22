package in.kaixin.leetcode_byhand.str;

public class ReverseWords {
    //    https://leetcode-cn.com/problems/reverse-words-in-a-string/
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int right = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (right != -1) {
                    sb.append(s.substring(i + 1, right + 1)).append(" ");
                    right = -1;
                }
            } else {
                if (right == -1) {
                    right = i;
                }
            }
        }
        if (right != -1) {
            sb.append(s.substring(0, right + 1));
        }
        String str = sb.toString();
        if (str.endsWith(" ")) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.reverseWords(" hello my   name is   kate "));
        System.out.println(reverseWords.reverseWords("  hello world  "));
        System.out.println(reverseWords.reverseWords("a good   example"));
        System.out.println(reverseWords.reverseWords("the sky is blue"));
    }
}
