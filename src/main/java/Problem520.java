package easy;

/**
 Given a word, you need to judge whether the usage of capitals in it is right or not.

 We define the usage of capitals in a word to be right when one of the following cases holds:

 All letters in this word are capitals, like "USA".
 All letters in this word are not capitals, like "leetcode".
 Only the first letter in this word is capital if it has more than one letter, like "Google".

 Otherwise, we define that this word doesn't use capitals in a right way.

 Example 1:

 Input: "USA"
 Output: True

 Example 2:

 Input: "FlaG"
 Output: False

 */
public class Problem520 {
    public boolean detectCapitalUse(String word) {
        int lowerCnt = 0;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            if (Character.isLowerCase(word.charAt(i))) lowerCnt++;
        }

        return (lowerCnt == len) || (lowerCnt == len - 1 && Character.isUpperCase(word.charAt(0))) || (lowerCnt == 0);
    }

    public static void main(String[] args) {
        Problem520 problem520 = new Problem520();
        String str = "abc";
        boolean result = problem520.detectCapitalUse(str);
        System.out.println(result);
    }
}
