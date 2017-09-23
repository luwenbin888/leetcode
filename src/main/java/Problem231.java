/**
 Given an integer, write a function to determine if it is a power of two.
 */
public class Problem231 {
    public boolean isPowerOfTwo(int n) {
        return method2(n);
    }

    private boolean method1(int n) {
        if (n == 1) return true;
        if (n % 2 != 0) return false;

        while (n > 1 && n % 2 == 0) {
            n = n >> 1;
        }

        return n == 1;
    }

    // if n is power of 2, only one bit is 1, n - 1 will move that bit to the right, then n & (n - 1) = 0
    private boolean method2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        Problem231 problem231 = new Problem231();
        boolean result = problem231.isPowerOfTwo(8);
        System.out.println(result);
    }
}
