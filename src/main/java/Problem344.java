/**
 Write a function that takes a string as input and returns the string reversed.

 Example:
 Given s = "hello", return "olleh".
 */
public class Problem344 {
    public String reverseString(String s) {
        char[] tempArr = s.toCharArray();
        for (int start = 0, end = s.length() - 1; start < end; start++, end--) {
            char tmp = tempArr[start];
            tempArr[start] = tempArr[end];
            tempArr[end] = tmp;
        }

        return new String(tempArr);
    }

    public static void main(String[] args) {
        Problem344 problem344 = new Problem344();
        String s = "hello";
        String result = problem344.reverseString(s);
        System.out.println(result);
    }
}
