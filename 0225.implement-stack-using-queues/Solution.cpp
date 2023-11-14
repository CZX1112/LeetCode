#include <iostream>
#include <queue>

using namespace std;

class MyStack {
public:
    queue<int> queue1;
    queue<int> queue2;

    MyStack() {

    }
    
    void push(int x) {
        queue2.push(x);
        while (!queue1.empty()) {
            queue2.push(queue1.front());
            queue1.pop();
        }
        swap(queue1, queue2);
    }
    
    int pop() {
        int result = queue1.front();
        queue1.pop();
        return result;
    }
    
    int top() {
        int result = queue1.front();
        return result;
    }
    
    bool empty() {
        return queue1.empty();
    }
};