package in.kaixin.leetcode_byhand;

import java.util.Stack;

public class Longest {
    //    public int getLongest(String str) {
//        if (str == null || str == "") {
//            return 0;
//        }
//        int max = 0;//
//        int current = 0;
//        Stack<Character> stack = new Stack<>();//用栈来实现括号的匹配
//        char[] chars = str.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            char c = chars[i];
//            if (stack.isEmpty()) {//如果堆栈为空并且只有是左括号才放入
//                if (isRight(c)) {
//                    max = Math.max(current, max);
//                    current = 0;
//                } else {
//                    stack.add(c);
//                }
//                continue;
//            }
//            if (isRight(c)) {
//                if (!stack.isEmpty() && isLeft(stack.peek())) {//match
//                    stack.pop();
//                    current += 2;
//
//                } else {
//                    max = Math.max(current, max);
//                    current = 0;
//                    clearStack(stack);
//                }
//            } else {
//                stack.add(c);
//            }
//        }
//        max = Math.max(current, max);
//        return max;
//
//    }
//
//
//    public boolean clearStack(Stack stack) {
//        while (!stack.isEmpty()) {
//            stack.pop();
//        }
//        return true;
//    }
//

    /**
     * 匹配完成后，堆栈中还存在的值，就是无法匹配的点，这些点把str分割成了一段段的中间连续的括号，找出其中最大的就可以了
     *
     * @param str
     * @return
     */

    public int getLongest(String str) {
        if (str == null || str == "") {
            return 0;
        }
        int max = 0;//
        Stack<Content> stack = new Stack<>();//用栈来实现括号的匹配
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (!stack.isEmpty()) {
                if (isRight(c)) {
                    if (isLeft(stack.peek().getV())) {//match
                        stack.pop();//匹配上就弹出左括号
                        continue;
                    }
                }
            }
            Content content = new Content();
            content.setIndex(i);
            content.setV(c);
            stack.add(content);
        }
        if (stack.isEmpty()) {
            max = chars.length;
        } else {
            int index = chars.length;
            while (!stack.isEmpty()) {
                max = Math.max(max, index - stack.peek().index - 1);
                index = stack.peek().index;
                stack.pop();
            }
            max = Math.max(max, index + 1 - 1);
        }
        return max;
    }

    public boolean isRight(char c) {
        return ')' == c;
    }

    public boolean isLeft(char c) {
        return '(' == c;
    }

    public static void main(String[] args) {
        Longest longest = new Longest();
        System.out.println(longest.getLongest("(()"));
        System.out.println(longest.getLongest(")()())"));
        System.out.println(longest.getLongest(""));
        System.out.println(longest.getLongest("())()()((()()()())"));
        System.out.println(longest.getLongest("("));
        System.out.println(longest.getLongest(")"));
        System.out.println(longest.getLongest(")("));
        System.out.println(longest.getLongest("()"));
        System.out.println(longest.getLongest(")()"));
    }


}

class Content {
    int index;
    char v;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public char getV() {
        return v;
    }

    public void setV(char v) {
        this.v = v;
    }
}
