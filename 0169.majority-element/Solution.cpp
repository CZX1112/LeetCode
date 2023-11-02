#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
    // 法一：哈希表法
    // int majorityElement(vector<int>& nums) {
    //     unordered_map<int, int> myMap;
    //     int nowNum = nums[0];
    //     for (unsigned int i = 0; i < nums.size(); i++) {
    //         myMap[nums[i]]++;
    //     }
    //     int length = nums.size() / 2;
    //     for (int i = 0; i < nums.size(); i++) {
    //         if (myMap[nums[i]] > length) {
    //             nowNum = nums[i];
    //             break;
    //         }
    //     }
    //     return nowNum;
    // }

    // 法二：Boyer-Moore投票算法
    int majorityElement(vector<int>& nums) {
        int candidate = nums[0];
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == candidate) {
                count++;
            }
            else {
                count--;
            }
            if (count <= 0) {
                candidate = nums[i];
                count = 1;
            }
        }
        return candidate;
    }
};

int main() {
    Solution solution;
    vector<int> nums = {2,2,1,1,1,2,2};
    int maj = solution.majorityElement(nums);
    cout << "maj: " << maj << endl;
    system("pause");
    return 0;
}