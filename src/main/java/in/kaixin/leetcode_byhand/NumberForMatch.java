package in.kaixin.leetcode_byhand;

public class NumberForMatch {
    //    https://leetcode-cn.com/problems/count-of-matches-in-tournament/
    public int numberOfMatches(int n) {
        int cnt = 0;
        int currentN = n;
        while (currentN > 1) {
            cnt += currentN / 2;
            if (currentN % 2 == 1) {
                currentN = currentN / 2 + 1;
            } else {
                currentN = currentN / 2;
            }


        }
        return cnt;
    }

    public static void main(String[] args) {
        NumberForMatch numberForMatch = new NumberForMatch();
        System.out.println(numberForMatch.numberOfMatches(14));
    }
}

