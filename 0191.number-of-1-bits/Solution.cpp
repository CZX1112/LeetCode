#include <iostream>

using namespace std;

class Solution {
public:
    // 法一：循环检查二进制位
    // int hammingWeight(uint32_t n) {
    //     int result = 0;
    //     for (int i = 0; i < 32; i++) {
    //         if (n & (1 << i)) {
    //             result++;
    //         }
    //     }
    //     return result;
    // }

    // 法二：位运算优化
    int hammingWeight(uint32_t n) {
        int result = 0;
        while (n) {
            n &= n - 1;
            result++;
        }
        return result;
    }
};