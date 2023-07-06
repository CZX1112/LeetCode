# [28.找出字符串中第一个匹配项的下标](https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/)

`时间：2023.7.6`

## 题目

给你两个字符串 `haystack` 和 `needle` ，请你在 `haystack` 字符串中找出 `needle` 字符串的第一个匹配项的下标（下标从 `0` 开始）。如果 `needle` 不是 `haystack` 的一部分，则返回 `-1` 。

**示例1：**

```
输入：haystack = "sadbutsad", needle = "sad"
输出：0
解释："sad" 在下标 0 和 6 处匹配。
第一个匹配项的下标是 0 ，所以返回 0 。
```

**示例2：**

```
输入：haystack = "leetcode", needle = "leeto"
输出：-1
解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
```

## 代码

#### 方法：双指针

##### 思路

`KMP` 算法，总体思路大概是遍历字符串 `haystack` 的指针 `i` 永远只会往前走。对于待匹配字符串 `needle` ，如果遇到不匹配的情况，回到上一个共同前后缀处。

参考链接：https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/solution/shua-chuan-lc-shuang-bai-po-su-jie-fa-km-tb86/

https://www.bilibili.com/video/BV1AY4y157yL/?spm_id_from=333.337.search-card.all.click&vd_source=7f6ba21197bdeac9f512077e3b57e148

https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/solution/shi-xian-strstr-by-leetcode-solution-ds6y/

##### 代码

```java
class Solution {
    // KMP算法
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String a = "sadbutsad", b = "sad";
        Solution sol = new Solution();
        int result = sol.strStr(a, b);
        System.out.println(result);
    }
}
```

##### 复杂度分析

- 时间复杂度：O(m+n)，其中m和n分别是两个字符串的长度。我们至多需要遍历两字符串一次。
- 空间复杂度：O(m)。其中m是待匹配字符串needle的长度，我们只需要保存字符串needle的前缀函数。