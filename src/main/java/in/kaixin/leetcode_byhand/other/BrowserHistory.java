package in.kaixin.leetcode_byhand.other;

import java.util.ArrayList;
import java.util.Stack;

public class BrowserHistory {
    //    String[] list = new String[5000];
//    int cursor = 0;
//    int capacity = 1;
//
//    public BrowserHistory(String homepage) {
//        list[0] = homepage;
//    }
//
//    public void visit(String url) {
//        for (int i = cursor + 1; i < capacity; i++) {
//            list[i]= "";
//        }
//        list[cursor + 1]=url;
//        cursor++;
//        capacity = cursor + 1;
//    }
//
//    public String back(int steps) {
//        if (steps >= cursor) {
//            cursor = 0;
//        } else {
//            cursor -= steps;
//        }
//        return list[cursor];
//    }
//
//    public String forward(int steps) {
//        if (cursor + steps >= capacity) {
//            cursor = capacity - 1;
//        } else {
//            cursor += steps;
//        }
//        return list[cursor];
//    }
    Stack<String> visitStack = new Stack<>();
    Stack<String> backStack = new Stack<>();

    public BrowserHistory(String homepage) {
        visitStack.add(homepage);
    }

    public void visit(String url) {
        visitStack.add(url);
        backStack.clear();
    }

    public String back(int steps) {
        while (visitStack.size() > 1 && steps > 0) {
            String url = visitStack.pop();
            backStack.add(url);
            steps--;
        }
        return visitStack.peek();
    }

    public String forward(int steps) {
        while (backStack.size() > 0 && steps > 0) {
            visitStack.add(backStack.pop());
            steps--;
        }
        return visitStack.peek();
    }
}
