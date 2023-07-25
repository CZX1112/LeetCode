# [67.二进制求和](https://leetcode.cn/problems/add-binary/)

`时间：2023.7.25`

## 题目

给你两个二进制字符串 `a` 和 `b` ，以二进制字符串的形式返回它们的和。

**示例1：**

```
输入:a = "11", b = "1"
输出："100"
```

**示例2：**

```
输入：a = "1010", b = "1011"
输出："10101"
```

## 代码

#### 方法：模拟

##### 思路

![1](pictures/1.png)

##### 代码

```java
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            ca = sum / 2;
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String result = sol.addBinary("11", "1");
        System.out.println("result = " + result);
    }
}
```

##### 复杂度分析

![2](pictures/2.png)