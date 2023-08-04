class Solution {
    public int numDecodings(String s) {
        // 前导0失效，返回0
        if (s.charAt(0) == '0') {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len + 1];
        // 初始状态
        dp[0] = 1;
        dp[1] = 1;
        char[] chs = s.toCharArray();
        for (int i = 2; i <= len; i++) {
            // dp[i]对应于s.charAt(i - 1)
            // nowOne表示当前一位代表的数字
            int nowOne = chs[i - 1] - '0';
            // nowTwo表示当前位置以及前一位置组成的两位数
            int nowTwo = (chs[i - 2] - '0') * 10 + chs[i - 1] - '0';
            if (nowOne > 0 && nowOne <= 9) {
                dp[i] = dp[i - 1];
            }
            if (nowTwo >= 10 && nowTwo <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "226";
        int result = sol.numDecodings(s);
        System.out.println("result = " + result);
    }
}