/**
 Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 → 2
 [1,3,5,6], 2 → 1
 [1,3,5,6], 7 → 4
 [1,3,5,6], 0 → 0
 */
public class Problem35 {
    public int searchInsert(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int mid = 0;
        while (i <= j) {
            mid = (i + j) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) i = mid + 1;
            if (nums[mid] > target) j = mid - 1;
        }

        if (target < nums[0]) return 0;
        else if (target > nums[nums.length - 1]) return nums.length;
        else {
            if (nums[mid] < target) {
                return mid + 1;
            }
            else {
                return mid;
            }
        }
    }

    public static void main(String[] args) {
        Problem35 problem35 = new Problem35();
        int result = problem35.searchInsert(new int[] {1,3,5,6}, 0);

        System.out.println(result);
    }
}
