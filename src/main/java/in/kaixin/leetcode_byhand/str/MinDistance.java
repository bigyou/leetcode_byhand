package in.kaixin.leetcode_byhand.str;

public class MinDistance {
    //    https://leetcode-cn.com/problems/edit-distance/
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
//        dp[i][j] 代表word1的前i个字符和 word2前j个字符之间的距离。
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                int v = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    v = Math.min(v, dp[i - 1][j - 1]);
                } else {
                    v = Math.min(v, dp[i - 1][j - 1] + 1);
                }
                dp[i][j] = v;
            }
        }
        return dp[word1.length()][word2.length()];

    }

    public static void main(String[] args) {
        MinDistance minDistance = new MinDistance();
        System.out.println(minDistance.minDistance("horse", ""));
        System.out.println(minDistance.minDistance("horse", "ros"));
        System.out.println(minDistance.minDistance("intention", "execution"));
    }


}
