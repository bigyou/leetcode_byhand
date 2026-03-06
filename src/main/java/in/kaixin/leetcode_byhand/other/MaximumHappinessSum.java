package in.kaixin.leetcode_byhand.other;

import java.util.PriorityQueue;

public class MaximumHappinessSum {
    public long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : happiness) {
            if (queue.size() < k) {
                queue.add(i);
            } else {
                if (i > queue.peek()) {
                    queue.poll();
                    queue.add(i);
                }
            }
        }


        long total =0;
        while(!queue.isEmpty()){
            int v =queue.poll()-queue.size();
            total+=v<0?0:v;
        }
        return total;


    }
}
