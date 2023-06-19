# [5.最长回文子串](https://leetcode.cn/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/)

`时间：2023.6.19`

## 题目

给你一个字符串 `s`，找到 `s` 中最长的回文子串。
如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。

**示例1：**

```
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
```

**示例2：**

```
输入：s = "cbbd"
输出："bb"
```

## 代码

#### 方法一：动态规划

##### 思路

对于一个子串而言，如果它是回文串，并且长度大于2，那么将它首尾的两个字母去除之后，它仍然是个回文串。例如对于字符串"ababa"，如果已经知道bab"是回文串，那么"ababa"一定是回文串，因为首尾一致。

可以用动态规划方法解决本题。用P(i,j)表示字符串s的第i到j个字母组成的串（表示为s[i:j]）是否为回文串：

P(i,j)=true if 子串Si...Sj是回文串

那么可以写出动态规划的转移方程：

P(i,j) = P(i + 1, j - 1) ^ (Si == Sj)

也就是说，只有s[i + 1: j -1]是回文串，且s的第i和j个字母相同时，s[i:j]才是回文串。

动态规划的边界条件为：

P(i,i) = true

P(i, i + 1) = (Si == Si+1)

最终的答案即为所有P(i,j)=true中j-i+1（即子串长度）的最大值。

##### 代码

```java
class Solution {
    // 法一：动态规划
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;
        // 最长子串
        int maxLen = 1;
        // 最长子串初始位置
        int begin = 0;
        // i为起始位置，j为终止位置
        boolean[][] dp = new boolean[len][len];
        // 长度为1的子串均满足
        for (int i = 0; i < len; i++)
            dp[i][i] = true;
        // 遍历子串长度，从2开始
        for (int L = 2; L <= len; L++) {
            // 遍历左边，范围比较宽泛
            for (int i = 0; i < len; i++) {
                // 如果右侧超边界，break
                int j = i + L - 1;
                if (j >= len)
                    break;
                // 边界字符不相等
                if (s.charAt(i) != s.charAt(j))
                    dp[i][j] = false;
                else {
                    if (j - i < 3)
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i + 1][j - 1];
                }
                // 看要不要更新maxLen与begin
                if (dp[i][j] && (j - i + 1) > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
```

##### 复杂度分析

- 时间复杂度：O(n^2)，其中 n 是字符串的长度。动态规划的状态总数为O(n^2)，对于每个状态，我们需要转移的时间为O(1)。
- 空间复杂度：O(n^2)，即存储动态规划状态需要的空间。

#### 方法二：中心扩展算法

##### 思路

可以发现，**所有的状态在转移的时候的可能性都是唯一的**。也就是说，我们可以从每一种边界情况开始「扩展」，也可以得出所有的状态对应的答案。

边界情况即为子串长度为 1 或 2 的情况。我们枚举每一种边界情况，并从对应的子串开始不断地向两边扩展。如果两边的字母相同，我们就可以继续扩展，例如从P(i+1, j-1)扩展到P(i,j)；如果两边的字母不同，我们就可以停止扩展，因为在这之后的子串都不能是回文串了。

##### 代码

```java
class Solution {
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
}
```

##### 复杂度分析

- 时间复杂度：O(n^2)，其中 n 是字符串的长度。长度为 1 和 2 的回文中心分别有 n 和 n-1 个，每个回文中心最多会向外扩展 O(n) 次。
- 空间复杂度：O(1)。