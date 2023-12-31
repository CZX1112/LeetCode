class Solution {
    // 法一：动态规划
    // public String longestPalindrome(String s) {
    //     int len = s.length();
    //     if (len < 2)
    //         return s;
    //     // 最长子串
    //     int maxLen = 1;
    //     // 最长子串初始位置
    //     int begin = 0;
    //     // i为起始位置，j为终止位置
    //     boolean[][] dp = new boolean[len][len];
    //     // 长度为1的子串均满足
    //     for (int i = 0; i < len; i++)
    //         dp[i][i] = true;
    //     // 遍历子串长度，从2开始
    //     for (int L = 2; L <= len; L++) {
    //         // 遍历左边，范围比较宽泛
    //         for (int i = 0; i < len; i++) {
    //             // 如果右侧超边界，break
    //             int j = i + L - 1;
    //             if (j >= len)
    //                 break;
    //             // 边界字符不相等
    //             if (s.charAt(i) != s.charAt(j))
    //                 dp[i][j] = false;
    //             else {
    //                 if (j - i < 3)
    //                     dp[i][j] = true;
    //                 else
    //                     dp[i][j] = dp[i + 1][j - 1];
    //             }
    //             // 看要不要更新maxLen与begin
    //             if (dp[i][j] && (j - i + 1) > maxLen) {
    //                 maxLen = j - i + 1;
    //                 begin = i;
    //             }
    //         }
    //     }
    //     return s.substring(begin, begin + maxLen);
    // }

    // 法二：中心扩展算法
    public String longestPalindrome(String s) {
        if (s.length() < 2)
            return s;
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        String input = "cbbd";
        Solution solution = new Solution();
        String result = solution.longestPalindrome(input);
        System.out.println("Longest palindrome: " + result);
    }
}