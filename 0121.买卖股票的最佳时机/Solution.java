class Solution {
    public int maxProfit(int[] prices) {
        int Max = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i - 1]);
            Max = Math.max(Max, prices[i] - minPrice);
        }
        return Max;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        Solution solution = new Solution();
        int result = solution.maxProfit(prices);
        System.out.println("result = " + result);
    }
}