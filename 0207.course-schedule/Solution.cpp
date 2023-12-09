#include <iostream>
#include <vector>
#include <queue>

using namespace std;

class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int> indegree(numCourses);
        vector<vector<int>> edge(numCourses);
        for (int i = 0; i < prerequisites.size(); i++) {
            indegree[prerequisites[i][0]]++;
            edge[prerequisites[i][1]].push_back(prerequisites[i][0]);
        }
        queue<int> myqueue;
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                myqueue.push(i);
            }
        }
        int count = 0;
        while (!myqueue.empty()) {
            int selected = myqueue.front();
            myqueue.pop();
            count++;
            for (int i = 0; i < edge[selected].size(); i++) {
                if (indegree[edge[selected][i]] > 0) {
                    indegree[edge[selected][i]]--;
                    if (indegree[edge[selected][i]] == 0) {
                        myqueue.push(edge[selected][i]);
                    }
                }
            }
        }
        if (count == numCourses) {
            return true;
        }
        else {
            return false;
        }
    }
};

int main() {
    Solution sol;
    int numCourses = 3;
    vector<vector<int>> prerequisites = {{1,0},{1,2},{0,1}};
    bool result = sol.canFinish(numCourses, prerequisites);
    cout << "result = " << result << endl;
    system("pause");
}