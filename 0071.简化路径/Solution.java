import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    // 栈法，抵消
    public String simplifyPath(String path) {
        String[] names = path.split("/");
        Deque<String> stack = new ArrayDeque<String>();
        for (String name : names) {
            if ("..".equals(name)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else if (name.length() > 0 && !".".equals(name)) {
                stack.push(name);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) {
            sb.append("/");
        }
        else {
            // 最后需要从栈底部开始到顶部取元素
            // 所以用deque
            while (!stack.isEmpty()) {
                sb.append("/");
                sb.append(stack.peekLast());
                stack.removeLast();
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.simplifyPath("/home/");
    }
}