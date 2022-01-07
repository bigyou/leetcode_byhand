package in.kaixin.leetcode_byhand.tree;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    //    https://leetcode-cn.com/problems/lru-cache/
    Map<Integer, ListNode> valueMap = new HashMap<>();
    Integer capacity = null;
    ListNode head;
    ListNode last;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        ListNode valueNode = valueMap.get(key);
        if (valueNode != null) {
            movetoHead(valueNode);
        }
        int value = valueNode != null ? valueNode.value : -1;
        return value;
    }

    public void put(int key, int value) {
        if (valueMap.containsKey(key)) {
            ListNode node = valueMap.get(key);
            valueMap.get(key).setValue(value);
            movetoHead(node);
        } else {//需要新加入元素
            ListNode node = new ListNode(key, value);
            valueMap.put(key, node);
            appendToHead(node);
        }
        removeNode();

    }

    public boolean appendToHead(ListNode node) {
        if (head == null) {//还没有元素
            head = node;
            last = node;
        } else {//不是最后一个元素
            node.pre = null;
            node.next = head;
            head.pre = node;
            head = node;
        }
        return true;

    }

    public boolean removeNode() {
        while (capacity < valueMap.size()) {
            Integer key = last.getKey();
            ListNode lastPre = last.getPre();
            lastPre.next = null;
            last.pre = null;
            last = lastPre;
            valueMap.remove(key);
        }
        return true;

    }

    /**
     * 移动node to head
     *
     * @param node
     * @return
     */
    public boolean movetoHead(ListNode node) {
        if (node.pre == null) {//头部节点
            return true;
        }
        ListNode pre = node.pre;
        ListNode next = node.next;
        pre.setNext(next);
        if (node.next == null) {//尾部节点
            last = pre;
        } else {
            next.setPre(pre);
        }
        node.next = head;
        head.pre = node;

        node.pre = null;
        head = node;
        return true;
    }

}

class ListNode {
    Integer key;
    Integer value;
    ListNode next;
    ListNode pre;

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public ListNode(Integer key, Integer value) {
        this.value = value;
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getPre() {
        return pre;
    }

    public void setPre(ListNode pre) {
        this.pre = pre;
    }

}
