# [60.排列序列](https://leetcode.cn/problems/permutation-sequence/)

`时间：2023.7.24`

## 题目

给出集合 `[1,2,3,...,n]`，其所有元素共有 `n!` 种排列。

按大小顺序列出所有排列情况，并一一标记，当 `n = 3` 时, 所有排列如下：

1. "123"
2. "132"
3. "213"
4. "231"
5. "312"
6. "321"

给定 `n` 和 `k`，返回第 `k` 个排列。

**示例1：**

```
输入：n = 3, k = 3
输出："213"
```

**示例2：**

```
输入：n = 4, k = 9
输出："2314"
```

**示例3：**

```
输入：n = 3, k = 1
输出："123"
```

## 代码

#### 方法：dfs回溯

##### 思路

回溯法，类似0046全排列

##### 代码

```java
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    List<Integer> ans = new ArrayList<Integer>();
    List<Integer> cur = new ArrayList<Integer>();
    int count = 0;
    public String getPermutation(int n, int k) {
        boolean[] used = new boolean[n + 1];
        Arrays.fill(used, false);
        dfs(n, k, used);
        StringBuilder sb = new StringBuilder();
        for (Integer item : ans) {
            sb.append(item);
        }
        return sb.toString();
    }

    public void dfs(int n, int k, boolean[] used) {
        if (cur.size() == n) {
            count++;
            if (count == k) {
                ans = new ArrayList<>(cur);
            }
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            cur.add(i);
            used[i] = true;
            dfs(n, k, used);
            cur.remove(cur.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        int k = 9;
        String result = solution.getPermutation(n, k);
        System.out.println("Output: " + result);
    }
}
```

##### 复杂度分析

- 时间复杂度：复杂。
- 空间复杂度：O(N)。