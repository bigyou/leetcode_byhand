package in.kaixin.leetcode_byhand.other;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            int index = i;
            while (index < s.length()) {
                sb.append(s.charAt(index));
                int next = index + (2 * (numRows - 1 - i));
                if (next < s.length() && next < index + 2 * numRows - 2 && next > index) {
                    sb.append(s.charAt(next));
                }
                index = index + (2 * numRows - 2);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion zigzagConversion = new ZigzagConversion();
        System.out.println(zigzagConversion.convert("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR"));
        System.out.println(zigzagConversion.convert("PAYPALISHIRING", 4).equals("PINALSIGYAHRPI"));
        System.out.println(zigzagConversion.convert("PAYPALISHIRING", 2));
        System.out.println(zigzagConversion.convert("PAYPALISHIRING", 1).equals("PAYPALISHIRING"));
    }
}
