package in.kaixin.leetcode_byhand.str;

public class CheckOnesSegment {
    //    https://leetcode.cn/problems/check-if-binary-string-has-at-most-one-segment-of-ones/?envType=daily-question&envId=2026-03-06
//    easy
    public boolean checkOnesSegment(String s) {
        int find = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '1') {
                if(find==2){
                    return false;

                }
                if (find == 1 || find == 0) {//find==1表示连续1，find==0表示之前没有出现1
                    find = 1;
                }

            }else {
                if(find==1){//已经出现过1，这里出现0 ，将find修改为2
                    find=2;

                }
            }
        }
        return true;

    }
}
