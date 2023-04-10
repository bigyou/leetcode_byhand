package in.kaixin.leetcode_byhand.link;

import java.util.PriorityQueue;

public class NextLargerNodes {
    public int[] nextLargerNodes(ListNode head) {
        PriorityQueue<NodeAndIndex> queue = new PriorityQueue<>((a, b) -> (a.node.val - b.node.val));
        ListNode cursor = head;
        Integer index = 0;

        int size=0;
        while (cursor!=null){
            cursor=cursor.next;
            size++;
        }
        cursor=head;
        int [] v= new int[size];

        while (cursor != null) {
            while (!queue.isEmpty()&&queue.peek().getNode().val< cursor.val){
                NodeAndIndex poll = queue.poll();
                v[poll.index]= cursor.val;
            }

            NodeAndIndex newNode = new NodeAndIndex(cursor, index++);
            queue.add(newNode);
            cursor=cursor.next;
        }
        while (!queue.isEmpty()){
            NodeAndIndex poll = queue.poll();
            v[poll.index]=0;

        }

        return v;

    }
}

class NodeAndIndex {
    ListNode node;
    Integer index;

    public NodeAndIndex(ListNode node, Integer index) {
        this.node = node;
        this.index = index;
    }

    public ListNode getNode() {
        return node;
    }

    public void setNode(ListNode node) {
        this.node = node;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}