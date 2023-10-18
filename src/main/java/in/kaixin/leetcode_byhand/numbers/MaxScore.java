package in.kaixin.leetcode_byhand.numbers;

/**
 * @Author bigyou
 * @Create 2023/7/21 21:49
 */
public class MaxScore {
    public int maxScore(int[] cardPoints, int k) {
        long max = Long.MIN_VALUE;
        long tmp = 0;
        for (int i = cardPoints.length - k; i < cardPoints.length; i++) {
            tmp += cardPoints[i];
        }
        max = tmp;
        if (k == cardPoints.length) {
            return (int) max;
        }

        for (int i = cardPoints.length - k ; i < cardPoints.length ; i++) {
            tmp = tmp + cardPoints[(i + k) % cardPoints.length] - cardPoints[i];
            max = Math.max(max, tmp);
        }
        return (int) max;

    }

    public static void main(String[] args) {
        MaxScore s = new MaxScore();
        int o=0;
          o = s.maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3);
        System.out.println(o);
          o = s.maxScore(new int[]{7, 2, 3, 4, 5, 6, 1}, 3);
        System.out.println(o);
          o = s.maxScore(new int[]{7, 8, 3, 4, 5, 6, 1}, 3);
        System.out.println(o);
        o = s.maxScore(new int[]{1, 2, 9, 8, 12, 6, 1}, 3);
        System.out.println(o);
    }


}
