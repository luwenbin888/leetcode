/**
 Related to question Excel Sheet Column Title

 Given a column title as appear in an Excel sheet, return its corresponding column number.

 For example:

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28
 */
public class Problem171 {
    public int titleToNumber(String s) {
        int result = 0;
        int current = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int digit = s.charAt(i) - 'A' + 1;
            result += digit * Math.pow(26, current);
            current++;
        }

        return result;
    }

    public static void main(String[] args) {
        Problem171 problem171 = new Problem171();
        int result = problem171.titleToNumber("AAA");
        System.out.println(result);
    }
}
