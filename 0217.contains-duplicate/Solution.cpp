#include <iostream>
#include <unordered_set>
#include <vector>

using namespace std;

class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        unordered_set<int> myhashset;
        int length = nums.size();
        for (int i = 0; i < length; i++) {
            if (myhashset.find(nums[i]) != myhashset.end()) {
                return true;
            }
            myhashset.insert(nums[i]);
        }
        return false;
    }
};

int main() {
    Solution sol;
    vector<int> nums = {1,2,3,1};
    bool result = sol.containsDuplicate(nums);
    cout << "result = " << result << endl;
    system("pause");
    return 0;
}