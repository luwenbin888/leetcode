import java.util.*;

/**
 Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

 Note:
 Each element in the result must be unique.
 The result can be in any order.
 */
public class Problem349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        return method2(nums1, nums2);
    }

    // method1 is very slow when submit to leetcode
    private int[] method1(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        Arrays.stream(nums1).forEach(num -> nums1Set.add(num));

        Set<Integer> result = new HashSet<>();
        Arrays.stream(nums2).forEach(num -> {
            if (nums1Set.contains(num)) result.add(num);
        });

        //return result.stream().mapToInt(Number::intValue).toArray();
        int[] resultArr = new int[result.size()];
        int i = 0;
        for (int num: result) {
            resultArr[i++] = num;
        }

        return resultArr;
    }

    // time complexity o(n), space complexity o(n)
    private int[] method2(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for (int num: nums1) set.add(num);

        for (int num: nums2) {
            if (set.contains(num)) result.add(num);
        }

        int[] resultArr = new int[result.size()];
        int i = 0;
        for (int num: result) {
            resultArr[i++] = num;
        }

        return resultArr;
    }

    public static void main(String[] args) {
        int [] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        Problem349 problem349 = new Problem349();
        int[] result = problem349.intersection(nums1, nums2);
        Arrays.stream(result).forEach(num -> System.out.println(num));
    }
}
