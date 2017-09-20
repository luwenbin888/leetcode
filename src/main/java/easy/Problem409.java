package easy;

import java.util.HashSet;
import java.util.Set;

/**
 Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

 This is case sensitive, for example "Aa" is not considered a palindrome here.

 Note:
 Assume the length of given string will not exceed 1,010.

 Example:

 Input:
 "abccccdd"

 Output:
 7

 Explanation:
 One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class Problem409 {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                maxLen += 2;
                set.remove(c);
            }
            else {
                set.add(c);
            }
        }

        maxLen = set.isEmpty()? maxLen: ++maxLen;
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "dccaccd";
        Problem409 problem409 = new Problem409();
        int maxLen = problem409.longestPalindrome(s);
        System.out.println(maxLen);
    }
}
