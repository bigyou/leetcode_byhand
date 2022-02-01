package in.kaixin.leetcode_byhand;

import com.sun.deploy.util.StringUtils;

import java.util.LinkedList;
import java.util.List;

public class MutlpString {
    //    https://leetcode-cn.com/problems/multiply-strings/
    public String caculate(String num1, String num2) {
        if (num1 == null || num2 == null || num1 == "" || num2 == "") {
            return "";
        }
        if (num1.equals("0") || num2.equals("0")) {//如果有值是"0"那么直接返回0
            return "0";
        }
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int forward = 0;
        StringBuffer sb = new StringBuffer();
        List<Integer> res = new LinkedList<>();
        int l = c1.length + c2.length - 1;//不包括最高位的进位，这里需要计算多少个位置 例如3*3的乘法，不包括进位的话 最高位应该是 3+3-1
        for (int i = 0; i < l; i++) {//从个位开始计算每一位的值
            int v = forward;//进位
            for (int j = 0; j <= i; j++) {//
                int v1 = getV(c1, j);
                int v2 = getV(c2, i - j);
                v += v1 * v2;

            }
            res.add(v % 10);//
            forward = v / 10;//获取进位是什么

        }
        if (forward > 0) {
            res.add(forward);
        }
        for (int i = res.size() - 1; i >= 0; i--) {
            sb.append(res.get(i));
        }
        return sb.toString();

    }

    /**
     * 这里是在获取字符串对应序列的值
     *
     * @param c
     * @param index
     * @return
     */
    public int getV(char[] c, int index) {
        if (c == null) {
            return 0;
        }
        if (index < c.length && index >= 0) {
            return c[c.length - 1 - index] - '0';//这里逆序在获取对应位置上的值
        }
        return 0;//如果越位了直接返回0
    }

    public static void main(String[] args) {
        MutlpString mutlpString = new MutlpString();
        System.out.println(mutlpString.caculate("123", "456"));
    }
}
