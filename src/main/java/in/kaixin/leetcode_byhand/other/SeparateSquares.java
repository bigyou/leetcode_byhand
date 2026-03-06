//package in.kaixin.leetcode_byhand.other;
//
//public class SeparateSquares {
////    https://leetcode.cn/problems/separate-squares-i/description/?envType=daily-question&envId=2026-01-13
////    mid
//
//
//    public double separateSquares(int[][] squares) {
//        int total = squares[0][2] * squares[0][2] + squares[1][2] * squares[1][2];
//        double half = total * 1.0 / 2;
//
//        int[] lon = squares[0][2] > squares[1][2] ? squares[0] : squares[1];
//        int[] sht = squares[0][2] > squares[1][2] ? squares[1] : squares[0];
//        int mix = (lon[1] + lon[2] < sht[1]) || (sht[1] + sht[2] < lon[1]) ? 0 : 1;
//        Double y = null;
//        if (mix == 0) {
//            if (sht[1] < lon[1]) {
//                double left = half - sht[2] * sht[2];
//                if (left == 0) {
//                    y = 1.0 * sht[1] + sht[2];
//                } else {
//                    y = lon[1] + left / lon[2];
//                }
//            } else {
//                y = lon[1] + half / lon[2];
//            }
//        } else {//有重叠
//            if (sht[1] + sht[2] / 2.0 > lon[1] + lon[2] / 2.0) {//上半部分
//                double button = (sht[1] - lon[1]) * lon[2];
//                if (button >= half) {//底部足够一半
//                    y = lon[1] + half / lon[2];
//                } else {//底部不足一半
//                    double left = (half - button) / (lon[2] + sht[2]);
//                    y = left + sht[1];
//                }
//
//            } else {//下半部分
//                double top = (lon[1] + lon[2] - sht[1] - sht[2]) * lon[2];
//                if (top >= half) {
//                    y = lon[1] + lon[2] - half / lon[2];
//                } else {
//                    y = sht[1] + sht[2] - (half - top) / (lon[2] + sht[2]);
//                }
//            }
//        }
//
//        return y;
//
//    }
//
//}
