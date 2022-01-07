//package in.kaixin.leetcode_byhand.tree;
//
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//
//public class PopulateRight {
//    //https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
//
//    public Node connect2(Node root) {
//        if(root==null){
//            return null;
//        }
//        conn(root.left, root);
//        return root;
//    }
//
//    public void conn(Node left, Node right) {
//        if (left == null || right == null) {
//            return;
//        }
//        left.next = right.next;
//        conn(left.left, left.right);
//        conn(right.left, right.right);
//        conn(left.right, right.left);
//
//    }
//
//    public Node connect(Node root) {
//        Map<Integer, List<Node>> map = new HashMap<>();
//        levelTravel(root, map, 0);
//        for (int i = 0; i < map.keySet().size(); i++) {
//            List<Node> nodes = map.get(i);
//            if (nodes == null || nodes.size() == 0) {
//                continue;
//            }
//            Node node = null;
//            for (int j = 0; j < nodes.size(); j++) {
//                if (j == 0) {
//                    node = nodes.get(j);
//                    continue;
//                } else {
//                    node.next = nodes.get(j);
//                    node = nodes.get(j);
//                }
//            }
//            if (node != null) {
//                node.next = null;
//            }
//
//        }
//        return root;
//
//    }
//
//    public void levelTravel(Node node, Map<Integer, List<Node>> map, Integer level) {
//        if (node == null) {
//            return;
//        }
//        List<Node> list = map.get(level);
//        if (list == null) {
//            list = new LinkedList<>();
//            map.put(level, list);
//        }
//        list.add(node);
//        levelTravel(node.left, map, level + 1);
//        levelTravel(node.right, map, level + 1);
//    }
//
//}
//
//class Node {
//    public int val;
//    public Node left;
//    public Node right;
//    public Node next;
//
//    public Node() {
//    }
//
//    public Node(int _val) {
//        val = _val;
//    }
//
//    public Node(int _val, Node _left, Node _right, Node _next) {
//        val = _val;
//        left = _left;
//        right = _right;
//        next = _next;
//    }
//}
