# [50.Pow(x, n)](https://leetcode.cn/problems/powx-n/)

`时间：2023.7.14`

## 题目

实现 `pow(x, n)` ，即计算 `x` 的整数 `n` 次幂函数（即，`x^n` ）。

**示例1：**

```
输入：x = 2.00000, n = 10
输出：1024.00000
```

**示例2：**

```
输入：x = 2.10000, n = 3
输出：9.26100
```

**示例3：**

```
输入：x = 2.00000, n = -2
输出：0.25000
解释：2-2 = 1/22 = 1/4 = 0.25
```

## 代码

#### 方法：快速幂+迭代

##### 思路

详见：[Pow(x, n) - Pow(x, n) - 力扣（LeetCode）](https://leetcode.cn/problems/powx-n/solution/powx-n-by-leetcode-solution/)

##### 代码

```java
class Solution {
    // 快速幂+迭代算法
    public double myPow(double x, int n) {
        long N = n;
        double result = 1.0;
        if (N < 0) {
            N = -N;
            x = 1.0 / x;
        }
        while (N > 0) {
            if (N % 2 == 1) {
                result *= x;
            }
            x *= x;
            N /= 2;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        double result = sol.myPow(2, 10);
        System.out.println(result);
    }
}
```

##### 复杂度分析

- 时间复杂度：O(logn)。即为对n进行二进制拆分的时间复杂度。
- 空间复杂度：O(1)。