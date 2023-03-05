package in.kaixin.leetcode_byhand.other;

public class MinOperationsMaxProfit {
//    https://leetcode.cn/problems/maximum-profit-of-operating-a-centennial-wheel/submissions/409496491/
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        if(boardingCost*4<runningCost){
            return -1;
        }
        int waitingCnt=0;
        int cursor=0;
        int runningCnt=0;
        int maxProfit=-1;
        int currentProfite=0;
        int maxProfitRunningCnt=-1;
        while(waitingCnt>0||cursor<customers.length){
            if(cursor<customers.length) {
                waitingCnt += customers[cursor];
            }
            runningCnt++;
            int onBoadCnt=0;
            if(waitingCnt>=4){
                onBoadCnt=4;
                waitingCnt-=4;
            }else {
                onBoadCnt=waitingCnt;
                waitingCnt=0;
            }
            currentProfite+=onBoadCnt*boardingCost-runningCost;
            if(currentProfite>maxProfit&&currentProfite>0){
                maxProfit=currentProfite;
                maxProfitRunningCnt=runningCnt;
            }
            cursor++;
        }
        return  maxProfitRunningCnt;

    }
}
