package easy;

/**
 Given an array of integers, every element appears twice except for one. Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class Problem136 {
    public int singleNumber(int[] nums) {
        int diff = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff ^= nums[i];
        }

        return diff;
    }

    public static void main(String[] args) {
        Problem136 problem136 = new Problem136();
        int[] nums = {1,9,3,1,3,5,6,6,5};
        int result = problem136.singleNumber(nums);
        System.out.println(result);
    }
}
