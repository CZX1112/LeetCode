#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        unordered_map<int, int> hashtable;
        int length = nums.size();
        for (int i = 0; i < length; i++) {
            if (hashtable.find(nums[i]) != hashtable.end()) {
                if (abs(hashtable[nums[i]] - i) <= k) {
                    return true;
                }
            }
            hashtable[nums[i]] = i;
        }
        return false;
    }
};

int main() {
    Solution sol;
    vector<int> nums = {1,2,3,1,2,3};
    bool result = sol.containsNearbyDuplicate(nums, 2);
    cout << "result = " << result << endl;
    system("pause");
    return 0;
}