/**
 Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

 Example 1:

 Input: [7, 1, 5, 3, 6, 4]
 Output: 5

 max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)

 Example 2:

 Input: [7, 6, 4, 3, 1]
 Output: 0

 In this case, no transaction is done, i.e. max profit = 0.
 */
public class Problem121 {

    public int maxProfit(int[] prices) {
        return method2(prices);
    }

    // O(n*n), TLE
    private int method1(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int currentProfit = Integer.MIN_VALUE;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    currentProfit = Math.max(prices[j] - prices[i], currentProfit);
                }
            }

            if (currentProfit == Integer.MIN_VALUE) currentProfit = 0;
            maxProfit = Math.max(currentProfit, maxProfit);
        }

        return maxProfit;
    }

    private int method2(int[] prices) {
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;

        for (int price: prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            else {
                if (price - minPrice > maxProfit) {
                    maxProfit = price - minPrice;
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Problem121 problem121 = new Problem121();
        int result = problem121.maxProfit(new int[] {7, 1, 5, 3, 6, 4});
        System.out.println(result);
    }
}
