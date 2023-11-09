#include <iostream>
#include <string>
#include <vector>
#include <stack>

using namespace std;

class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<int> stk;
        int length = tokens.size();
        for (int i = 0; i < length; i++) {
            string token = tokens[i];
            if (isNumber(token)) {
                stk.push(stoi(token));
            }
            else {
                int num2 = stk.top();
                stk.pop();
                int num1 = stk.top();
                stk.pop();
                switch (token[0])
                {
                case '+':
                    stk.push(num1 + num2);
                    break;
                case '-':
                    stk.push(num1 - num2);
                    break;
                case '*':
                    stk.push(num1 * num2);
                    break;
                case '/':
                    stk.push(num1 / num2);
                    break;
                default:
                    break;
                }
            }
        }
        return stk.top();
    }
    
    bool isNumber(string token) {
        return !(token == "+" || token == "-" || token == "*" || token == "/");
    }
};

int main() {
    vector<string> tokens = {"2","1","+","3","*"};
    Solution sol;
    int result = sol.evalRPN(tokens);
    cout << "result = " << result << endl;
    system("pause");
    return 0;
}