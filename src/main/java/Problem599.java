import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

 You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

 Example 1:

 Input:
 ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 Output: ["Shogun"]
 Explanation: The only restaurant they both like is "Shogun".

 Example 2:

 Input:
 ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 ["KFC", "Shogun", "Burger King"]
 Output: ["Shogun"]
 Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).

 Note:

 The length of both lists will be in the range of [1, 1000].
 The length of strings in both lists will be in the range of [1, 30].
 The index is starting from 0 to the list length minus 1.
 No duplicates in both lists.

 */
public class Problem599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            m.put(list1[i], i);
        }

        int minSumIdx = Integer.MAX_VALUE;
        List<Integer> idx = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            if (m.containsKey(list2[i])) {
                int sum = i + m.get(list2[i]);
                if (sum < minSumIdx) {
                    minSumIdx = sum;
                    idx.clear();
                    idx.add(i);
                }
                else if (sum == minSumIdx) {
                    idx.add(i);
                }
            }
        }

        String[] result = new String[idx.size()];
        for (int i = 0; i < idx.size(); i++) {
            result[i] = list2[idx.get(i)];
        }

        return result;
    }

    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};

        Problem599 problem599 = new Problem599();
        String[] result = problem599.findRestaurant(list1, list2);
        for (String str: result) {
            System.out.println(str);
        }
    }
}
