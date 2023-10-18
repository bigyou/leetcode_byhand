package in.kaixin.leetcode_byhand.numbers;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author bigyou
 * @Create 2023/7/26 20:22
 */
public class HandleQuery {
    //    https://leetcode.cn/problems/handling-sum-queries-after-update/
//    mid
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        long sum = 0;
        for (int i : nums2) {
            sum += i;
        }
        int cnt = 0;
        for (int i : nums1) {
            if (i == 1) {
                cnt++;
            }
        }
        List<Long> res = new LinkedList<>();
//        int[] op = new int[nums1.length];
        for (int i = 0; i < queries.length; i++) {
            int[] p = queries[i];
            if (p[0] == 1) {
                for (int j = p[1]; j <= p[2]; j++) {
                    if (nums1[j] == 0) {
                        nums1[j] = 1;
                        cnt++;
                    } else {
                        cnt--;
                        nums1[j] = 0;
                    }
                }
            } else if (p[0] == 2) {
                sum += cnt * p[1];

            } else {//P[0]==3
                res.add(sum);
            }
        }
        long[] resArr = new long[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;

    }

    public static void main(String[] args) {
        HandleQuery h = new HandleQuery();
        long[] res = h.handleQuery(new int[]{0, 0, 0, 0, 1, 0, 1, 1, 1}, new int[]{35, 29, 21, 34, 8, 48, 22, 43, 37}, new int[][]{{1, 4, 7}, {3, 0, 0}, {2, 27, 0}, {3, 0, 0}, {1, 0, 3}, {3, 0, 0}, {2, 6, 0}, {1, 3, 8}, {2, 13, 0}, {3, 0, 0}, {3, 0, 0}, {3, 0, 0}, {2, 2, 0}, {2, 28, 0}, {3, 0, 0}, {3, 0, 0}, {2, 25, 0}, {3, 0, 0}, {3, 0, 0}, {1, 2, 5}});
        System.out.println(JSON.toJSONString(res));
    }

}
