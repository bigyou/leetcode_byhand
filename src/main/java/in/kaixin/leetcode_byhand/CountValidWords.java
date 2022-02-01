package in.kaixin.leetcode_byhand;

public class CountValidWords {
    //    https://leetcode-cn.com/problems/number-of-valid-words-in-a-sentence/

    /**
     * @param sentence
     * @param offset
     * @return
     */
    public boolean ischaracter(String sentence, int offset) {
        return offset < sentence.length() && sentence.charAt(offset) >= 'a' && sentence.charAt(offset) <= 'z';
    }

    public int getNextCharacterOffset(String sentence, int offset) {
        int j = offset;
        boolean findNextEmpt = true;
        for (; j < sentence.length(); j++) {
            if (findNextEmpt && sentence.charAt(j) != ' ') {
                continue;
            }
//            findNextEmpt = false;
//            if (!findNextEmpt && sentence.charAt(j) == ' ') {
//                continue;
//            }
            return j;
        }
        return sentence.length();
    }

    public int countValidWords(String sentence) {
        Character s = null;
        int amount = 0;
        int cnt = 0;
        boolean isword = false;
        int start = 0;
        while (sentence.charAt(start) == ' ') {
            start++;
        }
        for (int i = start; i < sentence.length(); ) {
            if (sentence.charAt(i) == ' ') {
                s = null;
                i++;
                cnt = 0;
                if (isword == true) {
                    amount++;
                    isword = false;
                }
                continue;
            }
            if (s == null) {
                s = sentence.charAt(i);
                if ((s >= 'a' && s <= 'z') ||
                        ((s == '.' || s == '!' || s == ',') &&
                                ((i == sentence.length() - 1 || sentence.charAt(i + 1) == ' ')
                                        && (i == 0 || sentence.charAt(i - 1) == ' ')))) {
                    isword = true;
                } else {

                    i = getNextCharacterOffset(sentence, i);
                    s = null;
                    cnt = 0;
                    isword = false;
                    continue;
                }
            }
            char c = sentence.charAt(i);

            if (c == '-') {
                if (i - 1 >= 0 && i + 1 < sentence.length()) {
                    if (sentence.charAt(i - 1) < 'a' || sentence.charAt(i - 1) > 'z' || sentence.charAt(i + 1) < 'a' || sentence.charAt(i + 1) > 'z' || cnt > 0) {
                        i = getNextCharacterOffset(sentence, i);
                        s = null;
                        cnt = 0;
                        isword = false;
                    } else {
                        cnt++;
                    }
                }
            } else if (c == '.' || c == '!' || c == ',') {
                if ((i + 1 < sentence.length() && sentence.charAt(i + 1) == ' ') || i == sentence.length() - 1) {

                } else {
                    s = null;
                    cnt = 0;
                    isword = false;
                    i = getNextCharacterOffset(sentence, i);
                }
            } else {
                if (c < 'a' || c > 'z') {
                    i = getNextCharacterOffset(sentence, i);
                    s = null;
                    cnt = 0;
                    isword = false;
                }
            }
            i++;
        }
        if (isword) {
            amount++;
        }
        return amount;
    }

    public static void main(String[] args) {
        CountValidWords countValidWords = new CountValidWords();
//        System.out.println(countValidWords.countValidWords("alice and  bob are playing stone-game10"));
//        System.out.println(countValidWords.countValidWords("e10"));
//        System.out.println(countValidWords.countValidWords("he bought 2 pencils, 3 era  sers, and 1  pencil-sharpener."));
        System.out.println(countValidWords.countValidWords(". ! 7hk  al6 l! aon49esj35la k3 7u2tkh  7i9y5  !jyylhppd et v- h!ogsouv 5"));

    }

}
