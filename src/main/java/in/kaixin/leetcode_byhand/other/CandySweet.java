package in.kaixin.leetcode_byhand.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CandySweet {

    //    https://leetcode.cn/problems/maximum-tastiness-of-candy-basket/
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        PriorityQueue<ValueAndPosition> q = new PriorityQueue<>(new Comparator<ValueAndPosition>() {
            @Override
            public int compare(ValueAndPosition o1, ValueAndPosition o2) {
                int diff = o1.getV() - o2.getV();
                if (diff > 0) {
                    return -1;
                } else if (diff < 0) {
                    return 1;
                } else {
                    if (o1.getP() > o2.getP()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }

            }
        });

        for (int i=0;i<price.length;i++){

        }











        return 0;
    }

}

class ValueAndPosition {
    int v;
    int p;

    public ValueAndPosition(int v, int p) {
        this.v = v;
        this.p = p;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }
}
