package in.kaixin.leetcode_byhand.numbers;


import java.util.ArrayList;

public class NumberOfPowerfulInt {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        int len = s.length();
        int cnt = len;
        while (cnt > 0) {
            start = start / 10;
            finish = finish / 10;
            cnt--;
        }
        String finishStr = finish + "";
        String startStr = start + "";

        int[] finishArr = new int[finishStr.length()];
        int[] startArr = new int[finishStr.length()];
        for (int i = 0; i < finishStr.length(); i++) {
            finishArr[i] = finishStr.charAt(i) - '0';
        }

        for (int i = 0; i < startStr.length(); i++) {
            startArr[startArr.length - startStr.length() + i] = startStr.charAt(i) - '0';
        }
        long right = caculate(finish, limit, finishArr);
        long left = caculate(start, limit, startArr);
        long res = right - left;

        return res;

    }

    long caculate(long finish, int limit, int[] finishArr) {
        int res = 0;
        boolean flag = false;
        for (int i = 0; i < finishArr.length; i++) {
            int v = finishArr[i];
            int step = 0;
            if (v <= limit) {
                step = v;
            } else {
                flag = true;
                step = limit+1;
            }
            if (res == 0) {
                res = step;
            } else {
                res=res*(limit+1);
            }
            if(!flag ){
                res+=step;
            }
        }


        return res;
    }

    public static void main(String[] args) {
        NumberOfPowerfulInt n = new NumberOfPowerfulInt();
        long res = n.numberOfPowerfulInt(1, 6000, 4, "124");
        System.out.println(res);
    }
}
