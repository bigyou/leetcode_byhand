package in.kaixin.leetcode_byhand.other;

import in.kaixin.leetcode_byhand.test.Te;

import java.awt.*;

public class TextEditor {
    //    int nodeCapacity = 0;
    TextNode root = null;
    TextNode cursor = null;

    public TextEditor() {
        root = new TextNode();
        cursor = root;
    }

    public void addText(String text) {
        char[] arr = text.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            TextNode node = new TextNode();
            node.setS(arr[i] + "");
            if (cursor.next != null) {
                node.next = cursor.next;
                cursor.next.pre = node;
            }
            cursor.next = node;
            node.pre = cursor;
            cursor = node;
//            nodeCapacity++;
        }

    }

    public int deleteText(int k) {
        int res = 0;
        while (k > 0 && cursor.pre != null) {
            cursor.pre.next = cursor.next;
            if (cursor.next != null) {
                cursor.next.pre = cursor.pre;
            }
            TextNode del = cursor;
            cursor = cursor.pre;
            del.pre = null;
            del.next = null;
            k--;
            res++;
        }
        return res;
    }

    public String cursorLeft(int k) {
        while (cursor.pre != null && k > 0) {
            cursor = cursor.pre;
            k--;
        }
        return getOut(cursor);
    }

    public String getOut(TextNode cursor) {
        TextNode idx = new TextNode();
        idx.setPre(cursor.pre);
        idx.setNext(cursor.next);
        idx.setS(cursor.getS());
        String res = "";
        while (idx.pre != null && res.length() < 10) {
            res = idx.getS() + res;
            idx = idx.pre;
        }
        return res;
    }

    public String cursorRight(int k) {
        while (cursor.next != null && k > 0) {
            cursor = cursor.next;
            k--;
        }

        return getOut(cursor);
    }

    public static void main(String[] args) {
        TextEditor t = new TextEditor();
        t.addText("leetcode");
        System.out.println(t.deleteText(4));
        t.addText("practice");
        System.out.println(t.cursorRight(3));
        System.out.println(t.cursorLeft(8));
        System.out.println(t.deleteText(10));
        System.out.println(t.cursorLeft(2));
        System.out.println(t.cursorRight(6));
//                ["TextEditor", "addText", "deleteText", "addText", "cursorRight", "cursorLeft", "deleteText", "cursorLeft", "cursorRight"]
//[[], [""], [4], ["practice"], [3], [8], [10], [2], [6]]

    }
}


class TextNode {
    TextNode pre;
    TextNode next;
    String s;

    public TextNode getPre() {
        return pre;
    }

    public void setPre(TextNode pre) {
        this.pre = pre;
    }

    public TextNode getNext() {
        return next;
    }

    public void setNext(TextNode next) {
        this.next = next;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

}