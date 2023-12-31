class Solution {
    // 动态规划算法
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        // 定临界值
        dp[0][0] = 0;
        // 第一列
        for (int i = 1; i <= len1; i++)
            dp[i][0] = dp[i - 1][0] + 1;
        // 第一行
        for (int i = 1; i <= len2; i++)
            dp[0][i] = dp[0][i - 1] + 1;
        // 动态规划
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String word1 = "horse";
        String word2 = "ros";
        int result = solution.minDistance(word1, word2);
        System.out.println("Output: " + result);
    }
}