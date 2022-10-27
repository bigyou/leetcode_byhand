package in.kaixin.leetcode_byhand.numbers;

import java.util.*;

public class ShortestSubarray {
//    https://leetcode.cn/problems/shortest-subarray-with-sum-at-least-k/

//    public int shortestSubarray(int[] nums, int k) {// 超时
//        long[] sumArr = sumArr(nums);
//        Integer min = Integer.MAX_VALUE;
//
//        for (int left = 0; left < sumArr.length - 1; left++) {
//            for (int right = left + 1; right < sumArr.length && right - left < min; right++) {
//                if (sumArr[right] - sumArr[left] >= k) {
//                    min = Math.min(min, right - left);
//                }
//            }
//        }
//
//        return min == Integer.MAX_VALUE ? -1 : min;
//    }

//    public int shortestSubarray(int[] nums, int k) {
//        Map<Long, List<Integer>> locationMap = new HashMap<>();
//        long[] sumArr = sumArr(nums, locationMap);
//        Integer min = null;
//        for (int i = 1; i < sumArr.length; i++) {
//            long v = sumArr[i] - k;
//            List<Integer> vLocations = locationMap.get(v);
//            if (vLocations != null && vLocations.size() > 0) {//
//                Iterator<Integer> iterator = vLocations.iterator();
//                while (iterator.hasNext()) {
//                    Integer next = iterator.next();
//                    if (next >= i) {
//                        break;
//                    } else {
//                        min = min == null ? i - next : Math.min(min, i - next);
//                    }
//                }
//            }
//        }
//        return min == null ? -1 : min;
//    }
//
//    public long[] sumArr(int[] nums, Map<Long, List<Integer>> locationMap) {
//        long[] sumArr = new long[nums.length + 1];
//        List<Integer> zeroLocations = new LinkedList<>();
//        zeroLocations.add(0);
//        locationMap.put(0L, zeroLocations);
//        for (int i = 0; i < nums.length; i++) {
//            sumArr[i + 1] = sumArr[i] + nums[i];
//            List<Integer> locationList = locationMap.get(sumArr[i + 1]);
//            if (locationList == null) {
//                locationList = new LinkedList<>();
//                locationMap.put(sumArr[i + 1], locationList);
//            }
//            locationList.add(i + 1);
//        }
//        return sumArr;
//    }


    //    public int shortestSubarray(int[] nums, int k) {
    // 虽然做了优化，但是也会超时
//        long[] sumArr = sumArr(nums);
//        long[] leftMin = leftMin(sumArr);
//        Integer min = Integer.MAX_VALUE;
//
//        for (int i = 1; i < sumArr.length; i++) {
//            if (sumArr[i] - leftMin[i - 1] < k) {//不存在解
//                continue;
//            }
//            for (int j = i - 1; j >= 0 && j > i - min; j--) {
//                if (sumArr[i] - sumArr[j] >= k) {
//                    min = i - j;
//                    break;
//                }
//            }
//        }
//
//
//        return min == Integer.MAX_VALUE ? -1 : min;
//    }
//
//    public long[] leftMin(long[] sumArr) {
//        long[] leftMin = new long[sumArr.length];
//        for (int i = 1; i < sumArr.length; i++) {
//            leftMin[i] = Math.min(leftMin[i - 1], sumArr[i]);
//        }
//        return leftMin;
//    }
//
//    public long[] sumArr(int[] nums) {
//        long[] sumArr = new long[nums.length + 1];
//        for (int i = 0; i < nums.length; i++) {
//            sumArr[i + 1] = sumArr[i] + nums[i];
//        }
//        return sumArr;
//    }
//
//
    public int shortestSubarray(int[] nums, int k) {
        long[] sumArr = sumArr(nums);
        Integer min = Integer.MAX_VALUE;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(0);
        for (int i = 1; i < sumArr.length; i++) {
            while (!deque.isEmpty() && sumArr[i] - sumArr[deque.getLast()] >= k) {
                min = Math.min(min, i - deque.pollLast());
            }
            while (!deque.isEmpty() && sumArr[deque.getFirst()] > sumArr[i]) {
                deque.pollFirst();
            }
            deque.addFirst(i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }


    public long[] sumArr(int[] nums) {
        long[] sumArr = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sumArr[i + 1] = sumArr[i] + nums[i];
        }
        return sumArr;
    }

    public static void main(String[] args) {
        ShortestSubarray shortestSubarray = new ShortestSubarray();
        int[] nums = new int[]{1, 2};
//        System.out.println(shortestSubarray.shortestSubarray(nums, 4));
//        System.out.println(shortestSubarray.shortestSubarray(new int[]{2, -1, 2}, 3));
//        System.out.println(shortestSubarray.shortestSubarray(new int[]{48, 99, 37, 4, -31}, 140));
        System.out.println(shortestSubarray.shortestSubarray(new int[]{17, 85, 93, -45, -21}, 150));

    }


}
