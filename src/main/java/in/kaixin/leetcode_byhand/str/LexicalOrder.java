package in.kaixin.leetcode_byhand.str;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.List;

public class LexicalOrder {
    //    https://leetcode-cn.com/problems/lexicographical-numbers/
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new LinkedList<>();
        append(res, 0, n);
        return res;

    }

    public void append(List<Integer> res, Integer pre, Integer max) {
//        if (length > maxLength) {
//            return;
//        }
        for (int i = 0; i <= 9; i++) {
            int v = pre * 10 + i;
            if (v == 0) {
                continue;
            }
            if (v <= max) {
                res.add(v);
                append(res, v, max );
            } else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        LexicalOrder lexicalOrder = new LexicalOrder();
        System.out.println(JSON.toJSONString(lexicalOrder.lexicalOrder(13)));
        System.out.println(JSON.toJSONString(lexicalOrder.lexicalOrder(2)));
        System.out.println(JSON.toJSONString(lexicalOrder.lexicalOrder(1)));
    }
}
