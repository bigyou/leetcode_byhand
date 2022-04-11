package in.kaixin.leetcode_byhand.str;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseRepresentations {
    //    https://leetcode-cn.com/problems/unique-morse-code-words/
    String[] codes = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
    public int uniqueMorseRepresentations(String[] words) {
        if(words.length<2){
            return words.length;
        }
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(codes[word.charAt(i) - 'a']);
            }
            String s = sb.toString();
            set.add(s);
        }
        return set.size();
    }

    public static void main(String[] args) {
        UniqueMorseRepresentations uniqueMorseRepresentations = new UniqueMorseRepresentations();
        System.out.println(uniqueMorseRepresentations.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
        System.out.println(uniqueMorseRepresentations.uniqueMorseRepresentations(new String[]{"a"}));
    }
}
