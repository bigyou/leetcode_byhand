package in.kaixin.leetcode_byhand.other;

import java.util.LinkedList;
import java.util.List;

public class MergeInterval {
//    https://leetcode-cn.com/problems/merge-intervals/

    public int[][] merge(int[][] intervals) {
        List<int[]> res = new LinkedList<>();
        int[] pre = null;
        quickSort(intervals, 0, intervals.length - 1);
        for (int i = 0; i < intervals.length; i++) {
            if (pre == null) {
                pre = intervals[i];
                continue;
            }
            if (pre[1] < intervals[i][0]) {
                res.add(pre);
                pre = intervals[i];
                continue;
            } else {
                pre[0] = Math.min(pre[0], intervals[i][0]);
                pre[1] = Math.max(pre[1], intervals[i][1]);
            }
        }
        if (pre != null) {
            res.add(pre);
        }
        int[][] result = new int[res.size()][2];
        int i = 0;
        for (int[] r : res) {
            result[i] = r;
            i++;
        }
        return result;
    }


    public void quickSort(int[][] intervals, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int[] v = intervals[start];
        int flag = 0;//0表示left 可以设置参数 flag=1表示右侧空闲
        while (left < right && right <= end) {
            if (flag == 0) {
                if (bigger(v, intervals[right])) {
                    intervals[left] = intervals[right];
                    left++;
                    flag = 1;
                } else {
                    right--;
                }
            } else {

                if (bigger(v, intervals[left])) {
                    left++;
                } else {
                    intervals[right] = intervals[left];
                    right--;
                    flag = 0;
                }
            }
        }
        intervals[left] = v;
        quickSort(intervals, start, left - 1);
        quickSort(intervals, left + 1, end);
    }

    public boolean bigger(int[] a, int[] b) {
        if (a[0] > b[0] || (a[0] == b[0] && a[1] > b[1])) {
            return true;
        }
        return false;
    }


    public void sort(int[][] intervals) {
        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = i; j < intervals.length; j++) {
                if (intervals[i][0] > intervals[j][0] ||
                        (intervals[i][0] == intervals[j][0] && intervals[i][1] > intervals[j][1])) {
                    int[] tem = intervals[i];
                    intervals[i] = intervals[j];
                    intervals[j] = tem;
                }
            }
        }
    }



    public static void main(String[] args) {
        MergeInterval mergeInterval = new MergeInterval();
        int[][] v = new int[][]{new int[]{1, 3}, new int[]{8, 10}, new int[]{2, 6}, new int[]{15, 18}};
        int[][] result = mergeInterval.merge(v);
    }

}
