import java.util.*;

/**
 Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

 Note:

 Each element in the result should appear as many times as it shows in both arrays.
 The result can be in any order.

 Follow up:

 What if the given array is already sorted? How would you optimize your algorithm?
 What if nums1's size is small compared to nums2's size? Which algorithm is better?
 What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class Problem350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            freq.put(nums1[i], freq.getOrDefault(nums1[i], 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            int currFreq = freq.getOrDefault(nums2[i], 0);
            if (currFreq > 0) {
                result.add(nums2[i]);
                freq.put(nums2[i], --currFreq);
                if (currFreq == 0) freq.remove(nums2[i]);
            }
        }

        int[] arr = new int[result.size()];
        int i = 0;
        for (int num: result) {
            arr[i++] = num;
        }

        return arr;
    }

    public static void main(String[] args) {
        Problem350 problem350 = new Problem350();
        int[] result = problem350.intersect(new int[] {1, 2, 2, 1}, new int[] {2, 2});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

        System.out.println();
    }
}
