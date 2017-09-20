package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 Example 1:
 Input: ["Hello", "Alaska", "Dad", "Peace"]
 Output: ["Alaska", "Dad"]
 Note:
 You may use one character in the keyboard more than once.
 You may assume the input string will only contain letters of alphabet.
 */
public class Problem500 {
    private final static String[] keyboard = {"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};

    private final static Map<Character, Integer> keyboardIndex = new HashMap<>();

    static {
        for (int i = 0; i < keyboard.length; i++) {
            String row = keyboard[i];
            for (int j = 0; j < row.length(); j++) {
                keyboardIndex.put(row.charAt(j), i);
            }
        }
    }

    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            int idx = -1;
            String currentWord = words[i].toUpperCase();
            for (int j = 0; j < currentWord.length(); j++) {
                if (idx == -1) {
                    idx = keyboardIndex.get(currentWord.charAt(j));
                }
                else if (idx != keyboardIndex.get(currentWord.charAt(j))) {
                    idx = -1;
                    break;
                }
            }

            if (idx >= 0) {
                result.add(words[i]);
            }
        }

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] arr = {"qwee"};
        Problem500 problem500 = new Problem500();
        String[] result = problem500.findWords(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
