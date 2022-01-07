package in.kaixin.leetcode_byhand.tree;

import java.util.LinkedList;
import java.util.List;

public class TreeNrayPreTrvel {
    //    https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
    public List<Integer> preorder(Node root) {
        List<Integer> valueList = new LinkedList<>();
        if (root == null) {
            return valueList;
        }
        dealPreTravel(valueList, root);
        return valueList;


    }

    public boolean dealPreTravel(List<Integer> valueList, Node node) {
        if (node != null) {
            valueList.add(node.val);
        }
        if (node.children != null && node.children.size() > 0) {
            for (Node childNode : node.children) {
                dealPreTravel(valueList, childNode);
            }
        }
        return true;
    }
}
