/**
 Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

 Note:

 The length of both num1 and num2 is < 5100.
 Both num1 and num2 contains only digits 0-9.
 Both num1 and num2 does not contain any leading zero.
 You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class Problem415 {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();

        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;

        int carry = 0;
        int digit = 0;
        while (l1 >= 0 || l2 >= 0) {
            int digit1 = l1 >= 0? num1.charAt(l1) - '0' : 0;
            int digit2 = l2 >= 0? num2.charAt(l2) - '0' : 0;
            digit = digit1 + digit2 + carry;
            carry = digit / 10;
            digit = digit % 10;
            result.insert(0, digit);
            l1--;
            l2--;
        }

        if (carry > 0) {
            result.insert(0, carry);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Problem415 problem415 = new Problem415();
        String result = problem415.addStrings("3125", "456");
        System.out.println(result);
    }
}
