package in.kaixin.leetcode_byhand.str;

public class CheckDistances {
    public boolean checkDistances(String s, int[] distance) {
//        https://leetcode.cn/problems/check-distances-between-same-letters/
        int[] realDis = new int[26];
        for (int i = 0; i < 26; i++) {
            realDis[i] = -1;
        }
        for (int i=0;i<s.length();i++){
            char c =s.charAt(i);
            int idx = c-'a';
            if(realDis[idx]!=-1){
                int offset = i - realDis[idx]-1;
                if(distance[idx]!=offset){
                    return false;
                }
            }else {
                realDis[idx]=i;
            }

        }
        return true;

    }
}
