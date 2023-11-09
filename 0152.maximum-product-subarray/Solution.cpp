#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int maxProduct(vector<int>& nums) {
        vector<int> arrayMax(nums.size()), arrayMin(nums.size());
        arrayMax[0] = arrayMin[0] = nums[0];
        int MAX = nums[0];
        for (unsigned int i = 1; i < nums.size(); i++) {
            arrayMax[i] = max(max(arrayMax[i - 1] * nums[i], arrayMin[i - 1] * nums[i]), nums[i]);
            arrayMin[i] = min(min(arrayMax[i - 1] * nums[i], arrayMin[i - 1] * nums[i]), nums[i]);
            MAX = max(MAX, arrayMax[i]);
        }
        return MAX;
    }
};

int main() {
    Solution sol;
    vector<int> nums = {2,3,-2,4};
    int result = sol.maxProduct(nums);
    cout << "result = " << result << endl;
    system("pause");
    return 0;
}