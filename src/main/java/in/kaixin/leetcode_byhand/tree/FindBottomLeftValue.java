package in.kaixin.leetcode_byhand.tree;

import in.kaixin.leetcode_byhand.common.TreeNode;
import in.kaixin.leetcode_byhand.utils.Utils;

import java.util.LinkedList;
import java.util.List;

public class FindBottomLeftValue {
    //题目链接：https://leetcode.cn/problems/find-bottom-left-tree-value/
    public  static int findBottomLeftValue(TreeNode root) {
        //用了广度搜索 ，性能比较高的是dfs
        List<List<TreeNode>> nodesGroupByDep= new LinkedList<>();
        List<TreeNode> dep0Nodes= new LinkedList<>();
        dep0Nodes.add(root);
        nodesGroupByDep.add(dep0Nodes);
        TreeNode deepsetLeftNode=null;
        int dep=0;
        while(dep<nodesGroupByDep.size()){
            List<TreeNode> treeNodes = nodesGroupByDep.get(dep);
            deepsetLeftNode= treeNodes.get(0);
            List<TreeNode> nextDepNodes= new LinkedList<>();
            for (TreeNode treeNode : treeNodes) {
                if(treeNode.left!=null){
                    nextDepNodes.add(treeNode.left);
                }
                if(treeNode.right!=null){
                    nextDepNodes.add(treeNode.right);
                }
            }
            if(nextDepNodes.size()>0){
                nodesGroupByDep.add(nextDepNodes);
            }
            dep++;
        }
        return deepsetLeftNode.val;
    }

    public static void main(String[] args) {
        TreeNode treeNodes = Utils.getTreeNode(new Integer[]{1, 2, 3, 4, null, 5, 6, null, null, 7});
        System.out.println(findBottomLeftValue(treeNodes));

    }
}
