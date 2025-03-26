package in.kaixin.leetcode_byhand.other;

import java.util.HashSet;
import java.util.Set;

public class Kavoiding {

    public int minimumSum(int n, int k) {
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        int cursor = n;
        for (int i = 1; i < n + 1; i++) {
            sum += i;
            set.add(i);
        }
        for (int i = 1; i < (k + 1) / 2; i++) {
            if (set.contains(k - i)) {
                set.remove(k - i);
                while (true) {
                    cursor++;
                    if(set.contains(k-cursor)){
                        continue;
                    }
                    set.add(cursor);
                    sum += -k + i + cursor;
                    break;
                }

            }
        }
        return sum;

    }


    public static void main(String[] args) {
        Kavoiding k = new Kavoiding();
//        System.out.println(k.minimumSum(5, 4));
//        System.out.println(k.minimumSum(2, 6));
        System.out.println(k.minimumSum(3, 5));
    }


}
