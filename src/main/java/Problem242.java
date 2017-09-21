import java.util.HashMap;
import java.util.Map;

/**
 Given two strings s and t, write a function to determine if t is an anagram of s.

 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.

 Note:
 You may assume the string contains only lowercase alphabets.

 Follow up:
 What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class Problem242 {
    public boolean isAnagram(String s, String t) {
        return method2(s, t);
    }

    // This one can be used for Unicode string
    private boolean method1(String s, String t) {
        Map<Character, Integer> freq = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!freq.containsKey(c)) return false;
            int currFreq = freq.get(c);
            currFreq--;
            if (currFreq == 0) freq.remove(c);
            else freq.put(c, currFreq);
        }

        return freq.isEmpty();
    }

    private boolean method2(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;

        char[] c = new char[26];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i) - 'a']++;
            c[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < c.length; i++) {
            if (c[i] != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        Problem242 problem242 = new Problem242();
        boolean result = problem242.isAnagram(s, t);
        System.out.println(result);
    }
}
