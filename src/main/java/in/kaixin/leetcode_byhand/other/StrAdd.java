package in.kaixin.leetcode_byhand.other;


import java.util.LinkedList;
import java.util.List;

public class StrAdd {
    //    https://leetcode-cn.com/problems/add-strings/
    public static String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) {
            return num2;
        }
        if (num2 == null || num2.length() == 0) {
            return num1;
        }
        int cursor1 = num1.length() - 1;
        int cursor2 = num2.length() - 1;
        int upgrade = 0;
        List<Integer> list = new LinkedList<>();
        while (cursor1 >= 0 && cursor2 >= 0) {
            int one = num1.charAt(cursor1) - '0';
            int two = num2.charAt(cursor2) - '0';
            int v = one + two + upgrade;
            upgrade = v / 10;
            v = v % 10;
            list.add(v);
            cursor1--;
            cursor2--;
        }

        while (cursor1 >= 0) {
            int one = num1.charAt(cursor1) - '0';
            int v = one + upgrade;
            upgrade = v / 10;
            v = v % 10;
            list.add(v);
            cursor1--;
        }
        while (cursor2 >= 0) {
            int two = num2.charAt(cursor2) - '0';
            int v = two + upgrade;
            upgrade = v / 10;
            v = v % 10;
            list.add(v);
            cursor2--;
        }
        if (upgrade != 0) {
            list.add(upgrade);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("", "123"));
    }
}
