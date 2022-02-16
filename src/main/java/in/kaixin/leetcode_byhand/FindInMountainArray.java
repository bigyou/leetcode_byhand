package in.kaixin.leetcode_byhand;

import java.util.HashMap;
import java.util.Map;

public class FindInMountainArray {

    public int findInMountainArray(int target, MountainArray mountainArr) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = doFind(target, mountainArr, 0, mountainArr.length() - 1, map);
//        findMaxIndex(mountainArr, map);
        return i;
    }

    public int getV(Map<Integer, Integer> map, int index, MountainArray mountainArray) {
//        Integer v = map.get(index);
//        if (v != null) {
//            return v;
//        }
        int v = mountainArray.get(index);
//        map.put(index, v);
        return v;

    }

    public int doFind(int target, MountainArray mountainArray, int start, int end, Map<Integer, Integer> map) {
        if (end == start) {
            return getV(map, start, mountainArray) == target ? start : -1;
        }
        if (end < start || start < 0 || end > mountainArray.length() - 1) {
            return -1;
        }
        if (end - start == 1) {
            if (getV(map, end, mountainArray) == target) {
                return end;
            }
            if (getV(map, start, mountainArray) == target) {
                return start;
            }
            return -1;
        }
        int endv = getV(map, end, mountainArray);
        int startv = getV(map, start, mountainArray);
        int diffstart = startv - target;
        int diffend = endv - target;
        if (diffstart == 0) {
            return start;
        }
//        if (diffend == 0) { 这个地方需要去掉，否则找到的不一定是第一个出现的位置
//            return end;
//        }
        if (diffstart > 0 && diffend > 0) {
            return -1;
        }
        if (diffstart < 0 && diffend < 0) {
            if (getV(map, end - 1, mountainArray) < endv) {//左侧上升
                return -1;
            }
        }
        int mid = (start + end) / 2;
        int midv = getV(map, mid, mountainArray);
        int preMid = mid - 1;
        int preMidv = getV(map, preMid, mountainArray);
        int res = Integer.MAX_VALUE;


        if (midv > preMidv) {//左侧上升
            if (midv == target) {
                res = mid;
            } else if (target == preMidv) {
                res = preMid;
            } else if (midv < target) {//在右侧
                res = doFind(target, mountainArray, mid + 1, end, map);
            } else {
                res = doFind(target, mountainArray, start, mid - 1, map);
                if (res == -1) {
                    res = doFind(target, mountainArray, mid + 1, end, map);
                }
                return res;
            }

        } else {//左侧在下降
            if (midv < target) {
                res = doFind(target, mountainArray, start, mid - 1, map);
                if (res == -1) {
                    if (midv == target) {
                        res = mid;
                    }
                }

            } else {
                res = doFind(target, mountainArray, start, mid - 1, map);
                if(res==-1){
                    if (midv == target) {
                        res = mid;
                    }
                }
                if (res == -1) {
                    res = doFind(target, mountainArray, mid + 1, end, map);
                }

            }

        }
        return res;
    }

//    public int findMaxIndex(MountainArray mountainArr, Map<Integer, Integer> map, int start, int end) {
//        if (start == end) {
//            return start;
//        }
//        int mid = (start + end) / 2;
//        int starv = getV(map, start, mountainArr);
//        int midv = getV(map, mid, mountainArr);
//        int endv = getV(map, end, mountainArr);
//        return 0;
//
//
//    }

    public static void main(String[] args) {
        FindInMountainArray findInMountainArray = new FindInMountainArray();
//        MountainArray mountainArray = new MountainArray(new int[]{3, 5, 3, 2, 0});
//        System.out.println(findInMountainArray.findInMountainArray(4, mountainArray));
        MountainArray mountainArray = new MountainArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 100, 99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 89, 88, 87, 86, 85, 84, 83, 82, 81, 80, 79, 78, 77, 76, 75, 74, 73, 72, 71, 70, 69, 68, 67, 66, 65, 64, 63, 62, 61, 60, 59, 58, 57, 56, 55, 54, 53, 52, 51, 50, 49, 48, 47, 46, 45, 44, 43, 42, 41, 40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2});
        System.out.println(findInMountainArray.findInMountainArray(102, mountainArray));
//
//
//        MountainArray mountainArray = new MountainArray(new int[]{1, 6, 11, 16, 21, 26, 31, 36, 41, 46, 51, 56, 61, 66, 71, 76, 81, 86, 91, 96, 101, 106, 111, 116, 121, 126, 131, 136, 141, 146, 151, 156, 161, 166, 171, 176, 181, 186, 191, 196, 201, 206, 211, 216, 221, 226, 231, 236, 241, 246, 251, 256, 261, 266, 271, 276, 281, 286, 291, 296, 301, 306, 311, 316, 321, 326, 331, 336, 341, 346, 351, 356, 361, 366, 371, 376, 381, 386, 391, 396, 401, 406, 411, 416, 421, 426, 431, 436, 441, 446, 451, 456, 461, 466, 471, 476, 481, 486, 491, 496, 501, 496, 491, 486, 481, 476, 471, 466, 461, 456, 451, 446, 441, 436, 431, 426, 421, 416, 411, 406});
//        System.out.println(findInMountainArray.findInMountainArray(481, mountainArray));

    }
}

