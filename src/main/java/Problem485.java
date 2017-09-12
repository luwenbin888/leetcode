/**
 * Created by luwenbin888 on 12/09/2017.
 */
public class Problem485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOneLen = -1;
        int currentOneLen = 0;

        for (int num: nums) {
            if (num == 0) {
                maxOneLen = Math.max(maxOneLen, currentOneLen);
                currentOneLen = 0;
            }
            else {
                currentOneLen += num;
            }
        }

        maxOneLen = Math.max(maxOneLen, currentOneLen);

        return maxOneLen;
    }

    public static void main(String[] args) {
        Problem485 problem485 = new Problem485();
        int[] nums = {1,1,0,1,1,1};
        int maxOneLen = problem485.findMaxConsecutiveOnes(nums);
        System.out.println(maxOneLen);
    }
}
