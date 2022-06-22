package in.kaixin.leetcode_byhand;

import com.alibaba.fastjson.JSON;

import java.util.*;

public class PascalsTriangleII {
    //    https://leetcode-cn.com/problems/pascals-triangle-ii/
    public List<Integer> getRow(int rowIndex) {
        Map<String, Integer> noteMap = new HashMap<>();
        int end = rowIndex / 2;
        int[] valueArr = new int[rowIndex + 1];
        for (int i = 0; i <= end; i++) {//这里的边界需要仔细考虑
            int v = doGetRow(rowIndex, i, noteMap);
            valueArr[i] = v;
            valueArr[rowIndex - i] = v;
        }
        List<Integer> list = new LinkedList<>();
        for (int i : valueArr) {
            list.add(i);
        }

        return list;
    }

    public int doGetRow(int x, int y, Map<String, Integer> noteMap) {
        if (x < 0 || y < 0) {
            return 0;
        }
        if (y > x) {//这里的边界需要仔细考虑
            return 0;
        }
        if (x == 0 || x == 1) {
            return 1;
        }
        if (y == 0) {
            return 1;
        }
        String key = x + "_" + y;
        if (noteMap.get(key) != null) {
            return noteMap.get(key);
        }
        int v = doGetRow(x - 1, y - 1, noteMap) + doGetRow((x - 1), y, noteMap);
        noteMap.put(key, v);
        return v;
    }

    public static void main(String[] args) {
        PascalsTriangleII pascalsTriangleII = new PascalsTriangleII();
        System.out.println(JSON.toJSONString(pascalsTriangleII.getRow(0)));
        System.out.println(JSON.toJSONString(pascalsTriangleII.getRow(1)));
        System.out.println(JSON.toJSONString(pascalsTriangleII.getRow(2)));
        System.out.println(JSON.toJSONString(pascalsTriangleII.getRow(3)));
        System.out.println(JSON.toJSONString(pascalsTriangleII.getRow(4)));
        System.out.println(JSON.toJSONString(pascalsTriangleII.getRow(5)));
        System.out.println(JSON.toJSONString(pascalsTriangleII.getRow(6)));
    }
}
