package easy;

import java.util.HashMap;
import java.util.Map;

/**
 Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution and you may not use the same element twice.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 */
public class Problem167 {
    public int[] twoSum(int[] numbers, int target) {
        return method1(numbers, target);
    }

    // time complexity o(n), constant space complexity
    private int[] method1(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        while (start < end) {
            int currentSum = numbers[start] + numbers[end];
            if (currentSum == target) {
                return new int[] {start + 1, end + 1};
            }
            else if (currentSum < target) {
                start++;
            }
            else {
                end--;
            }
        }

        return new int[] {-1, -1};
    }

    // time complexity o(n), space complexity o(n)
    private int[] method2(int[] numbers, int target) {
        Map<Integer, Integer> valWithIdx = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            valWithIdx.put(numbers[i], i);
        }

        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (valWithIdx.containsKey(complement))
                return new int[] {i + 1, valWithIdx.get(complement) + 1};
        }

        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,5,6,7,8,9};
        Problem167 problem167 = new Problem167();
        int[] result = problem167.twoSum(nums, 16);
        System.out.println("("+result[0]+","+result[1]+")");
    }
}
