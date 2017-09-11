/**
 Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

 Note:

 The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 You could assume no leading zero bit in the integer’s binary representation.

 Example 1:

 Input: 5
 Output: 2
 Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.

 Example 2:

 Input: 1
 Output: 0
 Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 */
public class Problem476 {
    public int findComplement(int num) {
        int result = method2(num);
        return result;
    }

    private int method1(int num) {
        StringBuilder builder = new StringBuilder();
        while (num > 0) {
            builder.insert(0, (num & 1) ^ 1);
            num = num >> 1;
        }
        return Integer.parseInt(builder.toString(), 2);
    }

    private int method2(int num) {
        int i = 0;
        int sum = 0;
        while (num > 0) {
            int digit = (num & 1) ^ 1;
            if (digit > 0) sum = sum + (int)Math.pow(2, i);
            i++;
            num = num >> 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        Problem476 problem476 = new Problem476();
        int result = problem476.findComplement(5);
        System.out.println(result);
    }
}
