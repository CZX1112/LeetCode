#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int rob(vector<int>& nums) {
        int length = nums.size();
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        vector<int> dp = vector<int>(length, 0);
        dp[0] = nums[0];
        dp[1] = max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[length - 1];
    }
};

int main() {
    Solution sol;
    vector<int> nums = {2,7,9,3,1};
    int result = sol.rob(nums);
    cout << "result = " << result << endl;
    system("pause");
    return 0;
}