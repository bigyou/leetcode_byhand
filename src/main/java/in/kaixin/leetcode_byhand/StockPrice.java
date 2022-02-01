package in.kaixin.leetcode_byhand;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StockPrice {
    //TODO 未通过
    //    https://leetcode-cn.com/problems/stock-price-fluctuation/
//    Map<Integer, Integer> priceMap;
//    Map<Integer, Dnode> tsMap;
//    Integer currentPrice = null;
//    Integer currentts = null;
//    Dnode root;
//    Dnode tail;
//
//
//    public StockPrice() {
//        root = new Dnode();
//        root.setVal(-1);
//        tail = new Dnode();
//        tail.val = Integer.MAX_VALUE;
//        root.next = tail;
//        tail.pre = root;
//        tsMap = new HashMap<>();
//    }
//
//    public void update(int timestamp, int price) {
//        Dnode dnode = new Dnode();
//        dnode.setTime(timestamp);
//        dnode.setVal(price);
//        if (tsMap.containsKey(timestamp)) {
//            if (tsMap.get(timestamp).getVal() != price) {//继续更新
//                up(dnode);
//            }
//        } else {
//            add(dnode);
//        }
//        if (currentts == null) {
//            currentts = timestamp;
//            currentPrice = price;
//        } else {
//            if (timestamp >= currentts) {
//                currentts = timestamp;
//                currentPrice = price;
//            }
//        }
//    }
//
//    public int current() {
//        return currentPrice;
//
//    }
//
//    public int maximum() {
//        return tail.pre.val;
//
//    }
//
//    public int minimum() {
//        return root.next.val;
//
//    }
//
//    public void up(Dnode dnode) {
//        Dnode dnode1 = tsMap.get(dnode.getTime());
//        if (dnode1 != null) {
//            dnode1.pre.next = dnode1.next;
//            dnode1.next.pre = dnode1.pre;
//            dnode1.pre = null;
//            dnode1.next = null;
//        }
//        add(dnode);
//    }
//
//    public void add(Dnode node) {
//        Dnode cursor = root.next;
//        while (cursor != null) {
//            if (node.val >= cursor.val) {
//                cursor = cursor.next;
//                continue;
//            } else {
//                node.pre = cursor.pre;
//                cursor.pre.next = node;
//                node.next = cursor;
//                cursor.pre = node;
//                break;
//            }
//        }
//        tsMap.put(node.time, node);
//    }
    Integer currentPrice = null;
    Integer currentts = null;
    Map<Integer, Integer> tsPriceMap = new HashMap<>();
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    public StockPrice() {

    }

    public void update(int timestamp, int price) {
        if (currentts == null) {
            currentts = timestamp;
            currentPrice = price;
        } else if (timestamp >= currentts) {
            currentts = timestamp;
            currentPrice = price;
        }
        if (tsPriceMap.get(timestamp) != null) {
            treeMap.remove(tsPriceMap.get(timestamp));
        }
        treeMap.put(price, price);
        tsPriceMap.put(timestamp, price);


    }

    public int current() {
        return currentPrice;
    }

    public int maximum() {
        return treeMap.lastKey();

    }

    public int minimum() {
        return treeMap.firstKey();
    }

}

//class Dnode {
//    Dnode pre;
//    Dnode next;
//    int time;
//    int val;
//
//    public Dnode getPre() {
//        return pre;
//    }
//
//    public void setPre(Dnode pre) {
//        this.pre = pre;
//    }
//
//    public Dnode getNext() {
//        return next;
//    }
//
//    public void setNext(Dnode next) {
//        this.next = next;
//    }
//
//    public int getTime() {
//        return time;
//    }
//
//    public void setTime(int time) {
//        this.time = time;
//    }
//
//    public int getVal() {
//        return val;
//    }
//
//    public void setVal(int val) {
//        this.val = val;
//    }
//}
