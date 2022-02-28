//package in.kaixin.leetcode_byhand;
//
//import java.util.LinkedList;
//
//public class PushDominoes {
//    public String pushDominoes(String dominoes) {
//        LinkedList<PushPosition> opList = new LinkedList<>();
//        for (int i = 0; i < dominoes.length(); i++) {
//            char c = dominoes.charAt(i);
//            if (c == 'L' || c == 'R') {
//                PushPosition pushPosition = new PushPosition(i, c);
//                opList.add(pushPosition);
//            }
//        }
//        if (opList.size() == 0) {
//            return dominoes;
//        }
//        for (int i = 0; i < opList.size(); i++) {
//
//        }
//
//
//    }
//}
//
//class PushPosition {
//    int index;
//    char op;
//
//    public PushPosition(int index, char op) {
//        this.index = index;
//        this.op = op;
//    }
//
//    public int getIndex() {
//        return index;
//    }
//
//    public void setIndex(int index) {
//        this.index = index;
//    }
//
//    public char getOp() {
//        return op;
//    }
//
//    public void setOp(char op) {
//        this.op = op;
//    }
//}
//
