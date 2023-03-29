package in.kaixin.leetcode_byhand.str;

//https://leetcode.cn/problems/count-sorted-vowel-strings/
public class CountVowelStrings {

    public int countVowelStrings(int n) {
//        f(n) = f(n - 1)
        int[] cntArr = new int[5];
        cntArr[0] = 1;
        cntArr[1] = 1;
        cntArr[2] = 1;
        cntArr[3] = 1;
        cntArr[4] = 1;
        for (int i = 0; i < n - 1; i++) {
            cntArr[0] = cntArr[0] + cntArr[1] + cntArr[2] + cntArr[3] + cntArr[4];
            cntArr[1] = cntArr[1] + cntArr[2] + cntArr[3] + cntArr[4];
            cntArr[2] = cntArr[2] + cntArr[3] + cntArr[4];
            cntArr[3] = cntArr[3] + cntArr[4];
            cntArr[4] = cntArr[4];

        }
        int res = cntArr[0] + cntArr[1] + cntArr[2] + cntArr[3] + cntArr[4];
        return res;


    }

    public static void main(String[] args) {
        CountVowelStrings s = new CountVowelStrings();
        System.out.println(s.countVowelStrings(1));
        System.out.println(s.countVowelStrings(2));
        System.out.println(s.countVowelStrings(3));
        System.out.println(s.countVowelStrings(33));
    }
}
