import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
 Example 1:

 Input: [5, 4, 3, 2, 1]
 Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
 For the left two athletes, you just need to output their relative ranks according to their scores.

 Note:

 N is a positive integer and won't exceed 10,000.
 All the scores of athletes are guaranteed to be unique.
 */
public class Problem506 {
    public String[] findRelativeRanks(int[] nums) {
        int[] tmp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(tmp);
        Map<Integer, String> rank = new HashMap<>();
        int total = tmp.length;
        for (int i = 0; i < tmp.length; i++) {
            String prize = null;
            if (i == tmp.length - 3) {
                prize = "Bronze Medal";
            }
            else if (i == tmp.length - 2) {
                prize = "Silver Medal";
            }
            else if (i == tmp.length - 1) {
                prize = "Gold Medal";
            }
            else {
                prize = Integer.toString(total--);
            }
            rank.put(tmp[i], prize);
        }

        String[] result = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = rank.get(nums[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        Problem506 problem506 = new Problem506();
        String[] result = problem506.findRelativeRanks(nums);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

        System.out.println();
    }
}
