class Solution {
    // 快速幂+迭代算法
    public double myPow(double x, int n) {
        long N = n;
        double result = 1.0;
        if (N < 0) {
            N = -N;
            x = 1.0 / x;
        }
        while (N > 0) {
            if (N % 2 == 1) {
                result *= x;
            }
            x *= x;
            N /= 2;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        double result = sol.myPow(2, 10);
        System.out.println(result);
    }
}