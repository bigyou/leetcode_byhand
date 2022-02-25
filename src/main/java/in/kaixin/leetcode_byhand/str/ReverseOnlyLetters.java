package in.kaixin.leetcode_byhand.str;

public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }

        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            char l = arr[left];
            if (isNotChar(l)) {
                left++;
                continue;
            }
            char r = arr[right];
            if (isNotChar(r)) {
                right--;
                continue;
            }
            arr[left] = r;
            arr[right] = l;
            left++;
            right--;

        }
        return new String(arr);
    }

    public boolean isNotChar(char c) {
        boolean isc = (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
        return !isc;
    }

    public static void main(String[] args) {
        ReverseOnlyLetters reverseOnlyLetters = new ReverseOnlyLetters();
        String res = reverseOnlyLetters.reverseOnlyLetters("a-bC-dEf-ghIj");
        System.out.println(res.equals("j-Ih-gfE-dCba"));
        res = reverseOnlyLetters.reverseOnlyLetters("Test1ng-Leet=code-Q!");
        System.out.println(res.equals("Qedo1ct-eeLg=ntse-T!"));
        res = reverseOnlyLetters.reverseOnlyLetters("7_28]");
        System.out.println(res.equals("7_28]"));

    }


}
