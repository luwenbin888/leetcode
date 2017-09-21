/**
 We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
 Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.

 Example:

 Input: 28
 Output: True
 Explanation: 28 = 1 + 2 + 4 + 7 + 14

 Note: The input number n will not exceed 100,000,000. (1e8)
 */
public class Problem507 {
    public boolean checkPerfectNumber(int num) {
        if (num <= 0 || num == 1) return false;
        int sum = 1;
        int upper = (int)Math.sqrt(num);
        for (int i = 2; i <= upper; i++) {
            if (num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }

        return num == sum;
    }

    public static void main(String[] args) {
        Problem507 problem507 = new Problem507();
        boolean result = problem507.checkPerfectNumber(28);
        System.out.println(result);
    }
}
