package in.kaixin.leetcode_byhand.numbers;

public class PlusOne {
    //    https://leetcode.cn/problems/plus-one/?envType=daily-question&envId=2026-01-04
//    mid
    public int[] plusOne(int[] digits) {
        int one = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int v = digits[i] + one;
            if (v > 9) {
                digits[i] = 0;
            } else {
                digits[i] = v;
                one = 0;
                break;
            }
        }

        if (one == 1) {
            int[] arr = new int[digits.length + 1];
            arr[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                arr[i + 1] = digits[i];
            }
            return arr;
        } else {
            return digits;
        }

    }
}
