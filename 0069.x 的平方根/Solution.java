class Solution {
    // 法一：袖珍计算器算法
    // public int mySqrt(int x) {
    //     if (x == 0) {
    //         return x;
    //     }
    //     int ans = (int) Math.exp(0.5 * Math.log(x));
    //     return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    // }

    // 法二：牛顿法
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.mySqrt(16);
        System.out.println("result = " + result);
    }
}