#include <iostream>
#include <string>

using namespace std;

class Solution {
public:
    int titleToNumber(string columnTitle) {
        int number = 0;
        int multiple = 1;
        for (int i = columnTitle.size() - 1; i >= 0; i--) {
            int k = columnTitle[i] - 'A' + 1;
            number += k * multiple;
            multiple *= 26;
        }
        return number;
    }
};

int main() {
    Solution sol;
    string columnTitle = "AB";
    int result = sol.titleToNumber(columnTitle);
    cout << "result = " << result << endl;
    system("pause");
    return 0;
}