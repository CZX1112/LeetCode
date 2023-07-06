class Solution {
    private int MIN = Integer.MIN_VALUE, MAX = Integer.MAX_VALUE;
    private int LIMIT = MIN / 2;
    public int divide(int dividend, int divisor) {
        if (dividend == MIN && divisor == -1) {
            return MAX;
        }
        boolean flag = false;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            flag = true;
        }
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }
        int ans = 0;
        while (dividend <= divisor) {
            int temp = divisor, multiple = -1;
            while (temp >= LIMIT && dividend <= 2 * temp) {
                temp += temp;
                multiple += multiple;
            }
            dividend -= temp;
            ans += multiple;
        }
        return flag ? ans : -ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int dividend = 7;
        int divisor = -3;
        int result = solution.divide(dividend, divisor);
        System.out.println("Input: dividend = " + dividend + ", divisor = " + divisor);
        System.out.println("Output: " + result);
    }
}