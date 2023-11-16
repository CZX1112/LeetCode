#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int xsize = matrix.size(), ysize = matrix[0].size();
        int x = xsize - 1, y = 0;
        while (x >= 0 && x < xsize && y >= 0 && y < ysize) {
            if (matrix[x][y] == target) {
                return true;
            }
            else if (matrix[x][y] > target) {
                x--;
            }
            else {
                y++;
            }
        }
        return false;
    }
};

int main() {
    Solution solution;
    // Test Case
    vector<vector<int>> matrix = {{1,4,7,11,15},
                                  {2,5,8,12,19},
                                  {3,6,9,16,22},
                                  {10,13,14,17,24},
                                  {18,21,23,26,30}};

    int target = 5;
    bool result = solution.searchMatrix(matrix, target);
    cout << "Output: " << (result ? "true" : "false") << endl;
    system("pause");
    return 0;
}