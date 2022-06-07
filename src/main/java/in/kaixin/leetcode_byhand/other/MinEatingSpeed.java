package in.kaixin.leetcode_byhand.other;

public class MinEatingSpeed {
    //    https://leetcode.cn/problems/koko-eating-bananas/
    public int minEatingSpeed(int[] piles, int h) {
        if (h < piles.length) {
            return 0;
        }
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
            if (piles[i] < min) {
                min = piles[i];
            }
        }
        int res = caculateMin(piles, min, max, h);
        return res;
    }

    public int caculateMin(int[] piles, int left, int right, int h) {

        if (left == right) {
            return left;
        }
        int t = 0;
        int mid = (left + right) / 2;
        for (int i = 0; i < piles.length; i++) {
            t += Math.ceil(1.0 * piles[i] / mid);
            if (t > h) {
                break;
            }
        }
        if (t > h) {
            return caculateMin(piles, mid + 1, right, h);
        } else {
            return caculateMin(piles, left, mid, h);
        }
    }

//    public static void main(String[] args) {
//        MinEatingSpeed minEatingSpeed = new MinEatingSpeed();
//
//        int[] piles = new int[]{3, 6, 7, 11};
//        int i = minEatingSpeed.minEatingSpeed(piles, 8);
//        System.out.println(i);
//
//        piles = new int[]{30, 11, 23, 4, 20};
//        i = minEatingSpeed.minEatingSpeed(piles, 5);
//        System.out.println(i);
//        piles = new int[]{30,11,23,4,20};
//        i = minEatingSpeed.minEatingSpeed(piles, 6);
//        System.out.println(i);
//    }
}
