package in.kaixin.leetcode_byhand.other;

import java.util.HashMap;
import java.util.Map;

public class ReachingPoints {
    //    https://leetcode-cn.com/problems/reaching-points/
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
//        boolean res = searchingForward(sx, sy, tx, ty, new HashMap<>());
        boolean res = searchingBackForward(sx, sy, tx, ty);
        return res;
    }

    public boolean searchingBackForward(int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) {
            return true;
        }
        if(sy>ty||sx>tx){
            return  false;
        }
        while (tx >= sx && ty >= sy) {
            if (tx == sx && ty == sy) {
                break;
            }
            if (ty > tx) {
                ty = ty % tx;
            } else if (ty < tx) {
                tx = tx % ty;
            } else {
                break;
            }
        }
        return (sx == tx && sy == ty) || (sx == tx && (sy - ty) % sx == 0) || (sy == ty && (sx - tx) % sy == 0);
    }

    /**
     * 正向的去求解，这里会嵌套太深导致堆栈溢出
     *
     * @param sx
     * @param sy
     * @param tx
     * @param ty
     * @param note
     * @return
     */
    public boolean searchingForward(int sx, int sy, int tx, int ty, Map<String, Boolean> note) {
        if (sx == tx && sy == ty) {
            return true;
        }
        if (note.containsKey(sx + "_" + sy)) {
            return note.get(sx + "_" + sy);
        }
        if (sx > tx || sy > ty) {
            return false;
        }
        boolean find = searchingForward(sx + sy, sy, tx, ty, note) || searchingForward(sx, sy + sx, tx, ty, note);
        note.put(sx + "_" + sy, find);
        return find;
    }


    public static void main(String[] args) {
        ReachingPoints reachingPoints = new ReachingPoints();
        System.out.println(true == reachingPoints.reachingPoints(1, 1, 3, 5));
        System.out.println(false == reachingPoints.reachingPoints(1, 1, 2, 2));
        System.out.println(true == reachingPoints.reachingPoints(1, 1, 1, 1));
        System.out.println(false == reachingPoints.reachingPoints(1, 1, 0, 4));
        System.out.println(true == reachingPoints.reachingPoints(44, 43, 921197891, 702724365));
        System.out.println(reachingPoints.reachingPoints(1, 2, 1000000000, 2));
        System.out.println(reachingPoints.reachingPoints(3, 7, 3, 4));
    }
}
