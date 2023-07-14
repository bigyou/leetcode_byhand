package in.kaixin.leetcode_byhand.tree;

import in.kaixin.leetcode_byhand.common.TreeNode;

/**
 * @Author bigyou
 * @Create 2023/7/14 19:08
 */
public class DistributeCoins {


    public int distributeCoins(TreeNode root) {

        NodeInfo nodeInfo = check(root);
        System.out.println("membercnt=" + nodeInfo.nodeCnt + ",change=" + nodeInfo.change);
        return nodeInfo.change / 2;
    }

    public NodeInfo check(TreeNode node) {
        NodeInfo nodeInfo = new NodeInfo();
        if (node.left != null) {
            NodeInfo left = check(node.left);
//            nodeInfo.expectCoins += left.expectCoins;
            nodeInfo.nodeCnt = left.nodeCnt;
            nodeInfo.existCoins = left.existCoins;
            nodeInfo.change = left.change;
        }

        if (node.right != null) {
            NodeInfo right = check(node.right);
//            nodeInfo.expectCoins += right.expectCoins;
            nodeInfo.nodeCnt += right.nodeCnt;
            nodeInfo.existCoins += right.existCoins;
            nodeInfo.change += right.change;
        }
        nodeInfo.nodeCnt += 1;//加上当前节点
        nodeInfo.existCoins += node.val;
        nodeInfo.change += Math.abs(nodeInfo.existCoins - nodeInfo.nodeCnt);

        return nodeInfo;

    }

    public static void main(String[] args) {

    }
}

class NodeInfo {
    int nodeCnt;
    int existCoins;
    int change;
}
