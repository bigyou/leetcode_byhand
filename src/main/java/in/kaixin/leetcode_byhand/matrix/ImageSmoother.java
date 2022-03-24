package in.kaixin.leetcode_byhand.matrix;

import com.alibaba.fastjson.JSON;

public class ImageSmoother {
    //    https://leetcode-cn.com/problems/image-smoother/
    public int[][] imageSmoother1(int[][] img) {
        if (img.length == 1 && img[0].length == 1) {
            return img;
        }
        int[][] res = new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[0].length; j++) {
                int v = caculateSmooth(img, i, j);
                res[i][j] = v;
            }
        }
        return res;
    }

    public int caculateSmooth(int[][] img, int x, int y) {
        int cnt = 0;
        Integer sum = null;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                Integer v = getv(img, x + i, y + j);
                if (v != null) {
                    cnt++;
                    sum = sum == null ? 0 + v : sum + v;
                }
            }
        }
        return sum / cnt;

    }

    public Integer getv(int[][] img, int x, int y) {
        if (x < 0 || x > img.length - 1) {
            return null;
        }
        if (y < 0 || y > img[0].length - 1) {
            return null;
        }
        return img[x][y];
    }

    public int[][] imageSmoother(int[][] img) {
        if (img.length == 1 && img[0].length == 1) {
            return img;
        }
        int[][] sum = new int[img.length][img[0].length];
        int[][] res = new int[img.length][img[0].length];

        for (int i = 0; i < img.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < img[0].length; j++) {
                rowSum += img[i][j];
                sum[i][j] = rowSum;
            }
        }

        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[0].length; j++) {
                res[i][j] = getSmoothValue(sum, i, j);
            }
        }
        return res;

    }

    public int getSmoothValue(int[][] sum, int x, int y) {
        int left = y - 1 < 0 ? 0 : y - 1;
        int right = y + 1 > sum[0].length - 1 ? sum[0].length - 1 : y + 1;
        int cnt = 0;
        int total = 0;
        for (int i = -1; i <= 1; i++) {
            if (x + i < 0) {
                continue;
            }
            if (x + i > sum.length - 1) {
                break;
            }
            cnt += right - left + 1;

            total += sum[x + i][right];
            if (left - 1 >= 0) {
                total -= sum[x + i][left - 1];
            }
        }
        return total / cnt;

    }


    public static void main(String[] args) {
        ImageSmoother imageSmoother = new ImageSmoother();
        System.out.println(JSON.toJSONString(imageSmoother.imageSmoother(new int[][]{{100, 200, 100}, {200, 50, 200}, {100, 200, 100}})));
    }

}
