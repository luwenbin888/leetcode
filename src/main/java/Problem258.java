package easy;

/**
 Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

 For example:

 Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

 Follow up:
 Could you do it without any loop/recursion in O(1) runtime?
 */
public class Problem258 {
    public int addDigits(int num) {
        int result = method2(num);
        return result;
    }

    private int method1(int num) {
        String str = Integer.toString(num);
        while (str.length() > 1) {
            int sum = 0;
            for (int i = 0; i < str.length(); i++) {
                sum += Character.getNumericValue(str.charAt(i));
            }
            str = Integer.toString(sum);
        }

        return Integer.parseInt(str);
    }

    // from digit root math formula
    // dr(n) = n - 9 * floor((n-1)/9)
    private int method2(int num) {
        if (num == 0) return 0;

        int result = num - 9 * (int)Math.floor((num - 1) * 1.0 / 9);
        return result;
    }

    public static void main(String[] args) {
        Problem258 problem258 = new Problem258();
        int result = problem258.addDigits(38);
        System.out.println(result);
    }
}
