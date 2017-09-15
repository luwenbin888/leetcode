package easy;

/**
 Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

 Each letter in the magazine string can only be used once in your ransom note.

 Note:
 You may assume that both strings contain only lowercase letters.

 canConstruct("a", "b") -> false
 canConstruct("aa", "ab") -> false
 canConstruct("aa", "aab") -> true

 */
public class Problem383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] pool = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            int idx = magazine.charAt(i) - 'a';
            pool[idx]++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int idx = ransomNote.charAt(i) - 'a';
            if (--pool[idx] < 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Problem383 problem383 = new Problem383();
        boolean result = problem383.canConstruct("aaa", "aab");
        System.out.println(result);
    }
}
