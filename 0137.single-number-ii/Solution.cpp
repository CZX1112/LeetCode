#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
    int singleNumber(vector<int>& nums) {
        unordered_map<int, int> mymap;
        for (int i = 0; i < nums.size(); i++) {
            mymap[nums[i]]++;
        }
        int result = nums[0];
        for (auto pair : mymap) {
            if (pair.second == 1) {
                result = pair.first;
                break;
            }
        }
        return result;
    }
};

int main() {
    vector<int> nums = {0,1,0,1,0,1,99};
    Solution sol;
    int result = sol.singleNumber(nums);
    cout << "result = " << result << endl;
    system("pause");
    return 0;
}