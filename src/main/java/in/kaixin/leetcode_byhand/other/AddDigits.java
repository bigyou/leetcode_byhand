package in.kaixin.leetcode_byhand.other;

public class AddDigits {
    //    https://leetcode-cn.com/problems/add-digits/
    public int addDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
            if (num == 0 && sum > 9) {
                num = sum;
                sum = 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        AddDigits addDigits = new AddDigits();
        System.out.println(addDigits.addDigits(3));
    }
}
