package in.kaixin.leetcode_byhand.other;

public class DivisorSubstrings {
    //    https://leetcode.cn/problems/find-the-k-beauty-of-a-number/?envType=daily-question&envId=2025-03-10
//easy
    public int divisorSubstrings(int num, int k) {
        String str = num + "";
        if (k == str.length()) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i <= str.length() - k; i++) {
            int v = Integer.parseInt(str.substring(i, k + i));
            if (v == 0) {
                continue;
            }
            if (num % v == 0) {
                res++;
            }
        }
        return res;
    }
}
