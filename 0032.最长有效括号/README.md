# [32.最长有效括号](https://leetcode.cn/problems/longest-valid-parentheses/)

`时间：2023.7.7`

## 题目

给你一个只包含 `'('` 和 `')'` 的字符串，找出最长有效（格式正确且连续）括号子串的长度。

**示例1：**

```
输入：s = "(()"
输出：2
解释：最长有效括号子串是 "()"
```

**示例2：**

```
输入：s = ")()())"
输出：4
解释：最长有效括号子串是 "()()"
```

**示例3：**

```
输入：s = ""
输出：0
```

## 代码

#### 方法一：栈

##### 思路

具体做法是我们始终保持栈底元素为当前已经遍历过的元素中「最后一个没有被匹配的右括号的下标」，这样的做法主要是考虑了边界条件的处理，栈里其他元素维护左括号的下标：

- 对于遇到的每个 `‘(’` ，我们将它的下标放入栈中
- 对于遇到的每个 `‘)’` ，我们先弹出栈顶元素表示匹配了当前右括号：
  - 如果栈为空，说明当前的右括号为没有被匹配的右括号，我们将其下标放入栈中来更新我们之前提到的「最后一个没有被匹配的右括号的下标」
  - 如果栈不为空，当前右括号的下标减去栈顶元素即为「以该右括号为结尾的最长有效括号的长度」
    我们从前往后遍历字符串并更新答案即可。

需要注意的是，如果一开始栈为空，第一个字符为左括号的时候我们会将其放入栈中，这样就不满足提及的「最后一个没有被匹配的右括号的下标」，为了保持统一，我们在一开始的时候往栈中放入一个值为 `−1` 的元素。

##### 代码

```java
import java.util.Stack;

class Solution {
    // 法一：栈
    public int longestValidParentheses(String s) {
        int result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }
                else {
                    result = Math.max(result, i - stack.peek());
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = ")()())";
        int result = solution.longestValidParentheses(s);
        System.out.println("输出：" + result); // 输出：4
    }
}
```

##### 复杂度分析

- 时间复杂度：O(n)，其中n是数组的长度。我们只需要遍历字符串一次即可。
- 空间复杂度：O(n)。栈的大小在最坏情况下会达到n。

#### 方法二：左右计数器，不需要额外空间

##### 思路

在此方法中，我们利用两个计数器 `left` 和 `right` 。首先，我们从左到右遍历字符串，对于遇到的每个 `‘(’`，我们增加 `left` 计数器，对于遇到的每个 `‘)’` ，我们增加 `right` 计数器。每当 `left` 计数器与 `right` 计数器相等时，我们计算当前有效字符串的长度，并且记录目前为止找到的最长子字符串。当 `right` 计数器比 `left` 计数器大时，我们将 `left` 和 `right` 计数器同时变回 `0`。

这样的做法贪心地考虑了以当前字符下标结尾的有效括号长度，每次当右括号数量多于左括号数量的时候之前的字符我们都扔掉不再考虑，重新从下一个字符开始计算，但这样会漏掉一种情况，就是遍历的时候左括号的数量始终大于右括号的数量，即 `(()` ，这种时候最长有效括号是求不出来的。

解决的方法也很简单，我们只需要从右往左遍历用类似的方法计算即可，只是这个时候判断条件反了过来：

- 当 `left` 计数器比 `right` 计数器大时，我们将 `left` 和 `right` 计数器同时变回 `0`
- 当 `left` 计数器与 `right` 计数器相等时，我们计算当前有效字符串的长度，并且记录目前为止找到的最长子字符串

这样我们就能涵盖所有情况从而求解出答案。

##### 代码

```java
import java.util.Stack;

class Solution {
    // 法二：左右计数器，不需要额外空间
    public int longestValidParentheses(String s) {
        int result = 0;
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            }
            else if (s.charAt(i) == ')') {
                right++;
            }
            if (left == right) {
                result = Math.max(result, 2 * left);
            }
            else if (right > left) {
                left = 0;
                right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            }
            else if (s.charAt(i) == ')') {
                right++;
            }
            if (left == right) {
                result = Math.max(result, 2 * left);
            }
            else if (left > right) {
                left = 0;
                right = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = ")()())";
        int result = solution.longestValidParentheses(s);
        System.out.println("输出：" + result); // 输出：4
    }
}
```

##### 复杂度分析

- 时间复杂度：O(n)，其中n是数组的长度，我们只需要正反遍历两边字符串即可。
- 空间复杂度：O(1)。我们只需要常数空间存放若干变量。