package in.kaixin.leetcode_byhand.other;

import java.util.*;

public class RandomizedSet {
    //    https://leetcode-cn.com/problems/insert-delete-getrandom-o1//
//    Map<Integer, DeNode> map;
//    DeNode head;
//    DeNode tail;
//    DeNode randomCursor;
//    Random random = new Random();
//
//    public RandomizedSet() {
//        head = null;
//        tail = null;
//        randomCursor = null;
//        map = new HashMap<>();
//    }
//
//    public boolean insert(int val) {
//        if (map.containsKey(val)) {
//            return false;
//        } else {
//            addNode(val);
//            return true;
//        }
//    }
//
//    public boolean remove(int val) {
//        DeNode deNode = map.get(val);
//        if (deNode == null) {
//            return false;
//        } else {
//            rmNode(deNode);
//            return true;
//        }
//
//    }
//
//
//    public int getRandom() {
//        int i = random.nextInt(map.size());
//        randomCursor = randomCursor == null ? head : randomCursor;
//        while (i > 0) {
//            if (randomCursor.next == null) {
//                randomCursor = head;
//            } else {
//                randomCursor = randomCursor.next;
//            }
//            i--;
//        }
//        return randomCursor.v;
//
//    }
//
//    public boolean addNode(int v) {
//        DeNode node = new DeNode();
//        node.v = v;
//        if (head == null) {
//            head = node;
//            tail = node;
//        } else {
//            node.pre = tail;
//            tail.next = node;
//            tail = node;
//        }
//        map.put(v, node);
//        return true;
//    }
//
//    public boolean rmNode(DeNode deNode) {
//        if (deNode == randomCursor) {// 这里需要处理 删除的节点是randomcursor 的情况
//            randomCursor = deNode.next;
//        }
//        map.remove(deNode.v);
//        if (head == deNode) {
//            head = deNode.next;
//            if (head != null) {
//                head.pre = null;
//            }
//            return true;
//        }
//        if (tail == deNode) {
//            tail = deNode.pre;
//            if (tail != null) {
//                tail.next = null;
//            }
//            return true;
//        }
//
//
//        deNode.next.pre = deNode.pre;
//        deNode.pre.next = deNode.next;
//        return true;
//    }


    Map<Integer, Integer> locationMap = null;
    List<Integer> valueList = null;
    Random random = new Random();

    public RandomizedSet() {
        this.locationMap = new HashMap<>();
        this.valueList = new LinkedList<>();
    }

    public boolean insert(int val) {
        if (locationMap.containsKey(val)) {
            return false;
        } else {
            locationMap.put(val, locationMap.size());
            valueList.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if (locationMap.containsKey(val)) {
            Integer index = locationMap.get(val);//要删除的数在数组中的位置

            if (index != valueList.size() - 1) {//删除的不是最后一个
                Integer lastv = valueList.remove(valueList.size() - 1);
                valueList.set(index, lastv);
                locationMap.put(lastv, index);
            } else {//删除的就是最后一个
                Integer lastv = valueList.remove(valueList.size() - 1);
            }


            locationMap.remove(val);
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        return valueList.get(random.nextInt(valueList.size()));
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();

        randomizedSet.insert(1);
        randomizedSet.remove(2);
        randomizedSet.insert(2);
        System.out.println(randomizedSet.getRandom());
        randomizedSet.remove(1);
        randomizedSet.insert(2);
        System.out.println(randomizedSet.getRandom());

//        randomizedSet.remove(0);
//        randomizedSet.remove(0);
//        randomizedSet.insert(0);
//        System.out.println(randomizedSet.getRandom());
//
//        randomizedSet.remove(0);
//        randomizedSet.insert(0);

//        randomizedSet.insert(3);
//        randomizedSet.insert(3);
//        System.out.println(randomizedSet.getRandom());
//        System.out.println(randomizedSet.getRandom());
//        randomizedSet.insert(1);
//        randomizedSet.remove(3);
//        System.out.println(randomizedSet.getRandom());
//        System.out.println(randomizedSet.getRandom());
//        randomizedSet.insert(0);
//        randomizedSet.remove(0);

    }


}

//class DeNode {
//    DeNode pre;
//    DeNode next;
//    int v;
//}
