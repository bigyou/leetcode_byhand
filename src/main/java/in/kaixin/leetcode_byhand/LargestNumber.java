package in.kaixin.leetcode_byhand;

import java.lang.reflect.Array;
import java.util.*;

public class LargestNumber {
    public String largestNumber1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        if (nums.length == 1) {
            return nums[0] + "";
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {//这个地方需要注意
                int cmp = (nums[i] + "" + nums[j]).compareTo(nums[j] + "" + nums[i]);
                if (cmp > 0) {
                    map.put(i, map.getOrDefault(i, 0) + 1);
                    map.put(j, map.getOrDefault(j, 0));
                } else if (cmp < 0) {
                    map.put(j, map.getOrDefault(j, 0) + 1);
                    map.put(i, map.getOrDefault(i, 0));//这里需要注意

                } else {
                    map.put(i, map.getOrDefault(i, 0));
                    map.put(j, map.getOrDefault(j, 0));
                }
            }
        }
        Map<Integer, List<Integer>> reqAndInt = new HashMap<>();
        for (Integer i : map.keySet()) {
            int freq = map.get(i);
            List<Integer> list = reqAndInt.get(freq);
            if (list == null) {
                list = new LinkedList<>();
                reqAndInt.put(freq, list);
            }
            list.add(i);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (reqAndInt.get(i) == null) {
                continue;
            }
            for (Integer integer : reqAndInt.get(i)) {
                sb.append(nums[integer]);
            }
        }
        return sb.toString();
    }

    public String largestNumber(int[] nums) {
        String[] strList = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strList[i] = nums[i] + "";
        }
        Arrays.sort(strList, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                int i = (x + y).compareTo(y + x);
                return -i;
            }

        });
        StringBuffer sb = new StringBuffer();
        for (String s : strList) {
            sb.append(s);
        }
        String res = sb.toString();
        if (res.startsWith("0")) {
            return "0";
        }
        return res;
    }


    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        System.out.println(largestNumber.largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(largestNumber.largestNumber(new int[]{0, 0, 0}));
    }
}
