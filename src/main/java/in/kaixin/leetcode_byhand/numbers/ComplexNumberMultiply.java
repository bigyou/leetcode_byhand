package in.kaixin.leetcode_byhand.numbers;

import in.kaixin.leetcode_byhand.CombinationSum;

public class ComplexNumberMultiply {
    //    https://leetcode-cn.com/problems/complex-number-multiplication/
    public String complexNumberMultiply(String num1, String num2) {
        VEntity one = parse(num1);
        VEntity two = parse(num2);
        String real = one.getReal() * two.getReal() - one.getVirtual() * two.getVirtual() + "";
        String virtual = one.getReal() * two.getVirtual() + one.virtual * two.getReal() + "i";
        return real + "+" + virtual;
    }


    public VEntity parse(String num) {
        VEntity value = new VEntity();
        char last = num.charAt(num.length() - 1);
        if (last == 'i') {//有虚数部分
            value.virtual = 1;
            int j = num.length() - 2;
            for (; j >= 0; j--) {
                char c = num.charAt(j);
                if (c == '+' || c == '-') {
                    break;
                }
            }

            if (j >= 0) {

                String sub = num.substring(j, num.length() - 1);
                if ("-".equals(sub)) {
                    value.virtual = -1;
                } else if ("+".equals(sub)) {
                } else {
                    value.virtual = Integer.parseInt(sub);
                }
            }
            for (; j >= 0; j--) {
                char c = num.charAt(j);
                if (c == '+' || c == '-') {
                    continue;
                } else {
                    j = j + 1;
                    break;
                }
            }
            if (j > 0) {

                value.real = Integer.parseInt(num.substring(0, j));
            }
        } else {//只有整数部分。
            value.real = Integer.parseInt(num);

        }
        return value;
    }

//    public static void main(String[] args) {
//        ComplexNumberMultiply complexNumberMultiply = new ComplexNumberMultiply();
//        System.out.println(complexNumberMultiply.complexNumberMultiply("1+-1i", "1+-1i"));
//        System.out.println(complexNumberMultiply.complexNumberMultiply("1+1i", "1+1i"));
//    }
}


class VEntity {
    int real = 0; //实数
    int virtual = 0;//虚数

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getVirtual() {
        return virtual;
    }

    public void setVirtual(int virtual) {
        this.virtual = virtual;
    }
}
