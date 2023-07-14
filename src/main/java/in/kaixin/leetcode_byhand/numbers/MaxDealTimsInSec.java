package in.kaixin.leetcode_byhand.numbers;

/**
 * @Author bigyou
 * @Create 2023/7/12 19:25
 */
public class MaxDealTimsInSec {
//    https://leetcode.cn/problems/alternating-digit-sum/
//    easy
    public int alternateDigitSum(int n) {
        int v= 0;
        int flag=1;//
        while (true){
            if(n<10){
                if(flag>0){
                    return n+v;
                }else {
                    return n-v;
                }

            }else {
                v=v+flag*(n%10);
                flag=-1*flag;
                n=n/10;
            }
        }
    }
}
