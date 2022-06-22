package in.kaixin.leetcode_byhand.other;

public class RandomPickWithWeight {
    int[] randomList = null;
    int[] randomListInUse = null;
    int cursor = 0;

    public RandomPickWithWeight(int[] w) {
        this.randomList = w;
        copy();

    }

    public int pickIndex() {
        if (cursor >= randomListInUse.length || (cursor == randomListInUse.length - 1 && randomListInUse[cursor] == 0)) {
            copy();
            cursor = 0;
        }
        int res=-1;
        while (cursor < randomListInUse.length) {
            if (randomListInUse[cursor] > 0) {
                randomListInUse[cursor] = randomListInUse[cursor] - 1;
                res=cursor;
                if(randomListInUse[cursor]==0){
                    cursor++;
                }
                break;
            }else {
                cursor++;
            }

        }
        return res;

    }

    public void copy() {
        if (randomListInUse == null) {
            randomListInUse = new int[randomList.length];
        }
        for (int i = 0; i < randomList.length; i++) {
            randomListInUse[i] = randomList[i];
        }
    }
}
