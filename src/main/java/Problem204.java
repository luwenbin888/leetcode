import java.util.ArrayList;
import java.util.List;

/**
 Count the number of prime numbers less than a non-negative number, n.
 */
public class Problem204 {
    public int countPrimes(int n) {
        boolean[] sieve = new boolean[n];
        for (int i = 2; i < sieve.length; i++) {
            sieve[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(n - 1); i++) {
            if (sieve[i]) {
                int k = 0;
                int start = i * i;
                for (int j = start; j <= n - 1; j = start + i * k) {
                    sieve[j] = false;
                    k++;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < sieve.length; i++) {
            if (sieve[i]) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Problem204 problem204 = new Problem204();
        int result = problem204.countPrimes(11);
        System.out.println(result);
    }
}
