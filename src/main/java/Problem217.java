import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 Given an array of integers, find if the array contains any duplicates.
 Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 */
public class Problem217 {
    public boolean containsDuplicate(int[] nums) {
        return method2(nums);
    }

    private boolean method1(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num: nums) {
            int freq = freqMap.getOrDefault(num, 0);
            if (freq > 0) {
                return true;
            }

            freqMap.put(num, 1);
        }

        return false;
    }

    private boolean method2(int[] nums) {

        Arrays.sort(nums);

        for (int i = 0, j = i + 1; i < nums.length && j < nums.length; i++, j++) {
            if (nums[i] == nums[j]) return true;
        }

        return false;
    }
}
