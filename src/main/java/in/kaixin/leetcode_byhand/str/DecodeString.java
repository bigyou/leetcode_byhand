package in.kaixin.leetcode_byhand.str;


import java.util.Stack;

public class DecodeString {
    //    https://leetcode-cn.com/problems/decode-string/
    public String decodeString(String s) {
        Stack<String> strStack = new Stack<>();
        Stack<Integer> repeat = new Stack<>();
        StringBuffer sb = new StringBuffer();
        Integer left = null;
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i);
            int type = getType(c);
            if (type == 0) {//字符
                if (repeat.isEmpty()) {
                    sb.append(c);
                } else {
                    if (left == null) {
                        strStack.push(strStack.pop() + c);
                    }
                }

            } else if (type == -1) {//左括号
                left = i + 1;
            } else if (type == 1) {//右括号
                if (left != null) { //非嵌套的右括号
                    String substring = s.substring(left, i);
                    left = null;
                    String str = getString(substring, repeat.pop());
                    if (repeat.isEmpty()) {//2[aaa]
                        sb.append(str);
                    } else {//a2[ab3[c]]
                        str = strStack.pop() + str;
                        strStack.push(str);
                    }

                } else {//嵌套的右括号
                    String str = getString(strStack.pop(), repeat.pop());
                    if (repeat.isEmpty()) {
                        sb.append(str);
                    } else {
                        strStack.push(strStack.pop() + str);
                    }
                }
            } else if (type == 2) {//数字
                if (left != null) {
                    String substring = s.substring(left, i);
                    left = null;
                    strStack.push(substring);
                }
                int j = i;
                for (; j < s.length(); j++) {
                    if (getType(s.charAt(j)) == 2) {
                        continue;
                    } else {
                        break;
                    }
                }
                int times = Integer.parseInt(s.substring(i, j));
                repeat.push(times);
                i = j;
                continue;
            }
            i++;
        }
        String res = sb.toString();
        System.out.println(res);
        return res;
    }

    public String getString(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    /**
     * 字符是0，左括号是-1，右括号是1 数字是2
     *
     * @param c
     * @return
     */
    public int getType(char c) {
        if (c >= 'a' && c <= 'z') {
            return 0;
        } else if (c == '[') {
            return -1;
        } else if (c == ']') {
            return 1;
        }
        return 2;
    }

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
//        输入：s =
//        输出："accaccacc"
        System.out.println("accaccacc".equals(decodeString.decodeString("3[a2[c]]")));
        System.out.println("abcabccdcdcdef".equals(decodeString.decodeString("2[abc]3[cd]ef")));
        System.out.println("abccdcdcdxyz".equals(decodeString.decodeString("abc3[cd]xyz")));
        System.out.println("aaabcbc".equals(decodeString.decodeString("3[a]2[bc]")));
        System.out.println("zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef".equals(decodeString.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef")));
    }
}

