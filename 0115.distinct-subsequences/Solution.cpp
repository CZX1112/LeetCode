#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    // 动态规划算法
    int numDistinct(string s, string t) {
        int m = s.length(), n = t.length();
        if (m < n) {
            return 0;
        }
        vector<vector<int>> dp(m + 1, vector<int>(n + 1));
        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[m][j] = 0;
        }
        for (int i = m - 1; i >= 0; i--) {
            char sChar = s[i];
            for (int j = n - 1; j >= 0; j--) {
                char tChar = t[j];
                if (sChar == tChar) {
                    cout << "sChar = " << sChar << ", tChar = " << tChar << endl;
                    dp[i][j] = dp[i + 1][j] + dp[i + 1][j + 1];
                }
                else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }
};

int main() {
    Solution solution;
    string s = "babgbag";
    string t = "bag";
    int result = solution.numDistinct(s, t);
    cout << "result = " << result << endl;
    system("pause");
    return 0;
}