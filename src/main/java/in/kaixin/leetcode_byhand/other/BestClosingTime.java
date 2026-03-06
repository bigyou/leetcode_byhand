package in.kaixin.leetcode_byhand.other;

public class BestClosingTime {
    //    https://leetcode.cn/problems/minimum-penalty-for-a-shop/?envType=daily-question&envId=2025-12-26
//    mid
    public int bestClosingTime(String customers) {
        int[] arr = new int[customers.length() + 1];
        int totalYes = 0;
        for (int i = 0; i < customers.length(); i++) {
            char c = customers.charAt(i);
            if (c == 'Y') {
                totalYes++;
            }
            arr[i + 1] = totalYes;
        }
        int minScore = Integer.MAX_VALUE;
        int time=0;
        for (int i = 0; i < arr.length; i++) {
            int yes = arr[i];
            int score = (totalYes - yes) + (i - yes);
            if(score<minScore){
                time=i;
                minScore=score;
            }
        }
        return time;
    }

    public static void main(String[] args) {
        BestClosingTime b = new BestClosingTime();
        int ret=b.bestClosingTime("YYNY");
        System.out.println( ret);
    }
}
