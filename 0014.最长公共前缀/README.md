# [14.最长公共前缀](https://leetcode.cn/problems/longest-common-prefix/)

`时间：2023.7.3`

## 题目

编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 `""`。

**示例1：**

```
输入：strs = ["flower","flow","flight"]
输出："fl"
```

**示例2：**

```
输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀。
```

## 代码

#### 方法：模拟

##### 思路

- 当字符串数组长度为 `0` 时则公共前缀为空，直接返回；
- 令最长公共前缀 `ans` 的值为第一个字符串，进行初始化；
- 遍历后面的字符串，依次将其与 `ans` 进行比较，两两找出公共前缀，最终结果即为最长公共前缀；
- 如果查找过程中出现了 `ans` 为空的情况，则公共前缀不存在直接返回；

##### 代码

```java
class Solution {
    // 横向扫描
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        String prefix = strs[0];
        int length = strs.length;
        for (int i = 1; i < length; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0)
                break;
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        Solution sol = new Solution();
        String result = sol.longestCommonPrefix(strs);
        System.out.println("result = " + result);
    }
}
```

##### 复杂度分析

- 时间复杂度：O(s)，其中s是所有字符串的长度总和。
- 空间复杂度：O(1)。