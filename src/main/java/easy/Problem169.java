package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.
*/

public class Problem169 {
    public int majorityElement(int[] nums) {
        return method1(nums);
    }

    // sort and take element with index = n/2
    // O(logn) for sorting
    private int method1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    // disk space o(n), put into a Map
    // time complexity O(n)
    private int method2(int[] nums) {
        Map<Integer, Integer> numWithFreq = new HashMap<>();
        int maxFreq = Integer.MIN_VALUE;
        int maxFreqVal = -1;
        for (int num: nums) {
            numWithFreq.put(num, numWithFreq.getOrDefault(num, 0) + 1);
            int newFreq = numWithFreq.get(num);
            if (newFreq > maxFreq) {
                maxFreq = newFreq;
                maxFreqVal = num;
            }

            if (maxFreq > nums.length / 2) {
                maxFreqVal = num;
                break;
            }
        }
       return maxFreqVal;
    }

    /*
    The algorithm maintains in its local variables a sequence element and a counter, with the counter initially zero.
    It then processes the elements of the sequence, one at a time.
    When processing an element x, if the counter is zero, the algorithm stores x as its remembered sequence element and sets the counter to one.
    Otherwise, it compares x to the stored element and either increments the counter (if they are equal) or decrements the counter (otherwise).
    At the end of this process, if the sequence has a majority, it will be the element stored by the algorithm.
    This can be expressed in pseudocode as the following steps:

    Initialize an element m and a counter i with i = 0
    For each element x of the input sequence:
    If i = 0, then assign m = x and i = 1
    else if m = x, then assign i = i + 1
    else assign i = i − 1
    Return m

    Even when the input sequence has no majority, the algorithm will report one of the sequence elements as its result.
    However, it is possible to perform a second pass over the same input sequence in order to count the number of times the reported element occurs and
    determine whether it is actually a majority.
    This second pass is needed, as it is not possible for a sublinear-space algorithm to determine whether
    there exists a majority element in a single pass through the input.
    */
    // Boyer–Moore majority vote algorithm
    private int method3(int[] nums) {
        int counter = 0, majorityElem = -1;
        for (int num: nums) {
            if (counter == 0) {
                majorityElem = num;
                counter = 1;
            }
            else if (majorityElem == num) {
                counter++;
            }
            else {
                counter--;
            }
        }

        return majorityElem;
    }

    public static void main(String[] args) {
        Problem169 problem169 = new Problem169();
        int result = problem169.method3(new int[] {1,2,1,1,1,1});
        System.out.println(result);
    }
}
