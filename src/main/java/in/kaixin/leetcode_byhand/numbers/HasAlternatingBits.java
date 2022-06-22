package in.kaixin.leetcode_byhand.numbers;

public class HasAlternatingBits {
    //https://leetcode-cn.com/problems/binary-number-with-alternating-bits/
    public boolean hasAlternatingBits(int n) {
        boolean valide = bit(n, n % 2);
        return valide;
    }


    public boolean bit(int n, Integer expect) {
        if (expect == n % 2) {
            if (n > 1) {
                return bit(n / 2, expect ^ 1);
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        HasAlternatingBits hasAlternatingBits = new HasAlternatingBits();
        System.out.println(hasAlternatingBits.hasAlternatingBits(0));
        System.out.println(hasAlternatingBits.hasAlternatingBits(1));
        System.out.println(hasAlternatingBits.hasAlternatingBits(5));
        System.out.println(hasAlternatingBits.hasAlternatingBits(7));
        System.out.println(hasAlternatingBits.hasAlternatingBits(11));
    }
}
