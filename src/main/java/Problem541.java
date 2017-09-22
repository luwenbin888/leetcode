/**
 Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string.
 If there are less than k characters left, reverse all of them.
 If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.

 Example:

 Input: s = "abcdefg", k = 2
 Output: "bacdfeg"

 Restrictions:

 The string consists of lower English letters only.
 Length of the given string and k will in the range [1, 10000]
 */
public class Problem541 {
    public String reverseStr(String s, int k) {
        char[] tmpArr = s.toCharArray();
        int loop = s.length() / (2 * k);
        int remain = s.length() % (2 * k);

        int start = 0, end = -1;
        for (int i = 0; i < loop; i++) {
            start = end + 1;
            end = start + k - 1;
            reverseStr(tmpArr, start, end);
            end = start + 2 * k - 1;
        }

        if (remain < k) {
            reverseStr(tmpArr, end + 1, tmpArr.length - 1);
        }
        else if (remain < 2 * k) {
            reverseStr(tmpArr, end + 1, end + k);
        }

        return new String(tmpArr);
    }

    private void reverseStr(char[] cArr, int start, int end) {

        while (start < end) {
            char c = cArr[start];
            cArr[start] = cArr[end];
            cArr[end] = c;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Problem541 problem541 = new Problem541();
        String result = problem541.reverseStr("abcdefg", 2);
        System.out.println(result);
    }
}
