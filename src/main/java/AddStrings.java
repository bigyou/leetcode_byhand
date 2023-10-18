/**
 * @Author bigyou
 * @Create 2023/7/17 19:19
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        int flag = 0;
        int length = num1.length() > num2.length() ? num1.length() : num2.length();
        int i = 0;
        String res = "";
        StringBuffer sb = new StringBuffer();
        while (i < length) {
            int v1 = i > num1.length() - 1 ? 0 : num1.charAt(num1.length() - i - 1) - '0';
            int v2 = i > num2.length() - 1 ? 0 : num2.charAt(num2.length() - i - 1) - '0';
            int sum = v1 + v2 + flag;
            flag = sum > 9 ? 1 : 0;
            sb.append(sum % 10);
            i++;
        }
        if (flag > 0) {
            sb.append(flag);
        }
        res = sb.reverse().toString();
        return res;
    }

    public static void main(String[] args) {
        AddStrings a = new AddStrings();
        System.out.println(a.addStrings("11", "123"));
//        System.out.println(a.addStrings("1", "9"));
    }
}
