package solution.sliding_window.easy;

/**
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">Task 121</a>
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int maxProfit = 0;
        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            } else {
                left = right;
            }
            right++;
        }
        return maxProfit;
    }
}
