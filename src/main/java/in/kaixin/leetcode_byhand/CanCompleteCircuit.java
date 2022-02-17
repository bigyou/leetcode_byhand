package in.kaixin.leetcode_byhand;

public class CanCompleteCircuit {
//    https://leetcode-cn.com/problems/gas-station/
    public int canCompleteCircuit(int[] gas, int[] cost) {
//        int[] leftArr = new int[gas.length];
//        int left = 0;
//        for (int i = 0; i < gas.length; i++) {
//            leftArr[i] = gas[i] - cost[i];
//            left += leftArr[i];
//        }
//        if (left < 0) {
//            return -1;
//        }
        int start = -1;
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] - cost[i] < 0) {
                continue;
            }
            int gasLeft = 0;
            for (int j = 0; j < gas.length; j++) {
                int index = (i + j) % gas.length;
                gasLeft += gas[index] - cost[index];
                if (gasLeft < 0) {
                    i = i + j;
                    break;
                }
            }
            if (gasLeft >= 0) {
                start = i;
                break;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        CanCompleteCircuit canCompleteCircuit = new CanCompleteCircuit();
        System.out.println(canCompleteCircuit.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
    }
}
