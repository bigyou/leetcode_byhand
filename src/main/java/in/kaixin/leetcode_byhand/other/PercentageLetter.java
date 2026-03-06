package in.kaixin.leetcode_byhand.other;

public class PercentageLetter {
    public int percentageLetter(String s, char letter) {
        int cnt=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==letter){
                cnt++;
            }
        }
        int res = cnt * 100 / s.length();
        return res;
    }
}
