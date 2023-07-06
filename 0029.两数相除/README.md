# [29.两数相除](https://leetcode.cn/problems/divide-two-integers/)

`时间：2023.7.6`

## 题目

给你两个整数，被除数 `dividend` 和除数 `divisor`。将两数相除，要求 **不使用** 乘法、除法和取余运算。

整数除法应该向零截断，也就是截去（`truncate`）其小数部分。例如，`8.345` 将被截断为 `8` ，`-2.7335` 将被截断至 `-2` 。

返回被除数 `dividend` 除以除数 `divisor` 得到的 **商** 。

**注意**：假设我们的环境只能存储 **32 位** 有符号整数，其数值范围是 `[−231,  231 − 1]` 。本题中，如果商 **严格大于** `231 − 1` ，则返回 `231 − 1` ；如果商 **严格小于** `-231` ，则返回 `-231` 。

**示例1：**

```
输入: dividend = 10, divisor = 3
输出: 3
解释: 10/3 = 3.33333.. ，向零截断后得到 3 。
```

**示例2：**

```
输入: dividend = 7, divisor = -3
输出: -2
解释: 7/-3 = -2.33333.. ，向零截断后得到 -2 。
```

## 代码

#### 方法：双指针

##### 思路

对于全程不使用 `long` 的做法，我们需要将所有数映射到负数进行处理（以 0 为分割点，负数所能表示的范围更大）。

基本思路为：

- 起始先对边界情况进行特判；
- 记录最终结果的符号，并将两数都映射为负数；
- 可以预处理出倍增数组，或采取逐步增大 `dividend` 来逼近 `divisor` 的方式。

由于操作数都是负数，因此自倍增过程中，如果操作数小于 `INT_MIN` 的一半（`-1073741824`），则代表发生溢出。

##### 代码

```java
class Solution {
    private int MIN = Integer.MIN_VALUE, MAX = Integer.MAX_VALUE;
    private int LIMIT = MIN / 2;
    public int divide(int dividend, int divisor) {
        if (dividend == MIN && divisor == -1) {
            return MAX;
        }
        boolean flag = false;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            flag = true;
        }
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }
        int ans = 0;
        while (dividend <= divisor) {
            int temp = divisor, multiple = -1;
            while (temp >= LIMIT && dividend <= 2 * temp) {
                temp += temp;
                multiple += multiple;
            }
            dividend -= temp;
            ans += multiple;
        }
        return flag ? ans : -ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int dividend = 7;
        int divisor = -3;
        int result = solution.divide(dividend, divisor);
        System.out.println("Input: dividend = " + dividend + ", divisor = " + divisor);
        System.out.println("Output: " + result);
    }
}
```

##### 复杂度分析

- 时间复杂度：O(logdividend * logdivisor)。
- 空间复杂度：O(1)。