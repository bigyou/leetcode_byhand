package in.kaixin.leetcode_byhand.numbers;

public class MaxConsecutiveAnswers {
//    https://leetcode-cn.com/problems/maximize-the-confusion-of-an-exam/


    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] chars = answerKey.toCharArray();
        if (k >= chars.length / 2) {
            return chars.length;
        }
        int maxLength = Math.max(doWindowMove(chars, 'T', 0, 0, k), doWindowMove(chars, 'F', 0, 0, k));
        return maxLength;
    }

    public int doWindowMove(char[] answerKey, char c, int left, int right, int k) {
        int maxLength = 0;
        while (right < answerKey.length) {
            while (k > 0 && right < answerKey.length) {
                if (answerKey[right] != c) {
                    k--;
                }
                right++;
            }
            while (right < answerKey.length) {
                if (answerKey[right] == c) {
                    right++;
                } else {
                    break;
                }
            }
            maxLength = Math.max(maxLength, right - left);
            while (k <= 0) {
                if (answerKey[left] != c) {
                    k++;
                }
                left++;
            }
        }
        maxLength = Math.max(maxLength, right - left);
        return maxLength;
    }

    public static void main(String[] args) {
        MaxConsecutiveAnswers maxConsecutiveAnswers = new MaxConsecutiveAnswers();
        System.out.println(maxConsecutiveAnswers.maxConsecutiveAnswers("TTFF", 2));
        System.out.println(maxConsecutiveAnswers.maxConsecutiveAnswers("TFFT", 1));
        System.out.println(maxConsecutiveAnswers.maxConsecutiveAnswers("TTFTTFTT", 1));
        System.out.println(maxConsecutiveAnswers.maxConsecutiveAnswers("F", 1));
        System.out.println(maxConsecutiveAnswers.maxConsecutiveAnswers("FT", 2));
        System.out.println(maxConsecutiveAnswers.maxConsecutiveAnswers("TTTTTFTFFT", 2));
    }

}
