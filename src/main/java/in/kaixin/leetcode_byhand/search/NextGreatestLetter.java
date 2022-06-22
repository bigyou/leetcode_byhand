package in.kaixin.leetcode_byhand.search;

public class NextGreatestLetter {
//    https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/
    public char nextGreatestLetter(char[] letters, char target) {
        Character character = doSearch(letters, 0, letters.length - 1, target);
        character = character == null ? letters[0] : character;
        return character;

    }

    public Character doSearch(char[] letters, int left, int right, char target) {


        if (letters[left] > target) {
            return letters[left];
        }
        if (letters[right] <= target) {
            return null;
        }
        if (left == right ) {
            return null;
        }
        int mid = (left + right) / 2;
        if (letters[mid] > target) {
            return doSearch(letters, left, mid, target);
        } else {
            return doSearch(letters, mid + 1, right, target);
        }
    }

    public static void main(String[] args) {
        NextGreatestLetter nextGreatestLetter = new NextGreatestLetter();
        System.out.println(nextGreatestLetter.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
        System.out.println(nextGreatestLetter.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
        System.out.println(nextGreatestLetter.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd'));
        System.out.println(nextGreatestLetter.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'g'));
        System.out.println(nextGreatestLetter.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));
        System.out.println(nextGreatestLetter.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'k'));
    }
}
