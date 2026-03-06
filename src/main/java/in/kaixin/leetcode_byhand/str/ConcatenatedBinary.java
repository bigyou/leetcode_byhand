package in.kaixin.leetcode_byhand.str;

public class ConcatenatedBinary {
    public int concatenatedBinary(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) {
            res <<= getN(i);
            res = (res + i) % 1000000007;
        }
        return Math.toIntExact(res);
    }

    public int getN(int n) {
        if (n < 2) {
            return 1;
        } else if (n < 4) {
            return 2;
        } else if (n < 8) {
            return 3;
        } else if (n < 16) {
            return 4;
        } else if (n < 32) {
            return 5;
        } else if (n < 64) {
            return 6;
        } else if (n < 128) {
            return 7;
        } else if (n < 256) {
            return 8;
        } else if (n < 512) {
            return 9;
        } else if (n < 1024) {
            return 10;
        } else if (n < 2048) {
            return 11;
        } else if (n < 4096) {
            return 12;
        } else if (n < 8192) {
            return 13;
        } else if (n < 16384) {
            return 14;
        }else if (n < 32768) {
            return 15;
        }else if (n < 65536) {
            return 16;
        }else if (n < 131072) {
            return 17;
        }

        return 1;
    }

    public static void main(String[] args) {
        ConcatenatedBinary b = new ConcatenatedBinary();
        System.out.println(b.concatenatedBinary(1));
        System.out.println(b.concatenatedBinary(3));
        System.out.println(b.concatenatedBinary(12));
        System.out.println(b.concatenatedBinary(8933));//109884214
    }
}
