# [0125.验证回文串](https://leetcode.cn/problems/valid-palindrome/)

`时间：2023.8.25`

## 题目

如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 **回文串** 。

字母和数字都属于字母数字字符。

给你一个字符串 `s`，如果它是 **回文串** ，返回 `true` ；否则，返回 `false` 。

**示例1：**

```
输入: s = "A man, a plan, a canal: Panama"
输出：true
解释："amanaplanacanalpanama" 是回文串。
```

**示例2：**

```
输入：s = "race a car"
输出：false
解释："raceacar" 不是回文串。
```

**示例3：**

```
输入：s = " "
输出：true
解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
由于空字符串正着反着读都一样，所以是回文串。
```

## 代码

#### 方法一：用一个额外数组先存储处理后的字符串

##### 思路

最简单的方法是对字符串 s 进行一次遍历，并将其中的字母和数字字符进行保留，放在另一个字符串 sb 中。这样我们只需要判断 sb 是否是一个普通的回文串即可。

使用双指针，初始时，左右指针分别指向 sb 的两侧，随后我们不断地将这两个指针相向移动，每次移动一步，并判断这两个指针指向的字符是否相同。当这两个指针相遇时，就说明是回文串。

##### 代码

```java
class Solution {
    // 法一：用一个额外数组先存储处理后的字符串
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            int ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sb.append(ch);
            }
        }
        int newLength = sb.length();
        for (int i = 0; i < newLength / 2; i++) {
            if (sb.charAt(i) != sb.charAt(newLength - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String str = "race a car";
        Boolean result = sol.isPalindrome(str);
        System.out.println("result = " + result);
    }
}
```

##### 复杂度分析

- 时间复杂度：O(n)。其中 n 是字符串 s 的长度。
- 空间复杂度：O(n)。由于我们需要将所有的字母和数字字符存放在另一个字符串中，在最坏情况下，新的字符串与原字符串 s 完全相同，因此需要使用 O(n) 的空间。

#### 方法二：直接在原字符串基础上判断

##### 思路

我们可以对方法一中第二种判断回文串的方法进行优化，就可以得到只使用 O(1) 空间的算法。

我们直接在原字符串 s 上使用双指针。在移动任意一个指针时，需要不断地向另一指针的方向移动，直到遇到一个字母或数字字符，或者两指针重合为止。也就是说，我们每次将指针移到下一个字母字符或数字字符，再判断这两个指针指向的字符是否相同。

##### 代码

```java
class Solution {
    // 法二：直接在原字符串基础上判断
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String str = "race a car";
        Boolean result = sol.isPalindrome(str);
        System.out.println("result = " + result);
    }
}
```

##### 复杂度分析

- 时间复杂度：O(n)。其中 n 是字符串 s 的长度。
- 空间复杂度：O(1)。