class Solution {
    // 斐波那契数列 动态规划
    public int climbStairs(int n) {
        int front = 0, frofront = 0;
        int sum = 1;
        for (int i = 0; i < n; i++) {
            frofront = front;
            front = sum;
            sum = front + frofront;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.climbStairs(3);
        System.out.println("result = " + result);
    }
}