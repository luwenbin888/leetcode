/**
 Given an unsorted array of integers, find the length of longest continuous increasing subsequence.

 Example 1:

 Input: [1,3,5,4,7]
 Output: 3
 Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
 Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.

 Example 2:

 Input: [2,2,2,2,2]
 Output: 1
 Explanation: The longest continuous increasing subsequence is [2], its length is 1.

 Note: Length of the array will not exceed 10,000.
 */
public class Problem674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        int previousNum = Integer.MAX_VALUE;
        int maxLen = 0;
        int currentLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (currentLen == 0) currentLen++;
            else {
                if (nums[i] > previousNum) currentLen++;
                else {
                    maxLen = Math.max(maxLen, currentLen);
                    currentLen = 1;
                }
            }
            previousNum = nums[i];
        }

        if (currentLen > 0) {
            maxLen = Math.max(maxLen, currentLen);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Problem674 problem674 = new Problem674();
        int result = problem674.findLengthOfLCIS(new int[] {2,2,2,2,2});
        System.out.println(result);
    }
}
