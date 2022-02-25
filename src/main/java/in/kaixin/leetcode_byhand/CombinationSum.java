package in.kaixin.leetcode_byhand;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
//    https://leetcode-cn.com/problems/combination-sum/

    //    List<List<Integer>> res = new LinkedList<>();
//
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        Arrays.sort(candidates);
//        doCombination(candidates, 0, target, new LinkedList<>());
//        return res;
//    }
//
//    public void doCombination(int[] candidates, int start, int target, List<Integer> list) {
//        if (target < 0) {
//            return;
//        } else if (target == 0) {
//            List<Integer> copy = copy(list);
//            res.add(copy);
//            return;
//        } else {
//            for (int i = start; i < candidates.length; i++) {
//                list.add(candidates[i]);
//                doCombination(candidates, i, target - candidates[i], list);
//                list.remove(list.size() - 1);
//            }
//        }
//    }
//
//    public List<Integer> copy(List<Integer> list) {
//        List<Integer> copy = new LinkedList<>();
//        for (Integer integer : list) {
//            copy.add(integer);
//        }
//        return copy;
//    }
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Arrays.sort(candidates);
        doCombination(candidates, 0, target, new LinkedList<>());
        return res;
    }

    public void doCombination(int[] candidates, int start, int target, List<Integer> list) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            List<Integer> copy = copy(list);
            res.add(copy);
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (target - candidates[i] >= 0) {
                    list.add(candidates[i]);
                    doCombination(candidates, i, target - candidates[i], list);
                    list.remove(list.size() - 1);
                } else {
                    continue;
                }

            }
        }
    }

    public List<Integer> copy(List<Integer> list) {
        List<Integer> copy = new LinkedList<>();
        for (Integer integer : list) {
            copy.add(integer);
        }
        return copy;
    }

    public static void main(String[] args) {
//        [2,3,6,7], target = 7
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> lists = combinationSum.combinationSum(new int[]{2}, 1);
        System.out.println(JSON.toJSON(lists));
        lists = combinationSum.combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(JSON.toJSON(lists));
        lists = combinationSum.combinationSum(new int[]{2, 3, 5}, 8);
        System.out.println(JSON.toJSON(lists));

    }
}
