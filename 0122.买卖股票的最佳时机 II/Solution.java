class Solution {
    // 法一：动态规划通用法
    // public int maxProfit(int[] prices) {
    //     int len = prices.length;
    //     if (len < 2) {
    //         return 0;
    //     }
    //     int[][] dp = new int[len][2];
    //     dp[0][1] -= prices[0];
    //     for (int i = 1; i < len; i++) {
    //         // 0：持有现金
    //         // 1：持有股票
    //         dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
    //         dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
    //     }
    //     return dp[len - 1][0];
    // }

    // 法二：贪心算法
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int result = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i - 1]) {
                result += prices[i] - prices[i - 1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] prices = {7,1,5,3,6,4};
        int result = sol.maxProfit(prices);
        System.out.println("result = " + result);
    }
}