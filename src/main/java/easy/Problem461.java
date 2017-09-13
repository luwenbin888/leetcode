package easy;

/**
 The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

 Given two integers x and y, calculate the Hamming distance.
 Example:

 Input: x = 1, y = 4

 Output: 2

 Explanation:
 1   (0 0 0 1)
 4   (0 1 0 0)
        ↑   ↑

 The above arrows point to positions where the corresponding bits are different.

 */
public class Problem461 {

    public int hammingDistance(int x, int y) {
        int hammingDistance = method2(x, y);
        return hammingDistance;
    }

    private int method1(int x, int y) {
        int hammingDist = 0;
        while (x > 0 || y > 0) {
            int digitX = x & 1;
            int digitY = y & 1;
            if ((digitX ^ digitY) == 1) hammingDist++;
            x = x >> 1;
            y = y >> 1;
        }

        return hammingDist;
    }

    private int method2(int x, int y) {
        int xor = x ^ y;
        int hammingDist = 0;
        while (xor > 0) {
            hammingDist += (xor & 1);
            xor >>= 1;
        }

        return hammingDist;
    }

    public static void main(String[] args) {
        Problem461 problem461 = new Problem461();
        int hammingDist = problem461.hammingDistance(2, 6);
        System.out.println(hammingDist);
    }
}
