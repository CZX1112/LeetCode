# [0242.有效的字母异位词](https://leetcode.cn/problems/valid-anagram/)

`时间：2023.11.16`

## 题目

给定两个字符串 `s` 和 `t` ，编写一个函数来判断 `t` 是否是 `s` 的字母异位词。

**注意：**若 `s` 和 `t` 中每个字符出现的次数都相同，则称 `s` 和 `t` 互为字母异位词。

**示例1：**

```
输入: s = "anagram", t = "nagaram"
输出: true
```

**示例2：**

```
输入: s = "rat", t = "car"
输出: false
```

## 代码

#### 方法：哈希表法

##### 思路

从另一个角度考虑，t 是 s 的异位词等价于「两个字符串中字符出现的种类和次数均相等」。由于字符串只包含 26 个小写字母，因此我们可以维护一个长度为 26 的频次数组 table，先遍历记录字符串 s 中字符出现的频次，然后遍历字符串 t，减去 table 中对应的频次，如果出现 table[i]<0，则说明 t 包含一个不在 s 中的额外字符，返回 false 即可。

##### 代码

```c++
#include <iostream>
#include <unordered_map>

using namespace std;

class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.size() != t.size()) {
            return false;
        }
        unordered_map<char, int> myhashmap;
        for (unsigned int i = 0; i < s.size(); i++) {
            myhashmap[s[i]]++;
        }
        for (unsigned int i = 0; i < t.size(); i++) {
            if (myhashmap.find(t[i]) != myhashmap.end() && myhashmap[t[i]] > 0) {
                myhashmap[t[i]]--;
            }
            else {
                return false;
            }
        }
        return true;
    }
};

int main() {
    Solution sol;
    string s = "anagram", t = "nagaram";
    bool result = sol.isAnagram(s, t);
    cout << "result = " << result << endl;
    system("pause");
    return 0;
}
```

##### 复杂度分析

- 时间复杂度：O(n)，其中 n 为 s 的长度。
- 空间复杂度：O(S)。其中 S 为字符集大小，此处 S=26。
