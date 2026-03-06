package in.kaixin.leetcode_byhand.str;

public class MinOperations {
    //    https://leetcode.cn/problems/minimum-changes-to-make-alternating-binary-string/?envType=daily-question&envId=2026-03-05
//    easy
    public int minOperations(String s) {
        int cnt = 0;
        int flag=0;
        for (int i = 0; i < s.length(); i++) {
            char ch =s.charAt(i);
            if (s.charAt(i) -'0' !=flag) {
                cnt++;
            }
            flag ^=1;


        }
        return Math.min(cnt,s.length()-cnt);

    }
}
