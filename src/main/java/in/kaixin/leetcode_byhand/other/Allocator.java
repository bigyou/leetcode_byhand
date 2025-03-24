package in.kaixin.leetcode_byhand.other;

import java.util.*;

public class Allocator {
    //    https://leetcode.cn/problems/design-memory-allocator/?envType=daily-question&envId=2025-02-25
//    mid
    Map<Integer, Integer> usedMap = new HashMap<>();
    Map<Integer, List<Integer>> midMap = new HashMap<>();
    Map<Integer, Integer> freeMemMap = new HashMap<>();
    Map<Integer, Integer> freeMemReverseMap = new HashMap<>();
    SortedSet<Integer> seg = new TreeSet<>();

    public Allocator(int n) {
        freeMemMap.put(0, n - 1);
        freeMemReverseMap.put(n - 1, 0);
        seg.add(0);
    }

    public int allocate(int size, int mID) {
        for (Integer i : seg) {
            int start = i;
            Integer end = freeMemMap.get(i);
            int capacity = end - start + 1;
            if (capacity < size) {
                continue;
            } else {
                List<Integer> midList = midMap.getOrDefault(mID, new LinkedList<>());
                midList.add(start);
                midMap.putIfAbsent(mID, midList);
                freeMemMap.remove(i);
                freeMemReverseMap.remove(end);
                int endIdx = i + size - 1;
                usedMap.put(start, endIdx);
                seg.remove(i);
                if (capacity > size) {
                    freeMemMap.put(endIdx + 1, end);
                    freeMemReverseMap.put(end, endIdx + 1);
                    seg.add(endIdx + 1);
                }
                return i;
            }
        }
        return -1;
    }


    public int doFreeMem(int startIdx) {
        Integer endIdx = usedMap.get(startIdx);
        if (endIdx == null) {
            return 0;
        }
        Integer nextFreeEndIdx = freeMemMap.remove(endIdx + 1);

        if (nextFreeEndIdx != null) {
            seg.remove(endIdx + 1);
            freeMemReverseMap.remove(nextFreeEndIdx);
            freeMemMap.put(startIdx, nextFreeEndIdx);
            freeMemReverseMap.put(nextFreeEndIdx, startIdx);
        } else {
            freeMemMap.put(startIdx, endIdx);
            freeMemReverseMap.put(endIdx, startIdx);
        }
        int end = freeMemMap.get(startIdx);
        Integer preStartIdx = freeMemReverseMap.remove(startIdx - 1);

        if (preStartIdx != null) {
            freeMemMap.remove(preStartIdx);
            freeMemMap.put(preStartIdx, end);
            freeMemReverseMap.put(end, preStartIdx);
        } else {
            seg.add(startIdx);
        }
        return endIdx - startIdx + 1;
    }

    public int freeMemory(int mID) {
        List<Integer> startIdxList = midMap.remove(mID);
        if (startIdxList == null) {
            return 0;
        }
        int res = 0;
        for (Integer startIdx : startIdxList) {
            res += doFreeMem(startIdx);
        }
        return res;
    }

    public static void main(String[] args) {
//        10],[1,1],[1,2],[1,3],[2],[3,4],[1,1],[1,1],[1],[10,2],[7]
//        Allocator allocator = new Allocator(10);
//        System.out.println(allocator.allocate(1, 1));
//        System.out.println(allocator.allocate(1, 2));
//        System.out.println(allocator.allocate(1, 3));
//        System.out.println(allocator.freeMemory(2));
//        System.out.println(allocator.allocate(3, 4));
//        System.out.println(allocator.allocate(1, 1));
//        System.out.println(allocator.allocate(1, 1));
//        System.out.println(allocator.freeMemory(1));
//        System.out.println(allocator.allocate(10, 2));
//        System.out.println(allocator.freeMemory(7));

    }
}

