package in.kaixin.leetcode_byhand.other;

import com.alibaba.fastjson.JSON;

public class PlatesBetweenCandles {
//    https://leetcode-cn.com/problems/plates-between-candles/
    public static void main(String[] args) {
        PlatesBetweenCandles platesBetweenCandles = new PlatesBetweenCandles();
        System.out.println(JSON.toJSONString(platesBetweenCandles.platesBetweenCandles("***|**|*****|**||**|*", new int[][]{{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}})));
        System.out.println(JSON.toJSONString(platesBetweenCandles.platesBetweenCandles("**|**|***|", new int[][]{{2, 5}, {5, 9}})));
    }

    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] res = new int[queries.length];
        int[] leftArr = dealLeft(s);
        int[] rightArr = dealright(s);
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            res[i] = leftArr[right] > rightArr[left] ? leftArr[right] - rightArr[left] : 0;
        }

        return res;
    }

    public int[] dealLeft(String s) {
        int[] arr = new int[s.length()];

        int leftCancelsLocation = -1;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (leftCancelsLocation == -1 && s.charAt(i) != '|') {
                continue;
            }
            if (s.charAt(i) == '|' && leftCancelsLocation == -1) {//这需要将第0个位置也放进去
                leftCancelsLocation = i;
                continue;
            }
            if (s.charAt(i) == '|') {
                cnt = cnt + i - leftCancelsLocation - 1;
                leftCancelsLocation = i;
            }
            arr[i] = cnt;
        }
        return arr;
    }

    public int[] dealright(String s) {
        int[] arr = new int[s.length()];

        int leftCancelsLocation = -1;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (leftCancelsLocation == -1 && s.charAt(i) != '|') {
                continue;
            }
            if (s.charAt(i) == '|' && leftCancelsLocation == -1) {//这需要将第0个位置也放进去
                leftCancelsLocation = i;
                continue;
            }
            if (s.charAt(i) == '|') {
                cnt = cnt + i - leftCancelsLocation - 1;

                for (int j = leftCancelsLocation + 1; j <= i; j++) {
                    arr[j] = cnt;
                }
                leftCancelsLocation = i;
            }
//            arr[i] = cnt;
        }
        for (int i = leftCancelsLocation + 1; i < arr.length; i++) {
            arr[i] = cnt;
        }
        return arr;
    }


//    public int[] platesBetweenCandles(String s, int[][] queries) {
//        int[] res = new int[queries.length];
//        Map<Integer, Integer> locationMap = dealStr2GetLocationList(s);
//        for (int i = 0; i < queries.length; i++) {
//            int left = queries[i][0];
//            int right = queries[i][1];
//            Integer leftCnt = null;
//            Integer rightCnt = null;
//
//            while (leftCnt == null && left < s.length()) {
//                if (locationMap.get(left) == null) {
//                    left++;
//                } else {
//                    leftCnt = locationMap.get(left);
//                    break;
//                }
//            }
//            while (rightCnt == null && right >= 0) {
//                if (locationMap.get(right) == null) {
//                    right--;
//                } else {
//                    rightCnt = locationMap.get(right);
//                    break;
//                }
//            }
//            if (leftCnt != null && rightCnt != null && rightCnt > leftCnt) {
//                res[i] = rightCnt - leftCnt;
//            }
//        }
//
//        return res;
//    }
//
//    public Map<Integer, Integer> dealStr2GetLocationList(String s) {
//        Map<Integer, Integer> candleLocations = new HashMap<>();
//
//        int leftCancelsLocation = -1;
//        int cnt = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (leftCancelsLocation == -1 && s.charAt(i) != '|') {
//                continue;
//            }
//            if (s.charAt(i) == '|' && leftCancelsLocation == -1) {//这需要将第0个位置也放进去
//                candleLocations.put(i, cnt);
//                leftCancelsLocation = i;
//                continue;
//            }
//            if (s.charAt(i) == '|') {
//                cnt = cnt + i - leftCancelsLocation - 1;
//                candleLocations.put(i, cnt);
//                leftCancelsLocation = i;
//            }
//        }
//        return candleLocations;
//    }

}

//class CandleLocation {
//    int x;
//    int platesCnt;
//
//    public CandleLocation(int x, int platesCnt) {
//        this.x = x;
//        this.platesCnt = platesCnt;
//    }
//}
