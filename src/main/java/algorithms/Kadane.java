package algorithms;

/**
 In computer science, the maximum subarray problem is the task of finding the contiguous subarray within a one-dimensional array of numbers which has the largest sum.
 For example, for the sequence of values −2, 1, −3, 4, −1, 2, 1, −5, 4; the contiguous subarray with the largest sum is 4, −1, 2, 1, with sum 6.

 The problem was first posed by Ulf Grenander of Brown University in 1977, as a simplified model for maximum likelihood estimation of patterns in digitized images.
 A linear time algorithm was found soon afterwards by Jay Kadane of Carnegie Mellon University (Bentley 1984).

 https://www.java2blog.com/kadane-algorithm-in-java/
 */
public class Kadane {

    // this will work when all array elements are negative
    public int maxSubArraySum(int[] arr) {
        int max_ending_here = arr[0], max_so_far = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max_ending_here = Math.max(arr[i], max_ending_here + arr[i]);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }
        return max_so_far;
    }

    // this is the original Kadane algorithm, if the prefix sum is negative,
    // move the start to next element and reset the current sum to 0.
    private int method2(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currentMaxSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currentMaxSum = currentMaxSum + arr[i];
            if (currentMaxSum > maxSum) {
                maxSum = currentMaxSum;
            }

            if (currentMaxSum < 0) {
                currentMaxSum = 0;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1 -3, 4, -1, 2, 1, -5, 4};
        Kadane kadane = new Kadane();
        int result = kadane.method2(arr);
        System.out.println(result);
    }
}
