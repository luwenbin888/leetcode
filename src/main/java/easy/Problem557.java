package easy;

/**
 Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

 Example 1:

 Input: "Let's take LeetCode contest"
 Output: "s'teL ekat edoCteeL tsetnoc"

 Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class Problem557 {

    // single space between words
    public String reverseWords(String s) {
        char[] sArr = s.toCharArray();
        int start = 0, end = -1;
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] == ' ' || i == sArr.length - 1) {
                if (sArr[i] == ' ') end = i - 1;
                else end = sArr.length - 1;

                int a = start, b = end;
                while (a < b) {
                    char tmp = sArr[a];
                    sArr[a] = sArr[b];
                    sArr[b] = tmp;
                    a++;
                    b--;
                }
                start = i + 1;
            }
        }

        return new String(sArr);
    }

    public static void main(String[] args) {
        Problem557 problem557 = new Problem557();
        String str = "Let's take LeetCode contest";
        String result = problem557.reverseWords(str);
        System.out.println(result);
    }
}
