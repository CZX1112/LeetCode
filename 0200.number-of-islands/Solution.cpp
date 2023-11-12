#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int numrows = grid.size();
        if (!numrows) {
            return 0;
        }
        int numcols = grid[0].size();
        int result = 0;
        for (int row = 0; row < numrows; row++) {
            for (int col = 0; col < numcols; col++) {
                if (grid[row][col] == '1') {
                    result++;
                    dfs(grid, row, col);
                }
            }
        }
        return result;
    }

    void dfs(vector<vector<char>>& grid, int row, int col) {
        int numrows = grid.size();
        int numcols = grid[0].size();
        grid[row][col] = '0';
        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
            dfs(grid, row - 1, col);
        }
        if (row + 1 < numrows && grid[row + 1][col] == '1') {
            dfs(grid, row + 1, col);
        }
        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
            dfs(grid, row, col - 1);
        }
        if (col + 1 < numcols && grid[row][col + 1] == '1') {
            dfs(grid, row, col + 1);
        }
    }
};

int main() {
    vector<vector<char>> grid = {
        {'1', '1', '1', '1', '0'},
        {'1', '1', '0', '1', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '0', '0', '0'}
    };
    Solution solution;
    int result = solution.numIslands(grid);

    cout << result << endl;
    system("pause");
    return 0;
}