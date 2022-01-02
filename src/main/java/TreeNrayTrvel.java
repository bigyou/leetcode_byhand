import java.util.LinkedList;
import java.util.List;

public class TreeNrayTrvel {
//    https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> values = new LinkedList<>();
        if (root == null) {
            return values;
        }
        dealOrder(values, root, 0);
        return values;
    }

    public boolean dealOrder(List<List<Integer>> values, Node node, Integer level) {
        if (values.size() < level + 1) {
            values.add(new LinkedList<>());
        }
        if (node.children != null && node.children.size() > 0) {
            for (Node singleChild : node.children) {
                dealOrder(values, singleChild, level + 1);
            }
        }
        List<Integer> list = values.get(level);
        list.add(node.val);
        return true;
    }

}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};