package in.kaixin.leetcode_byhand.other;

import java.util.*;

public class RangeFreqQuery {
    //    https://leetcode.cn/problems/range-frequency-queries/?envType=daily-question&envId=2025-02-18
//    mid
    Map<Integer, List<Integer>> indexMap;

    public RangeFreqQuery(int[] arr) {
        indexMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int v = arr[i];
            List<Integer> indexList = indexMap.get(v);
            if (indexList == null) {
                indexMap.put(v, new ArrayList<>());
                indexList = indexMap.get(v);
            }
            indexList.add(i);
//            indexMap.putIfAbsent(arr[i],new LinkedList<>());
//            indexMap.get(arr[i]).add(i);
        }
    }

    public int query(int left, int right, int value) {
        List<Integer> indexList = indexMap.getOrDefault(value, new ArrayList<>());
        if (indexList == null || indexList.size() == 0) {
            return 0;
        }
        if (indexList.get(0) > right || indexList.get(indexList.size() - 1) < left) {
            return 0;
        }
        int l = binarySearchL(indexList, left);
        int r = binarySearchR(indexList, right);
        int res = r - l;
        return res;
    }

    public int binarySearchL(List<Integer> list, int v) {
        int l = 0;
        int r = list.size() - 1;
        while (r > l) {
            int mid = (l + r) / 2;
            if (list.get(mid) >= v) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public int binarySearchR(List<Integer> list, int v) {
        int l = 0;
        int r = list.size() - 1;
        while (r >= l) {
            int mid = (l + r) / 2;
            if (list.get(mid) <= v) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

//    public int binarySearchL(int left, int right, List<Integer> list, int v) {
//        if (right - left < 2) {
//            if (list.get(left) >= v) {
//                return left;
//            } else {
//                return right;
//            }
//        }
//        int mid = (left + right) / 2;
//        if (list.get(mid) >= v) {
//            return binarySearchL(left, mid, list, v);
//        } else {
//            return binarySearchL(mid + 1, right, list, v);
//        }
//    }

    public int binarySearchR(int left, int right, List<Integer> list, int v) {
        if (right - left < 2) {
            if (list.get(right) <= v) {
                return right;
            } else {
                return left;
            }
        }
        int mid = (left + right) / 2;
        if (list.get(mid) > v) {
            return binarySearchR(left, mid - 1, list, v);
        } else {
            return binarySearchR(mid, right, list, v);
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        RangeFreqQuery r = new RangeFreqQuery(arr);
        int re = r.query(0, 99999, 1);
        System.out.println(re);


    }
}
