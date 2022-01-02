import java.util.LinkedList;
import java.util.List;

public class TreezigzagLevelOrder {
    //    https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> values = new LinkedList<>();
        if (root == null) {
            return values;
        }
        dealLevelOrder(values, root, 0);
        return values;
    }

    public void dealLevelOrder(List<List<Integer>> values, TreeNode treeNode, Integer level) {
        if (treeNode != null) {
            if (values.size() < level + 1) {
                values.add(new LinkedList<>());
            }
        }
        if (treeNode.left != null) {
            dealLevelOrder(values, treeNode.left, level + 1);
        }
        if (treeNode.right != null) {
            dealLevelOrder(values, treeNode.right, level + 1);
        }
        List<Integer> valueList = values.get(level);
        if(level%2==0){
            valueList.add(treeNode.val);
        }else {
            valueList.add(0, treeNode.val);
        }

    }

}
