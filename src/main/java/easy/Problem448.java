package easy;

import java.util.*;

/**
 Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

 Find all the elements of [1, n] inclusive that do not appear in this array.

 Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

 Example:

 Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [5,6]

 */
public class Problem448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = method2(nums);
        return result;
    }

    // use a HashSet to store the count
    private List<Integer> method1(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> s = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            s.add(nums[i]);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!s.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }

    private List<Integer> method2(int[] nums) {
        List<Integer> result = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }

    private List<Integer> method3(int[] nums) {
        List<Integer> result = new LinkedList<>();

        int i = 0;
        while (i < nums.length) {
            int j = i;
            while (nums[j] > 0) {
                int val = nums[j];
                if (nums[val - 1] > 0) {
                    nums[j] = nums[val - 1];
                    nums[val - 1] = -1;
                }
                else {
                    break;
                }
            }
            i++;
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > 0) result.add(j + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        Problem448 problem448 = new Problem448();
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> result = problem448.findDisappearedNumbers(nums);
        result.forEach(num -> System.out.println(num));
    }
}
