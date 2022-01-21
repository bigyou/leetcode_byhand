package in.kaixin.leetcode_byhand.tree;
import in.kaixin.leetcode_byhand.common.TreeNode;

import java.util.*;

public class BinaryTreeVerticalTravel {
    //    https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree/
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> values = new LinkedList<>();
        if (root == null) {
            return values;
        }
        Map<Integer, Map<Integer, List<Integer>>> valueMap = new HashMap<>();
        travel(valueMap, root, 0, 0);
        arrangeData(valueMap, values);

        return values;
    }

    public void arrangeData(Map<Integer, Map<Integer, List<Integer>>> valueMap, List<List<Integer>> values) {
        Integer[] allXArray = valueMap.keySet().toArray(new Integer[valueMap.keySet().size()]);//  获取所有的x坐标
        Arrays.sort(allXArray);//排序
        for (Integer x : allXArray) {//
            Map<Integer, List<Integer>> valuesUnderSameX = valueMap.get(x);//相同x下的所有value
            List<Integer> valueList = new LinkedList<>();
            Integer[] sortedAllYUnderX = valuesUnderSameX.keySet().toArray(new Integer[valuesUnderSameX.size()]);
            Arrays.sort(sortedAllYUnderX);
            for (Integer y : sortedAllYUnderX) {
                List<Integer> valueWithSameY = valuesUnderSameX.get(y);
                if (valueWithSameY == null || valueWithSameY.size() == 0) {
                    continue;
                }
                if (valueWithSameY.size() == 1) {
                    valueList.add(valueWithSameY.get(0));
                } else {
                    valueWithSameY.sort(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            if (o1 > o2) {
                                return 1;
                            } else if (o1.equals(o2)) {
                                return 0;
                            } else {
                                return -1;
                            }
                        }
                    });
                    valueList.addAll(valueWithSameY);
                }
            }
            if (valueList != null && valueList.size() > 0) {
                values.add(valueList);
            }
        }

    }


    public boolean travel(Map<Integer, Map<Integer, List<Integer>>> valueMap, TreeNode node, Integer x, Integer y) {
        if (valueMap.get(x) == null) {
            valueMap.put(x, new HashMap<>());
        }
        if (valueMap.get(x).get(y) == null) {
            valueMap.get(x).put(y, new LinkedList<>());
        }
        valueMap.get(x).get(y).add(node.val);
        if (node.left != null) {
            travel(valueMap, node.left, x - 1, y + 1);
        }
        if (node.right != null) {
            travel(valueMap, node.right, x + 1, y + 1);
        }
        return true;
    }

}
