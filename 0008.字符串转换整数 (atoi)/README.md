# [8.字符串转换整数 (atoi)](https://leetcode.cn/problems/string-to-integer-atoi/)

`时间：2023.6.23`

## 题目

给你一个 32 位的有符号整数 `x` ，返回将 `x` 中的数字部分反转后的结果。

请你来实现一个`myAtoi(string s)`函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 `atoi` 函数）。

函数 `myAtoi(string s)` 的算法如下：

1. 读入字符串并丢弃无用的前导空格
2. 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
3. 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
   将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
4. 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
5. 返回整数作为最终结果。

**注意**：

- 本题中的空白字符只包括空格字符 `' '` 。
- 除前导空格或数字后的其余字符串外，**请勿忽略** 任何其他字符。

**示例1：**

```
输入：s = "42"
输出：42
```

**示例2：**

```
输入：s = "   -42"
输出：-42
```

**示例3：**

```
输入：s = "4193 with words"
输出：4193
```

## 代码

#### 方法：数学方法

##### 思路

如下代码所示：

1. 首先忽略前导空格
2. 判断第一个字符是否是符号位并设置
3. 依次遍历字符串
   - 若为数字则判断是否越界后更新结果result
   - 若为其他字符则程序退出

##### 代码

```java
class Solution {
    public int myAtoi(String s) {
        int result = 0;
        //符号默认为正
        int sign = 1;
        int len = s.length(), loc = 0;
        while (loc < len && s.charAt(loc) == ' ')
            loc++;
        int start = loc;
        for (; loc < len; loc++) {
            char ch = s.charAt(loc);
            if (loc == start && ch == '+')
                sign = 1;
            else if (loc == start && ch == '-')
                sign = -1;
            else if (Character.isDigit(ch)) {
                int num = ch - '0';
                // 判断是否越界
                if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10))
                    return Integer.MAX_VALUE;
                if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && -num < Integer.MIN_VALUE % 10))
                    return Integer.MIN_VALUE;
                result = result * 10 + sign * num;
            }
            else
                break;
        }
        return result;
    }
}
```

##### 复杂度分析

- 时间复杂度：O(n)，n为字符串长度。
- 空间复杂度：O(1)。
