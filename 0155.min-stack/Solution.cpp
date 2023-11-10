#include <iostream>
#include <stack>

using namespace std;

class MinStack {
public:
    stack<int> nowstack;
    stack<int> minstack;
    MinStack() {
        ;
    }
    
    void push(int val) {
        nowstack.push(val);
        if (!minstack.empty() && val > minstack.top()) {
            minstack.push(minstack.top());
        }
        else {
            minstack.push(val);
        }
    }
    
    void pop() {
        nowstack.pop();
        minstack.pop();
    }
    
    int top() {
        return nowstack.top();
    }
    
    int getMin() {
        return minstack.top();
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */