package in.kaixin.leetcode_byhand.other;

public class LongestPalindromicSubstring {
    //    https://leetcode-cn.com/problems/longest-palindromic-substring/
    public String longestPalindrome(String s) {
        int[] nums = new int[s.length()];
        dolog(s.toCharArray(), nums, nums.length - 1);
        int length = 0;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (length < nums[i]) {
                length = nums[i];
                index = i;
            }
        }
        String res = s.substring(index - length + 1, index + 1);
        return res;
    }

    public int dolog(char[] s, int[] num, int index) {
        if (index == 0) {
            num[index] = 1;
            return 1;
        }
        int beforeLength = dolog(s, num, index - 1);
        int length = getSubstrLength(s, beforeLength, index);

        num[index] = length;
        return length;
    }

    public int getSubstrLength(char[] s, int beforeLength, int index) {
        int length = 1;
        if (index - beforeLength - 1 >= 0) {
            if (s[index - beforeLength - 1] == s[index]) {
                length = beforeLength + 2;
                return length;
            }
        }

        for (int i = index - beforeLength; i <= index; i++) {
            boolean find = true;
            for (int j = 0; j <= (index - i + 1) / 2; j++) {
                if (s[i + j] != s[index - j]) {
                    find = false;
                    break;
                }
            }
            if (find) {
                length = index - i + 1;
                break;
            }
        }


        return length;

    }

    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        String res = longestPalindromicSubstring.longestPalindrome("bacabab");
        System.out.println(res);
    }
}
