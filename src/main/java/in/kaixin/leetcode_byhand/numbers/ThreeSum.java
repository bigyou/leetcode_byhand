package in.kaixin.leetcode_byhand.numbers;

import java.util.*;

/**
 * @Author bigyou
 * @Create 2023/7/10 19:51
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        nums = Arrays.stream(nums).sorted().toArray();
        Map<Integer, Integer> maxPositionMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            maxPositionMap.put(nums[i], i);
        }
        Set<String> existsThreeNum = new HashSet<>();

        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int expectV = -nums[i] - nums[j];
                if(expectV>0){
                    break;
                }
                Integer position = maxPositionMap.get(expectV);
                if (position != null && position > j) {
                    String str = nums[i] + "_" + nums[j] + "_" + expectV;
                    if (existsThreeNum.contains(str)) {
                        continue;
                    } else {
                        List<Integer> threeList = new LinkedList<>();
                        threeList.add(nums[i]);
                        threeList.add(nums[j]);
                        threeList.add(expectV);
                        existsThreeNum.add(str);
                        res.add(threeList);

                    }

                }
            }
        }
        return res;


    }
}
