package in.kaixin.leetcode_byhand.other;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindRestaurant {
    //    https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        Integer min = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        List<String> res = new LinkedList<>();
        for (int i = 0; i < list2.length && i <= min; i++) {
            if (map1.containsKey(list2[i])) {
                int indexSum = i + map1.get(list2[i]);
                if (indexSum == min) {
                    res.add(list2[i]);
                } else if (indexSum < min) {
                    min = indexSum;
                    res.clear();
                    res.add(list2[i]);
                } else {
                    continue;
                }
            }
        }
        String[] resArr = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i]=res.get(i);
        }
        return resArr;
    }

    public static void main(String[] args) {
        FindRestaurant f=new FindRestaurant();
        System.out.println(JSON.toJSONString(f.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},new String[]{"KFC", "Shogun", "Burger King"})));
        System.out.println(JSON.toJSONString(f.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"})));

    }
}
