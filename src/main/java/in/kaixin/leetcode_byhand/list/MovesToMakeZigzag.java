package in.kaixin.leetcode_byhand.list;

public class MovesToMakeZigzag {
    //    https://leetcode.cn/problems/decrease-elements-to-make-array-zigzag/
    public int movesToMakeZigzag(int[] nums) {
        int ret = Math.min(moves(nums, 0), moves(nums, 1));
        return ret;
    }


    public int moves(int[] nums, int start) {
        int times = 0;
        for (int i = start; i < nums.length; i += 2) {
            int step = 0;
            if (i - 1 >= 0) {
                step = Math.max(step, nums[i] - nums[i - 1] + 1);
            }
            if (i + 1 < nums.length) {
                step = Math.max(step, nums[i] - nums[i + 1] + 1);
            }

            times += step;

        }
        return times;
    }


    public int[] copy(int[] nums) {
        int[] cp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            cp[i] = nums[i];
        }
        return cp;
    }

    public int moves2(int[] numes, int start) {
        int times = 0;
        for (int i = start; i < numes.length; ) {
            if (i - 1 >= 0) {
                if (numes[i] <= numes[i - 1]) {
                    times += numes[i - 1] - numes[i] + 1;
                    numes[i - 1] = numes[i] - 1;
                }
            }

            if (i + 1 < numes.length) {
                if (numes[i] <= numes[i + 1]) {
                    times += numes[i + 1] - numes[i] + 1;
                    numes[i + 1] = numes[i] - 1;
                }
            }
            i = i + 2;
        }
        System.out.println(times);
        return times;
    }


    public static void main(String... args) {
        int[] nums = new int[]{7, 4, 8, 9, 7, 7, 5};
        MovesToMakeZigzag zag = new MovesToMakeZigzag();
        System.out.println(zag.movesToMakeZigzag(nums));

    }

}
