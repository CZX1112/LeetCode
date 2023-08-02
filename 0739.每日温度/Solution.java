import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    // 单调栈法
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];
        Deque<Integer> mystack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!mystack.isEmpty() && temperatures[i] > temperatures[mystack.peek()]) {
                result[mystack.peek()] = i - mystack.peek();
                mystack.pop();
            }
            mystack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        Solution sol = new Solution();
        int[] result = sol.dailyTemperatures(temperatures);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}