package in.kaixin.leetcode_byhand.sort;

import java.util.Arrays;

public class SortArray {
    //    https://leetcode-cn.com/problems/sort-an-array/
//    https://www.cnblogs.com/onepixel/p/7674659.html
//    public int[] sortArray(int[] nums) {
//        if (nums == null || nums.length == 1) {
//            return nums;
//        }
//        return nums;
//
//    }

    public int[] bubbleSort(int[] nums) {//比较相邻两个元素，如果大于第二个原属，就交换他们
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int v = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = v;
                }
            }
        }
        return nums;
    }

    public int[] sortArray(int[] nums) {

        if (nums == null || nums.length == 1) {
            return nums;
        }
        int start = 0;
        int end = nums.length - 1;
        if (start == end) {
            return nums;
        }
        quickSort(nums, start, end);
        return nums;
    }

    /**
     * 快排序
     *
     * @return
     */
    public void quickSort(int[] nums, int start, int end) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        if (start >= end) {
            return;
        }
        int lo = start;
        int lp = end;
        int v = nums[start];
        int flag = 1;//高位1 低位0；
        while (lo != lp) {
            if (flag == 1) {
                if (nums[lp] <= v) {
                    nums[lo] = nums[lp];
                    lo++;
                    flag = 0;
                } else {
                    lp--;
                }
            } else {
                if (nums[lo] > v) {
                    nums[lp] = nums[lo];
                    lp--;
                    flag = 1;

                } else {
                    lo++;
                }
            }
        }
        nums[lo] = v;
        quickSort(nums, start, lo - 1);
        quickSort(nums, lo + 1, end);
        return;
    }


//    public int[] sortArray(int[] nums) {
//
//        if (nums == null || nums.length == 1) {
//            return nums;
//        }
//        int start = 0;
//        int end = nums.length - 1;
//        if (start == end) {
//            return nums;
//        }
//        mergeSort(nums, start, end);
//        return nums;
//    }


    /**
     * 归并排序
     *
     * @return
     */
    public void mergeSort(int[] nums, int start, int end) {
        if (nums == null || nums.length == 1) {
            return;
        }
        if (end - start < 1) {
            return;
        }

        mergeSort(nums, start, (start + end) / 2);
        mergeSort(nums, (start + end) / 2 + 1, end);
        merge(nums, start, end);
    }

    public void merge(int[] nums, int start, int end) {
        int[] temp = new int[end - start + 1];
        int cursor = start, cursordown = (start + end) / 2 + 1;

        for (int i = 0; i <= end - start; i++) {
            if (cursor > (start + end) / 2) {
                temp[i] = nums[cursordown];
                cursordown++;
                continue;
            }
            if (cursordown > end) {
                //todo merge
                temp[i] = nums[cursor];
                cursor++;
                continue;
            }
            if (nums[cursor] >= nums[cursordown]) {
                temp[i] = nums[cursordown];
                cursordown++;
            } else {
                temp[i] = nums[cursor];
                cursor++;
            }
        }
        for (int i = start; i <= end; i++) {
            nums[i] = temp[i - start];
        }


    }


    /**
     * 插入排序
     *
     * @return
     */
    public int[] insertSort(int[] nums) {//找到已经排序好的队列，后续插入到正确的位置
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[i - 1]) {
                continue;
            } else {
                int v = nums[i];

                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] > v) {
                        nums[j + 1] = nums[j];
                        if (j == 0) {
                            nums[j] = v;
                            break;
                        }
                    } else {
                        nums[j + 1] = v;
                        break;
                    }
                }
            }
        }
        return nums;


    }


    public int[] insertSortUpgrade(int[] nums) {//找到已经排序好的队列，后续插入到正确的位置
        for (int i = 1; i < nums.length; i++) {
            int currentValue = nums[i];
            int preIndex = i - 1;
            while (preIndex >= 0 && nums[preIndex] > currentValue) {
                nums[preIndex + 1] = nums[preIndex];
                preIndex--;
            }
            nums[preIndex + 1] = currentValue;

        }
        return nums;


    }

    public static void main(String... args) {
        SortArray s = new SortArray();
        int[] nums = new int[]{5, 1, 1, 2, 0, 0};
//        Arrays.stream(s.sortArray(nums)).forEach(i -> System.out.print(i));
        Arrays.stream(s.sortArray(nums)).forEach(i -> System.out.print(i));

    }


}
