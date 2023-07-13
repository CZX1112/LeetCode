class Solution {
    // 方法：动态规划
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            }
            else {
                break;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
                else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s1 = "aa";
        String p1 = "a";
        boolean result1 = sol.isMatch(s1, p1);
        System.out.println("Input: s = " + s1 + ", p = " + p1);
        System.out.println("Output: " + result1);
        System.out.println();
        
        String s2 = "aa";
        String p2 = "*";
        boolean result2 = sol.isMatch(s2, p2);
        System.out.println("Input: s = " + s2 + ", p = " + p2);
        System.out.println("Output: " + result2);
        System.out.println();
        
        String s3 = "cb";
        String p3 = "?a";
        boolean result3 = sol.isMatch(s3, p3);
        System.out.println("Input: s = " + s3 + ", p = " + p3);
        System.out.println("Output: " + result3);
        System.out.println();
        
        String s4 = "adceb";
        String p4 = "*a*b";
        boolean result4 = sol.isMatch(s4, p4);
        System.out.println("Input: s = " + s4 + ", p = " + p4);
        System.out.println("Output: " + result4);
        System.out.println();
    }
}