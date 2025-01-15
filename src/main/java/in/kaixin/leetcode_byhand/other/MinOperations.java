package in.kaixin.leetcode_byhand.other;

import java.util.PriorityQueue;

public class MinOperations {
//    https://leetcode.cn/problems/minimum-operations-to-exceed-threshold-value-ii/?envType=daily-question&envId=2025-01-15
//    mid

    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> q = new PriorityQueue<>();
        for (int num : nums) {
            if (num < k) {
                q.add((long) num);
            }
        }
        int res=0;
        while (!q.isEmpty()){
            res++;
            if(q.size()==1){
                break;
            }
            long v=q.poll()*2+q.poll();
            if(v<k){
                q.add(v);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MinOperations m = new MinOperations();
        m.minOperations(new int[]{999999999,999999999,999999999}, 1000000000);
    }

}
