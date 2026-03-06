package in.kaixin.leetcode_byhand.str;

public class AddSpaces {
    //    https://leetcode.cn/problems/adding-spaces-to-a-string/?envType=daily-question&envId=2025-03-31
//    mid
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (idx < spaces.length && i == spaces[idx]) {
                sb.append(" ");
                idx++;
            }
            if (idx>=spaces.length){
                sb.append(s.substring(i,s.length()));
                break;
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

}

