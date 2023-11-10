# [0155.最小栈](https://leetcode.cn/problems/min-stack/)

`时间：2023.11.10`

## 题目

设计一个支持 `push` ，`pop` ，`top` 操作，并能在常数时间内检索到最小元素的栈。

实现 `MinStack` 类:

- `MinStack()` 初始化堆栈对象。

- `void push(int val)` 将元素 `val` 推入堆栈。

- `void pop()` 删除堆栈顶部的元素。

- `int top()` 获取堆栈顶部的元素。

- `int getMin()` 获取堆栈中的最小元素。

**示例1：**

```
输入：
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

输出：
[null,null,null,null,-3,null,0,-2]

解释：
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.
```

## 代码

#### 方法：栈

##### 思路

按照上面的思路，我们只需要设计一个数据结构，使得每个元素 `a` 与其相应的最小值 `m` 时刻保持一一对应。因此我们可以使用一个辅助栈，与元素栈同步插入与删除，用于存储与每个元素对应的最小值。

- 当一个元素要入栈时，我们取当前辅助栈的栈顶存储的最小值，与当前元素比较得出最小值，将这个最小值插入辅助栈中；

- 当一个元素要出栈时，我们把辅助栈的栈顶元素也一并弹出；

- 在任意一个时刻，栈内元素的最小值就存储在辅助栈的栈顶元素中。

##### 代码

```c++
#include <iostream>
#include <stack>

using namespace std;

class MinStack {
public:
    stack<int> nowstack;
    stack<int> minstack;
    MinStack() {
        ;
    }
    
    void push(int val) {
        nowstack.push(val);
        if (!minstack.empty() && val > minstack.top()) {
            minstack.push(minstack.top());
        }
        else {
            minstack.push(val);
        }
    }
    
    void pop() {
        nowstack.pop();
        minstack.pop();
    }
    
    int top() {
        return nowstack.top();
    }
    
    int getMin() {
        return minstack.top();
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */
```

##### 复杂度分析

- 时间复杂度：O(1)。对于题目中的所有操作，时间复杂度均为 O(1)。因为栈的插入、删除与读取操作都是 O(1)，我们定义的每个操作最多调用栈操作两次。
- 空间复杂度：O(n)。其中 n 为总操作数。最坏情况下，我们会连续插入 n 个元素，此时两个栈占用的空间为 O(n)。
