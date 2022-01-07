package in.kaixin.leetcode_byhand.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RightSideView {
    //    https://leetcode-cn.com/problems/binary-tree-right-side-view/


    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> rightViewMap = new HashMap<>();
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        travelInOrder(root, rightViewMap, 0);

        for (int i = 0; i < rightViewMap.size(); i++) {
            Integer v = rightViewMap.get(i);
            res.add(v);
        }
        return res;

    }

    public void travelInOrder(TreeNode node, Map<Integer, Integer> rightViewMap, Integer level) {
        if (node == null) {
            return;
        }
        rightViewMap.put(level, node.val);
        travelInOrder(node.left, rightViewMap, level + 1);
        travelInOrder(node.right, rightViewMap, level + 1);
    }
}
