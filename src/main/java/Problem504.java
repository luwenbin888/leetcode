/**
 Given an integer, return its base 7 string representation.

 Example 1:

 Input: 100
 Output: "202"

 Example 2:

 Input: -7
 Output: "-10"

 Note: The input will be in range of [-1e7, 1e7].
 */
public class Problem504 {
    public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        boolean neg = num < 0;
        if (neg) num = - num;
        while (num >= 7) {
            int digit = num % 7;
            num = num / 7;
            sb.insert(0, digit);
        }

        sb.insert(0, num);

        if (neg) sb.insert(0, "-");

        return sb.toString();
    }

    public static void main(String[] args) {
        Problem504 problem504 = new Problem504();
        int num = -7;
        String result = problem504.convertToBase7(num);
        System.out.println(result);
    }
}
