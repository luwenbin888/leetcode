import java.util.HashMap;
import java.util.Map;

/**
 Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

 Examples:

 s = "leetcode"
 return 0.

 s = "loveleetcode",
 return 2.

 Note: You may assume the string contain only lowercase letters.
 */
public class Problem387 {
    public int firstUniqChar(String s) {
        Map<Character, Integer> charFreq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            charFreq.put(s.charAt(i),charFreq.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (charFreq.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Problem387 problem387 = new Problem387();
        int result = problem387.firstUniqChar("loveleetcode");
        System.out.println(result);
    }
}
