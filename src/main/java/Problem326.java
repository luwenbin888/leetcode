/**
 Given an integer, write a function to determine if it is a power of three.

 Follow up:
 Could you do it without using any loop / recursion?
 */
public class Problem326 {
    public boolean isPowerOfThree(int n) {
        return method1(n);
    }

    private boolean method1(int n) {
        if (n < 3) return false;

        while (n % 3 == 0) {
            n = n / 3;
        }

        return n == 1;
    }

    private boolean method2(int n) {
        String base3 = Integer.toString(n, 3);
        return base3.matches("^10*$");
    }

    public static void main(String[] args) {
        Problem326 problem326 = new Problem326();
        boolean result = problem326.isPowerOfThree(9);
        System.out.println(result);
    }
}
