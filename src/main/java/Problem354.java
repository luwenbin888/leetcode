import java.util.HashSet;
import java.util.Set;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.

 Example 1:
 Given s = "hello", return "holle".

 Example 2:
 Given s = "leetcode", return "leotcede".

 Note:
 The vowels does not include the letter "y".
 */
public class Problem354 {

    final static char[] vowels = {'a','e','i','o','u'};
    final static Set<Character> vowelChars = new HashSet<>();

    static {
        for (char c: vowels) {
            vowelChars.add(c);
            vowelChars.add(Character.toUpperCase(c));
        }
    }

    public String reverseVowels(String s) {
        char[] tmpArr = s.toCharArray();
        int i = 0, j = tmpArr.length - 1;
        while (i < j) {
            while (i < tmpArr.length && !vowelChars.contains(tmpArr[i])) i++;
            while (j >= 0 && !vowelChars.contains(tmpArr[j])) j--;

            if (i < j) {
                char tmp = tmpArr[i];
                tmpArr[i] = tmpArr[j];
                tmpArr[j] =  tmp;
            }

            i++;
            j--;
        }

        return new String(tmpArr);
    }

    public static void main(String[] args) {
        Problem354 problem354 = new Problem354();
        String result = problem354.reverseVowels(".,");
        System.out.println(result);
    }
}
