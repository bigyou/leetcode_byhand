package in.kaixin.leetcode_byhand.other;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author bigyou
 * @Create 2023/7/7 22:42
 */
public class FindCrossingTime { // TODO unsolved
    //    https://leetcode.cn/problems/time-to-cross-a-bridge/
    //    hard
//    public int findCrossingTime(int n, int k, int[][] time) {//会超时
//        PriorityQueue<Worker> bridge = new PriorityQueue<>(new Comparator<Worker>() {
//            @Override
//            public int compare(Worker o1, Worker o2) {
//                if (o1.position > o2.position) {//右边优先左边
//                    return -1;
//                } else if (o1.position < o2.position) {
//                    return 1;
//                }
////效率低优先效率高
//                int diff = o1.left2right + o1.right2left - o2.left2right - o2.right2left;
//                if (diff > 0) {
//                    return -1;
//                } else if (diff < 0) {
//                    return 1;
//                }
//                //序号
//                if (o1.idx > o2.idx) {
//                    return -1;
//                } else {
//                    return 1;
//                }
//
//            }
//        });
//
//        PriorityQueue<Worker> pickOldWorkerQueue = new PriorityQueue<>((a, b) -> (a.until - b.until) > 0 ? 1 : -1);
//        PriorityQueue<Worker> putNewWorkerQueue = new PriorityQueue<>((a, b) -> (a.until - b.until) > 0 ? 1 : -1);
//        int ts = -1;
//        for (int i = 0; i < k; i++) {
//            Worker worker = new Worker(i, time[i][0], time[i][1], time[i][2], time[i][3]);
//            worker.until = worker.left2right;
//            worker.position = -1;
//            bridge.add(worker);
//        }
//        int crossBridgeTimeLeft = 0;
//        Worker crossBridgeWorker = null;
//        int leftGoodsToCrossBridge = n;
//        int crossbridgeGoodCnt = 0;
//        while (true) {
//                ts++;
//            if (crossBridgeWorker != null) {
//                crossBridgeTimeLeft--;
//            }
//            while (pickOldWorkerQueue.size() > 0 && pickOldWorkerQueue.peek().until <= ts) {
//                Worker poll = pickOldWorkerQueue.poll();
//                poll.position = 1;
//                bridge.add(poll);
//            }
//
//
//            if (crossBridgeTimeLeft <= 0) {//有人要下桥
//                if (crossBridgeWorker != null) {//上一秒有正在过桥，这一秒刚好通过
//                    if (crossBridgeWorker.position == -1) {
//                        crossBridgeWorker.position = 1;
//                        crossBridgeWorker.until = ts + crossBridgeWorker.pickold;
//                        pickOldWorkerQueue.add(crossBridgeWorker);
//                        leftGoodsToCrossBridge--;
//                        System.out.println(ts + "->" + (crossBridgeWorker.until) + ":" + crossBridgeWorker.idx + ",pick old");
//                    } else {
//                        crossBridgeWorker.position = -1;
//                        crossBridgeWorker.until = ts + crossBridgeWorker.putnew;
//                        putNewWorkerQueue.add(crossBridgeWorker);
//
//                        System.out.println(ts + "->" + (crossBridgeWorker.until) + ":" + crossBridgeWorker.idx + ",putNew");
//                        crossbridgeGoodCnt++;
//                        if (crossbridgeGoodCnt >= n) {
//                            return ts;//右边的商品都通过了桥梁
//                        }
//                    }
//                }
//            }
//            while (putNewWorkerQueue.size() > 0 && putNewWorkerQueue.peek().until <= ts && leftGoodsToCrossBridge > 0) {
//                Worker poll = putNewWorkerQueue.poll();
//                poll.position = -1;
//                bridge.add(poll);
//            }
//
//            if (crossBridgeTimeLeft <= 0) {
//                if (bridge.peek() != null) {//安排上桥
//                    crossBridgeWorker = bridge.poll();
//                    if (crossBridgeWorker.position == -1) {//从左向右
//                        if (leftGoodsToCrossBridge > 0) {
//                            crossBridgeTimeLeft = crossBridgeWorker.left2right;
//                            System.out.println(ts + "->" + (ts + crossBridgeTimeLeft) + ":" + crossBridgeWorker.idx + ",从左到右过桥");
//                        } else {
//                            crossBridgeWorker = null;
//                        }
//                    } else {//从右向左
//                        crossBridgeTimeLeft = crossBridgeWorker.right2left;
//                        System.out.println(ts + "->" + (ts + crossBridgeTimeLeft) + ":" + crossBridgeWorker.idx + ",从右到左过桥");
//                    }
//                } else {
//                    crossBridgeWorker = null;
//                }
//
//
//            } else {
////                crossBridgeTimeLeft--;
//            }
//
//
//        }
//    }


    public int findCrossingTime(int n, int k, int[][] time) {
        PriorityQueue<Worker> bridge = new PriorityQueue<>(new Comparator<Worker>() {
            @Override
            public int compare(Worker o1, Worker o2) {
                if (o1.position > o2.position) {//右边优先左边
                    return -1;
                } else if (o1.position < o2.position) {
                    return 1;
                }
//效率低优先效率高
                int diff = o1.left2right + o1.right2left - o2.left2right - o2.right2left;
                if (diff > 0) {
                    return -1;
                } else if (diff < 0) {
                    return 1;
                }
                //序号
                if (o1.idx > o2.idx) {
                    return -1;
                } else {
                    return 1;
                }

            }
        });

        PriorityQueue<Worker> pickOldWorkerQueue = new PriorityQueue<>((a, b) -> (a.until - b.until) > 0 ? 1 : -1);
        PriorityQueue<Worker> putNewWorkerQueue = new PriorityQueue<>((a, b) -> (a.until - b.until) > 0 ? 1 : -1);
        int ts = -1;
        for (int i = 0; i < k; i++) {
            Worker worker = new Worker(i, time[i][0], time[i][1], time[i][2], time[i][3]);
            worker.until = worker.left2right;
            worker.position = -1;
            bridge.add(worker);
        }
        int crossBridgeTimeLeft = 0;
        Worker crossBridgeWorker = null;
        int leftGoodsToCrossBridge = n;
        int crossbridgeGoodCnt = 0;
        while (true) {
            if (crossBridgeWorker != null) {
                crossBridgeTimeLeft--;
            }
            while (pickOldWorkerQueue.size() > 0 && pickOldWorkerQueue.peek().until <= ts) {
                Worker poll = pickOldWorkerQueue.poll();
                poll.position = 1;
                bridge.add(poll);
            }


            if (crossBridgeTimeLeft <= 0) {//有人要下桥
                if (crossBridgeWorker != null) {//上一秒有正在过桥，这一秒刚好通过
                    if (crossBridgeWorker.position == -1) {
                        crossBridgeWorker.position = 1;
                        crossBridgeWorker.until = ts + crossBridgeWorker.pickold;
                        pickOldWorkerQueue.add(crossBridgeWorker);
                        leftGoodsToCrossBridge--;
                        System.out.println(ts + "->" + (crossBridgeWorker.until) + ":" + crossBridgeWorker.idx + ",pick old");
                    } else {
                        crossBridgeWorker.position = -1;
                        crossBridgeWorker.until = ts + crossBridgeWorker.putnew;
                        putNewWorkerQueue.add(crossBridgeWorker);

                        System.out.println(ts + "->" + (crossBridgeWorker.until) + ":" + crossBridgeWorker.idx + ",putNew");
                        crossbridgeGoodCnt++;
                        if (crossbridgeGoodCnt >= n) {
                            return ts;//右边的商品都通过了桥梁
                        }
                    }
                }
            }
            while (putNewWorkerQueue.size() > 0 && putNewWorkerQueue.peek().until <= ts && leftGoodsToCrossBridge > 0) {
                Worker poll = putNewWorkerQueue.poll();
                poll.position = -1;
                bridge.add(poll);
            }

            if (crossBridgeTimeLeft <= 0) {
                if (bridge.peek() != null) {//安排上桥
                    crossBridgeWorker = bridge.poll();
                    if (crossBridgeWorker.position == -1) {//从左向右
                        if (leftGoodsToCrossBridge > 0) {
                            crossBridgeTimeLeft = crossBridgeWorker.left2right;
                            System.out.println(ts + "->" + (ts + crossBridgeTimeLeft) + ":" + crossBridgeWorker.idx + ",从左到右过桥");
                        } else {
                            crossBridgeWorker = null;
                        }
                    } else {//从右向左
                        crossBridgeTimeLeft = crossBridgeWorker.right2left;
                        System.out.println(ts + "->" + (ts + crossBridgeTimeLeft) + ":" + crossBridgeWorker.idx + ",从右到左过桥");
                    }
                } else {
                    crossBridgeWorker = null;
                }


            } else {
//                crossBridgeTimeLeft--;
            }


        }
    }

    public static void main(String[] args) {
        FindCrossingTime findCrossingTime = new FindCrossingTime();
        int[][] time = new int[3][4];
        time[0] = new int[]{1, 1, 2, 1};
        time[1] = new int[]{1, 1, 3, 1};
        time[2] = new int[]{1, 1, 4, 1};
        int costTime = 0;//

//        costTime = findCrossingTime.findCrossingTime(1, 3, time);
//
//        System.out.println(costTime);
//        costTime = findCrossingTime.findCrossingTime(3, 2, new int[][]{new int[]{1, 9, 1, 8}, new int[]{10, 10, 10, 10}});
//        System.out.println(costTime);
//        costTime = findCrossingTime.findCrossingTime(10, 6, new int[][]{{2,10,5,8},{3,5,2,2},{5,8,10,10},{7,8,8,5},{5,6,6,10},{6,10,6,2}});
//        System.out.println(costTime);
//        costTime = findCrossingTime.findCrossingTime(9, 6, new int[][]{{2, 6, 9, 4}, {4, 8, 7, 5}, {4, 6, 7, 6}, {2, 3, 3, 7}, {9, 3, 6, 8}, {2, 8, 8, 4}});
//
//        System.out.println(costTime);
        int[][] wints = new int[10000][4];
        for (int i = 0; i < 10000; i++) {
            int[] v = new int[]{1000, 1000, 1000, 1000};
            wints[i] = v;

        }

        costTime = findCrossingTime.findCrossingTime(10000, 10000, wints);
        System.out.println(costTime);


//        PriorityQueue<Worker> workers = new PriorityQueue<>((a, b) -> (a.until - b.until) > 0 ? 1 : -1);
//        Worker worker1=new Worker(0,2,2,2,2);
//        Worker worker2=new Worker(1,3,2,2,2);
//        Worker worker3=new Worker(2,4,2,2,2);
//        worker1.until=4;
//        worker2.until=9;
//        worker3.until=1;
//        workers.add(worker1);
//        workers.add(worker2);
//        workers.add(worker3);
//        System.out.println(workers);


    }
}

class Worker {
    int idx;
    int left2right = 0;
    int right2left = 0;
    int pickold = 0;
    int putnew = 0;
    int until;//
    int position;//-1表示左边，-2表示右边


    public Worker(int idx, int left2right, int pickold, int right2left, int putnew) {
        this.idx = idx;
        this.left2right = left2right;
        this.pickold = pickold;
        this.right2left = right2left;
        this.putnew = putnew;
    }
}
