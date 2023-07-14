# [58.最后一个单词的长度](https://leetcode.cn/problems/length-of-last-word/)

`时间：2023.7.14`

## 题目

给你一个字符串 `s`，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 **最后一个** 单词的长度。

**单词** 是指仅由字母组成、不包含任何空格字符的最大子字符串。

**示例1：**

```
输入：s = "Hello World"
输出：5
解释：最后一个单词是“World”，长度为5。
```

**示例2：**

```
输入：s = "   fly me   to   the moon  "
输出：4
解释：最后一个单词是“moon”，长度为4。
```

**示例3：**

```
输入：s = "luffy is still joyboy"
输出：6
解释：最后一个单词是长度为6的“joyboy”。
```

## 代码

#### 方法：字符串反向遍历

##### 思路

- 从字符串末尾开始向前遍历，其中主要有两种情况：
- 第一种情况，以字符串 `"Hello World"` 为例，从后向前遍历直到遍历到头或者遇到空格为止，即为最后一个单词 `"World"` 的长度 `5`。
- 第二种情况，以字符串 `"Hello World"` 为例，需要先将末尾的空格过滤掉，再进行第一种情况的操作，即认为最后一个单词为 "World"，长度为 `5`。
- 所以完整过程为先从后过滤掉空格找到单词尾部，再从尾部向前遍历，找到单词头部，最后两者相减，即为单词的长度。

##### 代码

```java
class Solution {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        // 先去除空格，找到最后一个单词的末尾
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        int start = end;
        // 找到最后一个单词的开始
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        return end - start;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.lengthOfLastWord("   fly me   to   the moon  ");
        System.out.println(result);
    }
}
```

##### 复杂度分析

- 时间复杂度：O(N)。
- 空间复杂度：O(1)。