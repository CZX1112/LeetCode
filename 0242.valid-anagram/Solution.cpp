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