package in.kaixin.leetcode_byhand.numbers;

/**
 * @Author bigyou
 * @Create 2023/10/18 20:37
 */
public class SumOfMultiples {
    //    https://leetcode.cn/problems/sum-multiples/description/?envType=daily-question&envId=2023-10-17
    public int sumOfMultiples(int n) {
        int t = 0;//3
        int f = 0;//5
        int s = 0;//7

        int res = 0;
        for (int i = 1; i <= n; i++) {
            t++;
            f++;
            s++;
            if (t == 3) {
                t = 0;
            }
            if (f == 5) {
                f = 0;
            }
            if (s == 7) {
                s = 0;
            }
            if(t==0||s==0||f==0){
                res+=i;
                System.out.println(i);
            }
        }
        return res;



    }
}
