# [9.回文数](https://leetcode.cn/problems/palindrome-number/)

`时间：2023.6.24`

## 题目

给你一个整数 `x` ，如果 `x` 是一个回文整数，返回 `true` ；否则，返回 `false` 。

回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

- 例如，`121` 是回文，而 `123` 不是。


**示例1：**

```
输入：x = 121
输出：true
```

**示例2：**

```
输入：x = -121
输出：false
解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
```

**示例3：**

```
输入：x = 10
输出：false
解释：从右向左读, 为 01 。因此它不是一个回文数。
```

## 代码

#### 方法一：转为字符串

##### 代码

```java
class Solution {
    // 法一：转为字符串判断
    public boolean isPalindrome(int x) {
    String str = Integer.toString(x);
    for (int i = 0; i < str.length() / 2; i++)
    if (str.charAt(i) != str.charAt(str.length() - i - 1))
    return false;
    return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isPalindrome(-1));
    }
}
```

#### 方法二：数学方法

##### 思路

- 如果是负数则一定不是回文数，直接返回 `false`
- 如果是正数，则将其倒序数值计算出来，然后比较和原数值是否相等
- 如果是回文数则相等返回 `true`，如果不是则不相等 `false`
- 比如 `123` 的倒序 `321`，不相等；`121` 的倒序 `121`，相等

##### 代码

```java
class Solution {
    // 法二：数学方法
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int cur = 0, num = x;
        while (num != 0) {
            cur *= 10;
            cur += num % 10;
            num /= 10;
        }
        return cur == x;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isPalindrome(-1));
    }
}
```
