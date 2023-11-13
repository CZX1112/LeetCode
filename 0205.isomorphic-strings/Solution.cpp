#include <iostream>
#include <unordered_map>

using namespace std;

class Solution {
public:
    // 哈希表法
    bool isIsomorphic(string s, string t) {
        unordered_map<char, char> s2t;
        unordered_map<char, char> t2s;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char x = s[i], y = t[i];
            if ((s2t.count(x) && s2t[x] != y) || (t2s.count(y) && t2s[y] != x)) {
                return false;
            }
            s2t[x] = y;
            t2s[y] = x;
        }
        return true;
    }
};

int main() {
    Solution sol;
    string s = "egg", t = "add";
    bool result = sol.isIsomorphic(s, t);
    cout << "result = " << result << endl;
    system("pause");
    return 0;
}