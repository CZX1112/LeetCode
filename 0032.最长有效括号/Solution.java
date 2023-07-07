import java.util.Stack;

class Solution {
    // 法一：栈
    // public int longestValidParentheses(String s) {
    //     int result = 0;
    //     Stack<Integer> stack = new Stack<Integer>();
    //     stack.push(-1);
    //     for (int i = 0; i < s.length(); i++) {
    //         if (s.charAt(i) == '(') {
    //             stack.push(i);
    //         }
    //         else {
    //             stack.pop();
    //             if (stack.isEmpty()) {
    //                 stack.push(i);
    //             }
    //             else {
    //                 result = Math.max(result, i - stack.peek());
    //             }
    //         }
    //     }
    //     return result;
    // }

    // 法二：左右计数器，不需要额外空间
    public int longestValidParentheses(String s) {
        int result = 0;
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            }
            else if (s.charAt(i) == ')') {
                right++;
            }
            if (left == right) {
                result = Math.max(result, 2 * left);
            }
            else if (right > left) {
                left = 0;
                right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            }
            else if (s.charAt(i) == ')') {
                right++;
            }
            if (left == right) {
                result = Math.max(result, 2 * left);
            }
            else if (left > right) {
                left = 0;
                right = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = ")()())";
        int result = solution.longestValidParentheses(s);
        System.out.println("输出：" + result); // 输出：4
    }
}