class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            for (int j = 0; j <= n; j++)
                f[i][j] = false;
        // 解决a*b*这种问题
        for (int i = 1; i < n; i += 2) {
            if (p.charAt(i) == '*')
                f[0][i + 1] = true;
            else
                break;
        }
        f[0][0] = true;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if ((s.charAt(i - 1) == p.charAt(j - 1)) || p.charAt(j - 1) == '.')
                    f[i][j] = f[i - 1][j - 1];
                else if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.')
                        f[i][j] = f[i][j - 2];
                    else
                        f[i][j] = f[i][j - 1] || f[i][j - 2] || f[i - 1][j];
                }
            }
        }
        // for (int i = 0; i <= m; i++)
        // for (int j = 0; j <= n; j++)
        // System.out.println("f[" + i + "]" + "[" + j + "] = " + f[i][j]);
        return f[m][n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "aab", p = "c*a*b";
        System.out.println(sol.isMatch(s, p));
    }
}