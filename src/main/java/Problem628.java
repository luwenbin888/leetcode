import java.util.Arrays;

/**
 Given an integer array, find three numbers whose product is maximum and output the maximum product.

 Example 1:

 Input: [1,2,3]
 Output: 6

 Example 2:

 Input: [1,2,3,4]
 Output: 24

 Note:

 The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
 Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.

 */
public class Problem628 {
    public int maximumProduct(int[] nums) {
        return method2(nums);
    }

    private int method1(int[] nums) {
        Arrays.sort(nums);

        int startMax = nums[0] * nums[1] * nums[nums.length - 1];
        int endMax = nums[nums.length - 3] * nums[nums.length - 2] * nums[nums.length - 1];
        return Math.max(startMax, endMax);
    }

    private int method2(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int num: nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            if (num < 0) {
                if (num < min1) {
                    min2 = min1;
                    min1 = num;
                }
                else if (num < min2) {
                    min2 = num;
                }
            }
        }

        if (min1 == Integer.MAX_VALUE) min1 = 0;
        if (min2 == Integer.MAX_VALUE) min2 = 0;


        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }

    public static void main(String[] args) {
        Problem628 problem628 = new Problem628();
        int result = problem628.maximumProduct(new int[] {1, 0, 100});
        System.out.println(result);
    }
}
