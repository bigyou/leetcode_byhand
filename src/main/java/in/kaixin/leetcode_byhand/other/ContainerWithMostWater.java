package in.kaixin.leetcode_byhand.other;

public class ContainerWithMostWater {
    public int maxArea2(int[] height) {//超出时间长度
        if (height == null || height.length == 1) {
            return 0;
        }
        int maxArea = 0;

        int[] leftRise = new int[height.length];
        int[] rightDown = new int[height.length];
        int cursor = 1;
        leftRise[0] = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] > height[i - 1]) {
                leftRise[cursor] = i;
                cursor++;
            }
        }
        cursor = 1;
        rightDown[0] = height.length - 1;

        for (int i = height.length - 2; i >= 0; i--) {
            if (height[i] > height[i + 1]) {
                rightDown[cursor] = i;
                cursor++;
            }
        }
        for (int i = 0; i < leftRise.length; i++) {
            if (i > 0 && leftRise[i] == 0) {
                break;
            }
            for (int j = 0; rightDown[j] > leftRise[i]; j++) {
                if (rightDown[j] == 0) {
                    break;
                }
                maxArea = Math.max(Math.min(height[leftRise[i]], height[rightDown[j]]) * (rightDown[j] - leftRise[i]), maxArea);
            }
        }
        return maxArea;
    }

    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        int preLeft = 0;
        int preRight = 0;
        while (left < right) {
            if (height[left] < preLeft) {
                left++;
                continue;
            }
            if (height[right] < preRight) {
                right--;
                continue;
            }
            maxArea = Math.max(Math.min(height[left], height[right]) * (right - left), maxArea);
            if (height[left] < height[right]) {
                preLeft = height[left];
                left++;
            } else {
                preRight = height[right];
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
