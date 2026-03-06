package in.kaixin.leetcode_byhand.tree;

import in.kaixin.leetcode_byhand.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class MaxProduct {
    //    https://leetcode.cn/problems/maximum-product-of-splitted-binary-tree/?envType=daily-question&envId=2026-01-07
//    mid
    public int maxProduct(TreeNode root) {
        List<Long> sumList = new LinkedList<>();
        long total = dfsAfter(root, sumList);
        long expect = total / 2;
        long mindiff = total;
        long findV=total;
        for (Long v : sumList) {
            long diff = Math.abs(expect-v);
            if(diff<mindiff){
                mindiff=diff;
                findV=v;
            }
        }
        long v=((total-findV)*findV) %(1000000000+7);
        return (int) v;
    }

    public long dfsAfter(TreeNode node, List<Long> sumList) {
        if (node == null) {
            return 0;
        }
        long sum = dfsAfter(node.left, sumList) + dfsAfter(node.right, sumList) + node.val;
        sumList.add(sum);
        return sum;
    }
}
