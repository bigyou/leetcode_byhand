package in.kaixin.leetcode_byhand;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BracketLcci {
    //    https://leetcode-cn.com/problems/bracket-lcci/
    public List<String> generateParenthesis(int n) {
        return null;

    }

    public Set<String> generate(int n) {

        if (n == 1) {
            Set<String> res = new HashSet<>();
            res.add("()");
            return res;
        }
        Set<String> generate = generate(n - 1);
        Set<String> res = new HashSet<>();
        for (int i = 0; i < res.size(); i++) {

        }
        return null;


    }
}
