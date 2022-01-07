package in.kaixin.leetcode_byhand;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
//        https://leetcode-cn.com/problems/next-permutation/
        if (nums == null || nums.length < 2) {
            return;
        }
        Integer index = null;
        Integer max = -1;
        Integer start = 0;
        Integer end = nums.length - 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            if (j < max) {
                break;
            }
            for (int i = j - 1; i >= 0; i--) {
                if (i < max) {
                    break;
                }
                if (nums[i] < nums[j]) {
                    index = i;
                    if (index > max) {
                        max = index;
                        start = i;
                        end = j;
                    }
                    break;
                }
            }
        }
        if (index != null) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start = start + 1;
        }


        sort(nums, start , nums.length - 1);
//        排序


    }

    public void sort(int[] num, int start, int end) {
        for (int i = start; i < end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (num[i] > num[j]) {
                    int tem = num[i];
                    num[i] = num[j];
                    num[j] = tem;
                }
            }
        }
    }

    public static void main(String... args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] varr = new int[]{5,4,7,5,3,2};
        nextPermutation.nextPermutation(varr);
        for (int i = 0; i < varr.length; i++) {
            System.out.print(varr[i]);
        }
    }
}
