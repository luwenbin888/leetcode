package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes

 This algorithm is used to find all primes below a number
 It does so by iteratively marking as composite (i.e., not prime) the multiples of each prime, starting with the first prime number, 2.
 The multiples of a given prime are generated as a sequence of numbers starting from that prime,
 with constant difference between them that is equal to that prime.
 This is the sieve's key distinction from using trial division to sequentially test each candidate number for divisibility by each prime.

 To find all the prime numbers less than or equal to a given integer n by Eratosthenes' method:

 1. Create a list of consecutive integers from 2 through n: (2, 3, 4, ..., n).
 2. Initially, let p equal 2, the smallest prime number.
 3. Enumerate the multiples of p by counting to n from 2p in increments of p, and mark them in the list (these will be 2p, 3p, 4p, ...; the p itself should not be marked).
 4. Find the first number greater than p in the list that is not marked. If there was no such number, stop. Otherwise, let p now equal this new number (which is the next prime), and repeat from step 3.
 5. When the algorithm terminates, the numbers remaining not marked in the list are all the primes below n.

 The sieve of Eratosthenes can be expressed in pseudocode, as follows:

 Input: an integer n > 1.

 Let A be an array of Boolean values, indexed by integers 2 to n,
 initially all set to true.

 for i = 2, 3, 4, ..., not exceeding √n:
 if A[i] is true:
 for j = i2, i2+i, i2+2i, i2+3i, ..., not exceeding n:
 A[j] := false.

 Output: all i such that A[i] is true.

 */
public class SieveOfEratosthenes {
    public List<Integer> findAllPrimes(int n) {
        boolean[] sieve = new boolean[n + 1];
        // make 2 ~ n as true
        for (int i = 2; i < sieve.length; i++) {
            sieve[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (sieve[i]) {
                int k = 0;
                int start = i * i;
                for (int j = start; j <= n; j = start + i * k) {
                    sieve[j] = false;
                    k++;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 2; i < sieve.length; i++) {
            if (sieve[i]) result.add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        SieveOfEratosthenes sieveOfEratosthenes = new SieveOfEratosthenes();
        List<Integer> result = sieveOfEratosthenes.findAllPrimes(10);
        for (int prime: result) {
            System.out.print(prime + " ");
        }
        System.out.println();
    }
}
