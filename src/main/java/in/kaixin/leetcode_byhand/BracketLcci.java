package in.kaixin.leetcode_byhand;

import java.util.LinkedList;
import java.util.List;

public class BracketLcci {
    //    https://leetcode-cn.com/problems/bracket-lcci/
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        generate("", n, n, res);
        return res;

    }

    public void generate(String str, int left, int right, List<String> res) {
        if (right < left) {
            return;
        }
        if (left == right && left == 0) {
            res.add(str);
            return;
        }
        if (left >= 1) {
            generate(str + "(", left - 1, right, res);
        }
        if (right >= 1) {
            generate(str + ")", left, right - 1, res);
        }
    }

    public static void main(String[] args) {
        BracketLcci bracketLcci = new BracketLcci();
        List<String> strings = bracketLcci.generateParenthesis(4);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
