package in.kaixin.leetcode_byhand;

import java.util.PriorityQueue;

public class MedianFinder {
    //    https://leetcode-cn.com/problems/find-median-from-data-stream/
    PriorityQueue<Integer> minQueue = new PriorityQueue<>((a, b) -> (b - a));
    PriorityQueue<Integer> maxQueue = new PriorityQueue<>((a, b) -> (a - b));

    public MedianFinder() {

    }


    public void addNum(int num) {
        if (minQueue.size() == 0 || minQueue.peek() >= num) {
            minQueue.add(num);
            if (minQueue.size() - maxQueue.size() > 1) {
                Integer v = minQueue.poll();
                maxQueue.add(v);
                return;
            }
        } else {
            maxQueue.add(num);
            if (maxQueue.size() > minQueue.size() ) {
                Integer poll = maxQueue.poll();
                minQueue.add(poll);
            }
        }


    }

    public double findMedian() {
        if (minQueue.size() > maxQueue.size()) {
            return minQueue.peek();
        } else {
            return (maxQueue.peek() + minQueue.peek()) / 2.0;
        }

    }

    public static void main(String... args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}
