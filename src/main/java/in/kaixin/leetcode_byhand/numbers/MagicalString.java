package in.kaixin.leetcode_byhand.numbers;

public class MagicalString {
//    https://leetcode.cn/problems/magical-string/

    public int magicalString(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int cnt = 0;
        int[] arr = new int[n];
        int curIndex = 0;
        int left = 1;
        int v = 1;
        for (int i = 0; i < n; i++) {
//            if (left == 0) {
//                curIndex++;
//                left = arr[curIndex];
//                if (v == 1) {
//                    v = 2;
//                } else {
//                    v = 1;
//                }
//
//            }
            arr[i] = v;
            left--;
            if (v == 1) {
                cnt++;
            }
            if (left == 0) {
                curIndex++;
                left = arr[curIndex];
                if (v == 1) {
                    v = 2;
                } else {
                    v = 1;
                }
                if (left == 0) {
                    left = v;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        MagicalString magicalString = new MagicalString();
        System.out.println(magicalString.magicalString(1));
        System.out.println(magicalString.magicalString(19));
//        1221121221221121122
        System.out.println(magicalString.magicalString(8));
    }


}
