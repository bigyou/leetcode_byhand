package in.kaixin.leetcode_byhand.numbers;

import org.jcp.xml.dsig.internal.dom.DOMUtils;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author bigyou
 * @Create 2023/7/25 21:38
 */
public class HalveArray {
    //    https://leetcode.cn/problems/minimum-operations-to-halve-array-sum/
//    mid
    public int halveArray(int[] nums) {
        PriorityQueue<Double> p = new PriorityQueue<>((a,b)->b.compareTo(a));
        long sum = 0l;
        if(nums.length==1){
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            p.offer((double) nums[i]);
        }
        double cut = 0;
        int time = 0;
        double expectCut = sum / 2.0;
        while (cut < expectCut) {
//            Double poll = p.poll();
//            cut += poll / 2.0;
//            p.add(poll / 2.0);
//
//            time++;
//            System.out.println("1time="+(time)+",v2dive:"+poll+",cut="+cut);
            Double max = p.poll();
            Double left = max;
            double peek = p.peek();
            while (left >= peek && cut < expectCut) {
                left = left / 2;
                time++;
                cut+=left;
            }
            p.add(new Double(left));
        }
        return time;

    }
    public int ge(int[]nums){
        PriorityQueue<Double> pq = new PriorityQueue<Double>((a, b) -> b.compareTo(a));
        for (int num : nums) {
            pq.offer((double) num);
        }
        int res = 0;
        double sum = 0;
        for (int num : nums) {
            sum += num;
        }
        double sum2 = 0.0;
        while (sum2 < sum / 2.0) {
            double x = pq.poll();
            sum2 += x / 2.0;
            System.out.println("2time="+(res+1)+",v2dive:"+x+",cut="+sum2);
            pq.offer(x / 2.0);
            res++;
        }
        return res;

    }

    public static void main(String[] args) {
        HalveArray h = new HalveArray();
//        System.out.println(h.halveArray(new int[]{32, 98, 23, 14, 67, 40, 26, 9, 96, 96, 91, 76, 4, 40, 42, 2, 31, 13, 16, 37, 62, 2, 27, 25, 100, 94, 14, 3, 48, 56, 64, 59, 33, 10, 74, 47, 73, 72, 89, 69, 15, 79, 22, 18, 53, 62, 20, 9, 76, 64}));
        System.out.println(h.halveArray(new int[]{1}));
//        System.out.println(h.ge(new int[]{32, 98, 23, 14, 67, 40, 26, 9, 96, 96, 91, 76, 4, 40, 42, 2, 31, 13, 16, 37, 62, 2, 27, 25, 100, 94, 14, 3, 48, 56, 64, 59, 33, 10, 74, 47, 73, 72, 89, 69, 15, 79, 22, 18, 53, 62, 20, 9, 76, 64}));
    }
}
