package easy;

import java.util.Arrays;

/**
 Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

 Note:
 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.
 */
public class Problem283 {
    public void moveZeroes(int[] nums) {
        int nextIdx = 0;
        for(int num: nums) {
            if (num != 0) {
                nums[nextIdx++] = num;
            }
        }

        for (int i = nextIdx; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int nums[] = {0, 1, 0, 3, 12};
        Problem283 problem283 = new Problem283();
        problem283.moveZeroes(nums);

        Arrays.stream(nums).forEach(num -> System.out.print(num + ","));
        System.out.println();
    }
}
