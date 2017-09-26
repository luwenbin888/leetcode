/**
 Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100".
 */
public class Problem67 {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int len1 = a.length() - 1;
        int len2 = b.length() - 1;

        char carry = '0';
        char digit = '0';

        while (len1 >= 0 || len2 >= 0) {
            char digitA = len1 >= 0 ? a.charAt(len1) : '0';
            char digitB = len2 >= 0 ? b.charAt(len2) : '0';

            if (digitA == '0' && digitB == '0') {
                if (carry == '0') digit = '0';
                else {
                    digit = '1';
                    carry = '0';
                }
            }
            else if (digitA == '1' && digitB == '1') {
                if (carry == '0') {
                    digit = '0';
                    carry = '1';
                }
                else {
                    digit = '1';
                    carry = '1';
                }
            }
            else {
                if (carry == '0') digit = '1';
                else {
                    digit = '0';
                    carry = '1';
                }
            }
            result.insert(0, digit);
            len1--;
            len2--;
        }
        if (carry == '1') result.insert(0, carry);

        return result.toString();
    }

    public static void main(String[] args) {
        Problem67 problem67 = new Problem67();
        String result = problem67.addBinary("1", "11");
        System.out.println(result);
    }
}
