import java.util.HashSet;
import java.util.Set;

/**
 Write an algorithm to determine if a number is "happy".

 A happy number is a number defined by the following process: Starting with any positive integer,
 replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay),
 or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

 Example: 19 is a happy number

 pow(1,2) + pow(9,2) = 82
 pow(8,2) + pow(2,2) = 68
 pow(6,2) + pow(8,2) = 100
 pow(1,2) + pow(0,2) + pow(0,2) = 1
 */
public class Problem202 {
    public boolean isHappy(int n) {
        Set<Integer> current = new HashSet<>();
        while (n != 1 && !current.contains(n)) {
            current.add(n);
            int num = n;
            int sum = 0;
            while (num > 0) {
                int digit = num % 10;
                num = num / 10;
                sum += digit * digit;
            }
            n = sum;
            //current.add(n);
        }

        if (n == 1) return true;
        else return false;
    }

    public static void main(String[] args) {
        Problem202 problem202 = new Problem202();
        boolean result = problem202.isHappy(19);
        System.out.println(result);
    }
}
