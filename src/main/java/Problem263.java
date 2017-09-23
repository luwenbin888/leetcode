import java.util.HashSet;
import java.util.Set;

/**
 Write a program to check whether a given number is an ugly number.

 Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

 Note that 1 is typically treated as an ugly number.
 */
public class Problem263 {
    public boolean isUgly(int num) {
        if (num < 1) return false;
        if (num == 1) return true;

        Set<Integer> s = new HashSet<>();
        s.add(2);
        s.add(3);
        s.add(5);

        int upper = (int)Math.sqrt(num);
        for (int i = 1; i <= upper; i++) {
            if (num % i == 0) {
                int c = num / i;
                if (!s.contains(i) && isPrime(i)) return false;
                if (!s.contains(c) && isPrime(c)) return false;
            }
        }

        return true;
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;

        int upper = (int)Math.sqrt(num);
        for (int i = 2; i <= upper; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }

    // solution from leetcode
    public boolean method2(int num) {
        if(num==1) return true;
        if(num==0) return false;
        while(num%2==0) num=num>>1;
        while(num%3==0) num=num/3;
        while(num%5==0) num=num/5;
        return num==1;
    }

    public static void main(String[] args) {
        Problem263 problem263 = new Problem263();
        boolean result = problem263.isUgly(14);
        System.out.println(result);
    }
}
