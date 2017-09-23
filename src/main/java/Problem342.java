/**
 Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

 Example:
 Given num = 16, return true. Given num = 5, return false.

 Follow up: Could you solve it without loops/recursion?
 */
public class Problem342 {
    public boolean isPowerOfFour(int num) {
        return method1(num);
    }

    private boolean method1(int num) {
        return num > 0 && ((num & (num - 1)) == 0) && ((num & 0x55555555) == num);
    }

    private boolean method2(int num) {
        String base4 = Integer.toString(num, 4);
        return base4.matches("^10*$");
    }
}
