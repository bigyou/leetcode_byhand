package in.kaixin.leetcode_byhand.numbers;

/**
 * @Author bigyou
 * @Create 2023/7/5 20:26
 */
public class kItemsWithMaximumSum {
//    https://leetcode.cn/problems/k-items-with-the-maximum-sum/
    //water
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if(numOnes>=k){
            return k;
        }else if(numOnes+numZeros>=k){
            return numOnes;
        }else {
            return 2*numOnes - k+numZeros;
        }
    }
}
