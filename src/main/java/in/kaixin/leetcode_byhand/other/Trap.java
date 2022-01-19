package in.kaixin.leetcode_byhand.other;

public class Trap {
    //    https://leetcode-cn.com/problems/trapping-rain-water/
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int water = 0;
        for (int i = 2; i < height.length; i++) {
            water += addWater(height, i, height[i]);
        }
        return water;

    }

    public int addWater(int[] height, int end, int h) {
        int water = 0;
        int preHigh = height[end - 1];
        for (int i = end - 1; i >= 0; i--) {
            if (height[i] > preHigh) {
                water += (Math.min(height[i], h) - preHigh) * (end - i - 1);
                preHigh = height[i];
            }
            if (height[i] >= h) {
                break;
            }
        }
        return water;

    }

    public static void main(String[] args) {
        Trap trap = new Trap();
//        int water = trap.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        int water = trap.trap(new int[]{4, 2, 0, 3, 2, 5});
        System.out.println(water);
    }

}
