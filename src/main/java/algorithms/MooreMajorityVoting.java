package algorithms;

/**
 The Boyer–Moore majority vote algorithm is an algorithm for finding the majority of
 a sequence of elements using linear time and constant space.
 It is named after Robert S. Boyer and J Strother Moore, who published it in 1981,
 and is a prototypical example of a streaming algorithm.

 In its simplest form, the algorithm finds a majority element, if there is one: that is,
 an element that occurs repeatedly for more than half of the elements of the input.
 However, if there is no majority, the algorithm will not detect that fact, and will still output one of the elements.
 A version of the algorithm that makes a second pass through the data can be used to
 verify that the element found in the first pass really is a majority.

 The algorithm will not, in general, find the mode of a sequence (an element that has the most repetitions)
 unless the number of repetitions is large enough for the mode to be a majority.
 It is not possible for a streaming algorithm to find the most frequent element in less than linear space,
 when the number of repetitions can be small.
 */
public class MooreMajorityVoting
{
    public int mooreMajorVoting(int[] nums) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException("Array is empty");

        int major = Integer.MIN_VALUE, counter = 0;

        for (int num: nums) {
            if (counter == 0) {
                major = num;
                counter = 1;
            }
            else if (major == num) counter++;
            else counter--;
        }

        return major;
    }

    private boolean checkMajority(int[] nums, int major) {
        int majorCount = 0;
        for (int num: nums) {
            if (num == major) majorCount++;
        }

        return majorCount > nums.length / 2;
    }
}
