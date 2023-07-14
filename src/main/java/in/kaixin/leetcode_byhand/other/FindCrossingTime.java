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

        PriorityQueue<Worker> pickOldWorkers = new PriorityQueue<>(new Comparator<Worker>() {
            @Override
            public int compare(Worker o1, Worker o2) {
                int distance = o1.until - o2.until;
                if (distance >= 0) {
                    return 1;
                } else if (distance < 0) {
                    return -1;
                }
                return 0;
            }
        });
        PriorityQueue<Worker> putNewWorkers = new PriorityQueue<>(new Comparator<Worker>() {
            @Override
            public int compare(Worker o1, Worker o2) {
                int distance = o1.until - o2.until;
                if (distance >= 0) {
                    return 1;
                } else if (distance < 0) {
                    return -1;
                }
                return 0;
            }
        });
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
        int pickingOldCnt = 0;
        while (true) {
            ts++;
            if (crossBridgeWorker != null) {
                crossBridgeTimeLeft--;
            }
            while (putNewWorkers.size() > 0 && putNewWorkers.peek().until <= ts && n - pickingOldCnt > 0) {
                Worker poll = putNewWorkers.poll();
                poll.position = -1;
                bridge.add(poll);

            }
            while (pickOldWorkers.size() > 0 && pickOldWorkers.peek().until <= ts && n - pickingOldCnt > 0) {
                Worker poll = pickOldWorkers.poll();
                poll.position = 1;
                bridge.add(poll);
                n--;
            }
            if (crossBridgeTimeLeft <= 0) {
                if (crossBridgeWorker != null) {//上一秒有正在过桥，这一秒刚好通过
                    if (crossBridgeWorker.position == -1) {
                        crossBridgeWorker.position = 1;
                        pickOldWorkers.add(crossBridgeWorker);
                        crossBridgeWorker.until = ts + crossBridgeWorker.pickold;
                        pickingOldCnt++;
                        System.out.println(ts + "->" + (crossBridgeWorker.until) + ":" + crossBridgeWorker.idx + ",pick old");
                    } else {
                        crossBridgeWorker.position = -1;
                        putNewWorkers.add(crossBridgeWorker);
                        crossBridgeWorker.until = ts + crossBridgeWorker.putnew;
                        System.out.println(ts + "->" + (crossBridgeWorker.until) + ":" + crossBridgeWorker.idx + ",putNew");
                    }
                }
                if (bridge.peek() != null) {
                    crossBridgeWorker = bridge.poll();
                    if (crossBridgeWorker.position == -1) {//从左向右
                        if (n > 0) {
                            crossBridgeTimeLeft = crossBridgeWorker.left2right;
                            System.out.println(ts + "->" + (ts + crossBridgeTimeLeft) + ":" + crossBridgeWorker.idx + ",从左到右过桥");
                        }

                    } else {//从右向左
                        crossBridgeTimeLeft = crossBridgeWorker.right2left;
                        leftGoodsToCrossBridge--;
                        pickingOldCnt--;
                        System.out.println(ts + "->" + (ts + crossBridgeTimeLeft) + ":" + crossBridgeWorker.idx + ",从右到左过桥");
                        if (leftGoodsToCrossBridge == 0) {
                            ts = crossBridgeTimeLeft + ts;
                            break;
                        }
                    }
                } else {
                    crossBridgeWorker = null;
                }

            } else {
//                crossBridgeTimeLeft--;
            }

        }
        return ts;
    }

    public static void main(String[] args) {
        FindCrossingTime findCrossingTime = new FindCrossingTime();
        int[][] time = new int[3][4];
        time[0] = new int[]{1, 1, 2, 1};
        time[1] = new int[]{1, 1, 3, 1};
        time[2] = new int[]{1, 1, 4, 1};
        int costTime = 0;//

        costTime = findCrossingTime.findCrossingTime(1, 3, time);

        System.out.println(costTime);

        costTime = findCrossingTime.findCrossingTime(3, 2, new int[][]{new int[]{1, 9, 1, 8}, new int[]{10, 10, 10, 10}});


        System.out.println(costTime);
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
