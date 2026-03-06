package in.kaixin.leetcode_byhand.numbers;
//https://leetcode.cn/problems/smallest-number-with-all-set-bits/?envType=daily-question&envId=2025-10-29
public class SmallestNumber {
    public int smallestNumber(int n) {
        int v = 2;
        while (n >= v) {
            v = 2*v;
        }
        return v-1;
    }

}
