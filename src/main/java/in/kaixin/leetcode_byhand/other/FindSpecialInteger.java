package in.kaixin.leetcode_byhand.other;

public class FindSpecialInteger {
    public int findSpecialInteger(int[] arr) {
        int offset = arr.length / 4;
        for (int i = 0; i < arr.length; ) {
            if (arr[i] == arr[i + offset]) {
                return arr[i];
            } else {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] != arr[i]) {
                        i = j;
                        break;
                    }
                }
            }
        }
        return -1;

    }
}
