package in.kaixin.leetcode_byhand.other;

public class DefangIPaddr {
    public static String defangIPaddr(String address) {
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<address.length();i++){
            char c=address.charAt(i);
            if(c=='.'){
                sb.append("[.]");
            }else {
                sb.append(c);
            }
        }
        return sb.toString();

    }

    public static String defangIPaddr1(String address) {
        String after = address.replace(".", "[.]");
        return after;

    }

    public static void main(String[] args) {
        System.out.println(defangIPaddr("12.12.12.12"));
    }
}
