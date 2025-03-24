package in.kaixin.leetcode_byhand.other;

public class EvenOddBit {
    //    https://leetcode.cn/problems/number-of-even-and-odd-bits/?envType=daily-question&envId=2025-02-20
//    easy
    public int[] evenOddBit(int n) {
        int flag = 0;
        int[] res = new int[2];
        while (n > 0) {
            if (n % 2 == 1) {
                if (flag % 2 == 0) {
                    res[0]+=1;
                } else {
                    res[1]+=1;
                }
            }
            flag++;
            n >>= 1;
        }
        return res;
    }
}
