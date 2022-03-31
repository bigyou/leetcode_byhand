package in.kaixin.leetcode_byhand.numbers;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.List;

public class SelfDividingNumbers {
    //    https://leetcode-cn.com/problems/self-dividing-numbers/submissions/
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            if (canDivide(i)) {
                res.add(i);
            }
        }
        return res;
    }

    public boolean canDivide(int num) {
        int temp = num;
        while (temp > 0) {
            int mod = temp % 10;
            if (mod == 0 || num % mod != 0) {
                return false;
            }
            temp /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        SelfDividingNumbers selfDividingNumbers = new SelfDividingNumbers();
        System.out.println(JSON.toJSONString(selfDividingNumbers.selfDividingNumbers(1, 22)));
        System.out.println(JSON.toJSONString(selfDividingNumbers.selfDividingNumbers(47, 85)));
        System.out.println(JSON.toJSONString(selfDividingNumbers.selfDividingNumbers(24, 66)));
    }

}
